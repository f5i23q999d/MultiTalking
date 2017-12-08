package group.li.thread;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatThread implements Runnable{

	private List<Socket> socketList;
	private Socket socket;
	private BufferedReader bufferedReader;
	private String IDname;
	public ChatThread(Socket socket,List<Socket> socketList){
		this.socket=socket;
		this.socketList=socketList;
	}
	
	private void checkIDUpLine() {

//		synchronized(ChatServer.news) {

			if (ChatServer.news.containsKey(IDname)) {				
				List<String> chartList = (List<String>) ChatServer.news.get(IDname);
				PrintWriter pw = this.getSocketPrintWriter(socket);
				for (String chart : chartList) {
					pw.println(getContext(chart));
				}
				ChatServer.news.remove(IDname);
			} else {
				/*
				PrintWriter pw = this.getSocketPrintWriter(socket);
				pw.println("NONE MISSING MESSAGE TO YOU");
				*/
			}

			
//		}
		
	}
	
	private void saveChat(String msg) {
//		synchronized(ChatServer.news) {
			String id = getDest(msg);
			List<String> chartList = null;
			
			if(ChatServer.news.containsKey(id)) {
				chartList = (List<String>) ChatServer.news.get(id);
				chartList.add(msg);
			} else {
				chartList = new ArrayList<String>();
				chartList.add(msg);
			}
			
			ChatServer.news.put(id, chartList);
//		}
		
	}
	
	private void  preRun(){
		//System.out.println("INpreRUn");
		InputStreamReader r=null;
		try {
			r = new InputStreamReader(this.socket.getInputStream());
			this.bufferedReader=new BufferedReader(r);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void  prepreRun(){
		//System.out.println("INprepreRUn");
		InputStreamReader r=null;
		try {
			
			r = new InputStreamReader(this.socket.getInputStream());
			this.bufferedReader=new BufferedReader(r);	
			IDname=bufferedReader.readLine();
			ChatServer.map.put(IDname, this.socket);
			//Socket t=(Socket)ChatServer.map.get(IDname);
			//System.out.println("用户："+bufferedReader.readLine()+"已连接，socket为"+t.getInetAddress().getHostAddress()+" port:"+t.getPort());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private PrintWriter getSocketPrintWriter(Socket socket){
		OutputStream os=null;
		try {
			os = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		OutputStreamWriter osw=new OutputStreamWriter(os);
		BufferedWriter bw=new BufferedWriter(osw);
		return new PrintWriter(bw, true);
	}
	private void broadcast(String msg){
		for(Socket s:socketList){
			PrintWriter pw=this.getSocketPrintWriter(s);
			pw.println(msg);
		}
	}
	//私聊
	private void broadcastTo(String msg){
			System.out.println("in bc:"+msg);
		
			String id=getDest(msg);
		
			Socket s=(Socket)ChatServer.map.get(id);
			
			if(s==null)
			{
				Socket s1=(Socket)ChatServer.map.get(IDname);
				PrintWriter pw1=this.getSocketPrintWriter(s1);
				pw1.println("对方没上线");
				
				//
				saveChat(msg);
				return;
			}
			PrintWriter pw=this.getSocketPrintWriter(s);
			
			pw.println(getContext(msg));
		
	}
	
	//群聊
	private void broadcastToGroup(String msg,String groupName,String []groupMember){
		
	
		String id=getDest(msg);
	
		Socket s=(Socket)ChatServer.map.get(id);
		
		if(s==null)
		{
			Socket s1=(Socket)ChatServer.map.get(IDname);
			PrintWriter pw1=this.getSocketPrintWriter(s1);
			pw1.println("对方没上线");
			
			//
			saveChat(msg);
			return;
		}
		PrintWriter pw=this.getSocketPrintWriter(s);
		
		pw.println(getContext(msg));
	
}
	
	
	public String getContext(String jj)
	
	{
		
		String tmp="";
		int i=0;
		for(;i<jj.length()-1;i++)
		{
			if(jj.charAt(i+1)!='@')
					tmp+=jj.charAt(i);
			else
				break;
		
		}
		tmp+=jj.charAt(i);
		return tmp;
		
		
		
	}
	
	public String getDest(String jj)
	{
		String tmp="";
		for(int i=0;i<jj.length();i++)
			if(jj.charAt(i)=='@')
				for(int j=i+1;j<jj.length();j++)
					tmp+=jj.charAt(j);
		
		return tmp;
		
		
		
	}
	
	
	public void run() {
		String msg="";
		this.prepreRun();
		this.preRun();
		
		//
		checkIDUpLine();
		
		while(true){
			try {
				
				msg=IDname+":"+this.bufferedReader.readLine();
				this.broadcastTo(msg);
			} catch (IOException e) {
				try {
					this.bufferedReader.close();
					this.socket.close();
					this.socketList.remove(this.socket);
					/*
					this.broadcast("somebody exist....people size :"
					              +socketList.size());
					              */
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
				return ;
			}
		}
	}
}
