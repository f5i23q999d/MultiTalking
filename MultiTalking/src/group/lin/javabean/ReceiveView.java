package group.lin.javabean;

import group.lin.dao.ReceiveDAO;
import group.lin.entity.ChatRecordDAO;
import group.lin.entity.UserDAO;

public class ReceiveView {
	private ChatRecordDAO crE;
	private String[][] chatRecordList = null;

	public String[][] getChatRecordList() {
		return chatRecordList;
	}

	public void setChatRecordList(UserDAO user) {
		ReceiveDAO rd = new ReceiveDAO();
		chatRecordList = rd.queryForChatRecord(user);
	}

	public ChatRecordDAO getCrE() {
		return crE;
	}

	public void setCrE(ChatRecordDAO crE) {
		this.crE = crE;
	}	

}
