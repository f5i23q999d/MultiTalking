package group.lin.entity;

import java.io.Serializable;

//import sun.util.calendar.LocalGregorianCalendar.Date;

public class ChatRecordDAO implements Serializable{
	protected String senderId,receiverId;
	//不知道java.sql.Dat是不是好的？但LIN已用了40四十分钟，欢迎提意见。
	protected java.sql.Date time;
	protected String content;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public java.sql.Date getTime() {
		return time;
	}
	public void setTime(java.sql.Date time) {
		this.time = time;
	}
	
}
