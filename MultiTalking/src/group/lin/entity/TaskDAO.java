package group.lin.entity;

public class TaskDAO {
	protected String Sender;
	protected String Receiver;
	protected String Title;

	protected String Time;
	protected String context;
	protected String attachment;
	protected int State;
	
	
	public int getState() {
		return State;
	}
	public void setState(int state) {
		State = state;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getSender() {
		return Sender;
	}
	public void setSender(String sender) {
		Sender = sender;
	}
	public String getReceiver() {
		return Receiver;
	}
	public void setReceiver(String receiver) {
		Receiver = receiver;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	

}
