package group.linzx.personInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import group.li.UI;

public class GetImageFromServer {

	public static void main(String[] args) {
		/*String imgUrl = "http://123.207.117.122/UsersPortraits/b.JPG";// 图片地址
		try {
			// 构造URL
			URL url = new URL(imgUrl);
			// 打开连接
			URLConnection con = url.openConnection();
			// 输入流
			InputStream is = con.getInputStream();
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			OutputStream os = new FileOutputStream("c:\\image1.jpg");// 保存路径
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();
			System.out.println("close");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}
	// TODO Auto-generated method stub

	/*
	 * 从网络上读取图片
	 * 
	 */
	public static String getImageFromServer(String imgUrl) {
		// String imgUrl="";//图片网络地址
		String localURL="C://Multitalking123_207_117_122/portraits/"+UI.ID+"0.jpg";//
		try {

			if (!(new File("C://Multitalking123_207_117_122/portraits").isDirectory())) {
				new File("C://Multitalking123_207_117_122/portraits").mkdirs();
			}
			
			if(imgUrl==null)
				return null;
			
			// 构造URL
			URL url = new URL(imgUrl);
			
			// 打开连接
			URLConnection con = url.openConnection();
			// 输入流
			InputStream is = con.getInputStream();
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			OutputStream os = new FileOutputStream(localURL);// 保存路径
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return localURL;
	}
}
