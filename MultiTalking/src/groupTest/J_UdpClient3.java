package groupTest;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class J_UdpClient3{
	
	static int len;
	
	 static String cutAddr(String all)
	{
		
		String tmp = "";
		int i;
		for(i=0;i<all.length();i++)
				if(all.charAt(i)!=':')
					tmp+=all.charAt(i);
				else
					break;
		len=i;			
		return tmp;

	}
	
	 static String cutPort(String all)
	{
		
		String tmp = "";
		for(int i=len+1;i<all.length();i++)
				tmp+=all.charAt(i);
							
		return tmp;
		
	
	}
		
		
	

	public static void main(String[] args)  {
		
		DatagramPacket inPacket;
		DatagramPacket outPacket;
		InetAddress sAddr;
		byte[] inBuffer=new byte[100];
		DatagramSocket dSocket;
		String tmp;
		
		
		try {
			dSocket = new DatagramSocket();
			sAddr=InetAddress.getByName("123.207.117.122");
			//sAddr=InetAddress.getByName("127.0.0.1");
			String s="请求连接";
			byte[] outBuffer=s.getBytes();
			outPacket=new DatagramPacket(outBuffer,outBuffer.length,sAddr,8000);
			dSocket.send(outPacket);
			
			System.out.println("已发送包裹");
			
			
			inPacket=new DatagramPacket(inBuffer,inBuffer.length);	
			dSocket.receive(inPacket);
			System.out.println("从服务器收到对方地址");
 			s=new String(inPacket.getData(),0,inPacket.getLength());
 			System.out.println("地址："+cutAddr(s));
 			System.out.println("端口："+cutPort(s));
 			
 			sAddr=InetAddress.getByName(cutAddr(s));
 			System.out.println("正在尝试与对方连接");
 			tmp="test";
 			outBuffer=tmp.getBytes();
 			outPacket=new DatagramPacket(outBuffer,outBuffer.length,sAddr,Integer.valueOf(cutPort(s)));
			dSocket.send(outPacket);

 			
			inPacket=new DatagramPacket(inBuffer,inBuffer.length);	
			dSocket.receive(inPacket);
 			System.out.println("连接成功");
 		
 			
 			
 			
 			
 			
 			Scanner sc=new Scanner(System.in);
			
			String str=null;
			System.out.print("请输入对话内容，回车结束:");
			str=sc.nextLine();
			outBuffer=str.getBytes();
 
			sAddr=InetAddress.getByName(cutAddr(s));
			outPacket=new DatagramPacket(outBuffer,outBuffer.length,sAddr,Integer.valueOf(cutPort(s)));
			dSocket.send(outPacket);
			System.out.println("已发送消息至另一客户端,请等待回复");
 			
			inPacket=new DatagramPacket(inBuffer,inBuffer.length);	
			dSocket.receive(inPacket);
 			s=new String(inPacket.getData(),0,inPacket.getLength());
 			System.out.println("收到另一客户端消息："+s);
 			System.out.println("结束");
 			//System.out.println("地址："+inPacket.getAddress().getHostAddress());
 			//System.out.println("端口："+inPacket.getPort());
			
			
 			
 			/*
 			Scanner sc=new Scanner(System.in);
			
			String str=null;
			System.out.print("请回复输入任意字符:");
			str=sc.nextLine();
			outBuffer=str.getBytes();
 			outPacket=new DatagramPacket(outBuffer,outBuffer.length,sAddr,8000);
 			dSocket.send(outPacket);
 			*/
 			
 			//dSocket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
