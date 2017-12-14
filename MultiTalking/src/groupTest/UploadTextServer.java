package groupTest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文本文件接收的服务器端
 * @author 陈浩翔
 *
 * 2016-5-10
 */
public class UploadTextServer {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(10006);

            Socket s = server.accept();
            System.out.println(s.getInetAddress().getHostAddress()+"...发送消息来");

            //读取客户端上传过来的文本文件
            //源 ---socket(字节流)---额外：需要转换成字符流  ，缓存流
            InputStream in  = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            //目的 ---硬盘字符流 FileWriter---额外：打印流
            PrintWriter pw = new PrintWriter(new FileWriter("server.zip"),true);
            String line = null;
            while((line=br.readLine())!=null){
//              if("over#$@#@$".equals(line)){//自己定义的结束标志
//              break;
//          }
                pw.println(line);
                pw.flush();
            }

            pw.close();

            //上传成功，给客户端一个提示信息

            OutputStream out = s.getOutputStream();
            DataOutputStream dout = new DataOutputStream(out);
            dout.writeUTF("文件上传成功！");
            s.close();
            server.close();
            dout.close();


        } catch (IOException e) {
            e.printStackTrace();
        }




    }

}