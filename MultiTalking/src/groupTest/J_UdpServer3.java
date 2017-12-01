package groupTest;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.Scanner;

public class J_UdpServer3{
	

	

	public static void main(String[] args) {
		
	DatagramSocket dSocket;
	DatagramPacket inPacket;
	DatagramPacket outPacket;
	InetAddress cAddr1;
	int cPort1;
	InetAddress cAddr2;
	int cPort2;
	
	
	
	byte[] inBuffer=new byte[100];
	byte[] outBuffer=new byte[100];
	String s;
	int sr;
		try 
		{
			
			
			
				dSocket =new DatagramSocket(8000);
			
				inPacket= new DatagramPacket(inBuffer,inBuffer.length);
				dSocket.receive(inPacket);
				System.out.println("第一个连接");
				cAddr1=inPacket.getAddress();
				cPort1=inPacket.getPort();
				s=new String(inPacket.getData(),0,inPacket.getLength());
				System.out.println("接收到客户端信息："+s);
				System.out.println("客户端主机名为："+cAddr1.getHostName());
				System.out.println("接收到客户端接口："+cPort1);
				
				
				inPacket= new DatagramPacket(inBuffer,inBuffer.length);
				dSocket.receive(inPacket);
				System.out.println("第二个连接");
				cAddr2=inPacket.getAddress();
				cPort2=inPacket.getPort();
				s=new String(inPacket.getData(),0,inPacket.getLength());
				System.out.println("接收到客户端信息："+s);
				System.out.println("客户端主机名为："+cAddr2.getHostName());
				System.out.println("接收到客户端接口："+cPort2);
		
				
				
				System.out.println("交换数据");
				
				s=cAddr2.getHostName()+":"+cPort2;
				outBuffer=s.getBytes();
				outPacket=new DatagramPacket(outBuffer,outBuffer.length,cAddr1,cPort1);
				dSocket.send(outPacket);
				
				s=cAddr1.getHostName()+":"+cPort1;
				outBuffer=s.getBytes();
				outPacket=new DatagramPacket(outBuffer,outBuffer.length,cAddr2,cPort2);
				dSocket.send(outPacket);
				
				//Date d=new Date();
				//outBuffer=d.toString().getBytes();
				/*
				Scanner sc=new Scanner(System.in);
			
				String str=null;
				System.out.print("请输入任意字符:");
				str=sc.nextLine();
				outBuffer=str.toString().getBytes();
				outPacket=new DatagramPacket(outBuffer,outBuffer.length,cAddr,cPort);
				dSocket.send(outPacket);
				
			*/
			
			
			
			
		} 
		
		catch (SocketException e) 
		
		{
		
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
