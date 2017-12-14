package groupTest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 文本文件发送的客户端
 * @author 陈浩翔
 *
 * 2016-5-10
 */
public class UploadTextClient {

    public static void main(String[] args) {

        try {
            Socket s = new Socket("127.0.0.1", 10006);
            
            
            
            FileReader file = null;
            try {
	            	file = new FileReader("Desktop.zip");            	
            } catch (java.io.FileNotFoundException e) {
            		System.out.println("file can't found");
            }
            

            //思路：把本地文件的数据读取出来通过 s.getOutputStream()获得的out对象发送出去
            BufferedReader bf = new BufferedReader(file);

            OutputStream out = s.getOutputStream();//这里的输出流 对应的是服务器端的输入流
            PrintWriter pw = new PrintWriter(out,true);//建议不要用BufferedWriter
            //!!!!!!!!!!!!!!!!!这个true不要忘了！---自动刷新
            //现在大家写网络传输文件，一般是用PrintWriter

            String str=null;
            while((str=bf.readLine())!=null){
                pw.println(str);
                pw.flush();
            }
            
            //给服务器发送结束标记---上传结束，要加结束标记，
            //否则服务器在数据接收完毕时再调用read()或readLine()时会出异常
            //法1：pw.println("over#$@#@$");//不能出现文件中存在的结束关键字---搞特殊一点
            //法2---建议采用该种方式---由socket内部来指定结束标记
            s.shutdownOutput();
            bf.close();

            //接收服务器端反馈

            InputStream in = s.getInputStream();
            DataInputStream din = new DataInputStream(in);
            System.out.println("server应答:"+din.readUTF());
            s.close();
            din.close();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}