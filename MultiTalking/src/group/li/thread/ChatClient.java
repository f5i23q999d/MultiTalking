package group.li.thread;

import java.io.*;

import java.net.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

import group.li.ContactPanel;
import group.li.IDTextPane;
import group.li.ListPanel;
import group.li.UI;

public class ChatClient {
	
	static Socket socket;
	
	public void SendAMessage(String name,String context)
	{
		
		SendMessage t=new SendMessage(socket,name,context);
		Thread tt = new Thread(t);
		tt.start();
		//System.err.println("发送消息"+context);
		
	}
	
	
	public static void main(String[] args) throws Exception {

		//socket=new Socket("127.0.0.1", 6666);
		socket=new Socket("123.207.117.122", 6666);
		
	
		String name= UI.ID;
		System.out.println("客户端已经链接.....");
		
		CTSendID t=new CTSendID(socket,name);
		Thread tt = new Thread(t);
		tt.start();
		
		
		CTGetMessage g = new CTGetMessage(socket);
		CTSendMessage s = new CTSendMessage(socket,name);
		
		
		
		Thread gt = new Thread(g);
		Thread st = new Thread(s);
		
		
		
		gt.start();
		st.start();
	}
}


class CTGetMessage implements Runnable {
	private Socket socket;
	private BufferedReader bufferedReader;

	public CTGetMessage(Socket socket) {
		this.socket = socket;
		InputStreamReader r = null;
		try {
			r = new InputStreamReader(this.socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		};
		this.bufferedReader = new BufferedReader(r);
	}

	
	public String getID(String jj)
	{
		
		String tmp="";
		int i=0;
		for(;i<jj.length()-1;i++)
		{
			if(jj.charAt(i+1)!=':')
					tmp+=jj.charAt(i);
			else
				break;
		
		}
		tmp+=jj.charAt(i);
		return tmp;
		
	}
	
	public String getContent(String jj)
	{
		
		String tmp="";
		int i=0;
		for(;i<jj.length()-1;i++)
		{
			if(jj.charAt(i)==':')
			{
				for(int j=i+1;j<jj.length();j++)
					tmp=tmp+jj.charAt(j);
				break;
			
			}
		}
		
		return tmp;
		
	}
	
	
	
	public void run() {
		String msg = null;
		while (true) {
			try {
				msg = this.bufferedReader.readLine();
				
				if(getContent(msg).equals("*"))
				{
					UI.CP=new ContactPanel(UI.ID);//刷新好友面板
					JOptionPane.showMessageDialog(null,UI.ID+"已同意好友申请!");
					
				}
				else	if(getContent(msg).equals("/"))
					{
						//System.err.println("收到信息:"+msg);
						UI.CP=new ContactPanel(UI.ID);//刷新好友面板
						JOptionPane.showMessageDialog(null,"有人拉你入群!");
						
					}
				else	if(!msg.equals("对方没上线"))
				{
				boolean exist=false;
				for(int i=0;i<UI.list.size();i++)
					if(UI.list.get(i).getName().equals(getID(msg)))
							exist=true;
				
				if(!exist)
				{
					UI.list.add(new ListPanel(getID(msg)));
					UI.list.get(UI.list.size()-1).setContext(getContent(msg));
				}
				UI.pageSwitch(0);
				
				
				//UI.panel_2.nameTitle.setText(getID(msg));	
					
				//UI.panel_2.textPane.append(msg+"\r\n");
				
				exist=false;
				int tmp=0;
				
					//System.err.println("getid:"+getID(msg));//谁发的
					
					UI.panel_2.nameTitle.setText(getID(msg));
					
				for(int i=0;i<UI.panel_2.list.size();i++)
					if(UI.panel_2.list.get(i).ID.equals(getID(msg)))
							{exist=true;tmp=i;break;}
				
				if(!exist)
					{
						UI.panel_2.list.add(new IDTextPane(getID(msg)));
						UI.panel_2.list.get(UI.panel_2.list.size()-1).ID=getID(msg);
						UI.panel_2.list.get(UI.panel_2.list.size()-1).append(msg);
						
						UI.panel_2.textPane.setText(UI.panel_2.list.get(UI.panel_2.list.size()-1).getText());
						
						System.out.println("1111111111");
					}
				else
					{							
						System.out.println("2222222222222");
						UI.panel_2.list.get(tmp).append("\r\n");
						UI.panel_2.list.get(tmp).append(msg);
						UI.panel_2.textPane.setText(UI.panel_2.list.get(tmp).getText());
					}
				}
				
				System.out.println(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}

class CTSendMessage implements Runnable {
	private Socket socket;
	private PrintWriter printWriter;
	private BufferedReader bufferedReader;
	private String name;
	public CTSendMessage(Socket socket,String name) {
		this.name=name;
		this.socket = socket;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			bufferedReader = new BufferedReader(isr);
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			this.printWriter = new PrintWriter(bw, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		//System.out.println("in CTSendMessage");
		String msg = null;
		while (true) {
			try {
				msg =name+":"+ bufferedReader.readLine();
				printWriter.println(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}

class CTSendID implements Runnable {
	private Socket socket;
	private PrintWriter printWriter;
	private BufferedReader bufferedReader;
	private String name;
	public CTSendID(Socket socket,String name) {
		this.name=name;
		this.socket = socket;
		try {
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			this.printWriter = new PrintWriter(bw, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		//System.out.println("in CTSendID");
		String msg = null;
	
		
			try {
				msg =name;
				printWriter.println(msg);
				//System.err.println("发送id:"+msg);
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		

	}
}

class SendMessage implements Runnable {
	private Socket socket;
	private PrintWriter printWriter;
	private BufferedReader bufferedReader;
	private String name;
	private String context;
	public SendMessage(Socket socket,String name,String context) {
		this.name=name;
		this.context=context;
		this.socket = socket;
		try {
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			this.printWriter = new PrintWriter(bw, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		//System.out.println("in CTSendID");
		String msg = null;
	
		
			try {
				msg =name;
				printWriter.println(context+"@"+name);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		

	}
}