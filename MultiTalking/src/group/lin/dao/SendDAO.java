package group.lin.dao;

import java.sql.SQLException;

import group.lin.base.BaseDAO;
import group.lin.entity.ChatRecordDAO;
//import group.lin.entity.UserDAO;

public class SendDAO extends BaseDAO {
	private static SendDAO sd = null;
	
	public static synchronized SendDAO getInstance() {
		if(sd == null) {
			sd = new SendDAO();
		}
		return sd;
	}
	
	public boolean addChatRecord(ChatRecordDAO record) throws SQLException {
		boolean result = false;
		
		if(record.getSenderId() == 0 || record.getReceiverId() == 0) {
			return result;
		}
		String sql="INSERT INTO `multiTalking`.`CHATRECORD` (`senderId`, `receiverId`, `time`, `content`) VALUES (?, ?, ?, ?)";
		Object[] param = {record.getSenderId(),record.getReceiverId(),new java.sql.Date(0).getTime(),record.getContent()};
		
		try {
			if(db.executeUpdate(sql, param) != -1) {
				result = true;
			}
		} finally {
			destroy();
		}
		
		return result;
	}

}
