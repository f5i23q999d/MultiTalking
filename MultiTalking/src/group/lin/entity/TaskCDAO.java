package group.lin.entity;

public class TaskCDAO {
	protected String Sender;
	protected String Receiver;
	protected String Title;
	protected int consent;
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
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getConsent() {
		return consent;
	}
	public void setConsent(int consent) {
		this.consent = consent;
	}

}
