package group.lin.javabean;

import java.sql.SQLException;

import group.lin.dao.SendDAO;
import group.lin.entity.ChatRecordDAO;

public class SendView {
	private ChatRecordDAO cr;

	public ChatRecordDAO getCr() {
		return cr;
	}

	public void setCr(ChatRecordDAO cr) {
		this.cr = cr;
	}
	
	public boolean sendChatRecord() {
		boolean result = false;
		SendDAO sd = new SendDAO();
		try {
			if(sd.addChatRecord(cr)) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

}