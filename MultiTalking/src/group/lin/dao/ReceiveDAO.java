package group.lin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group.lin.base.BaseDAO;
import group.lin.entity.UserDAO;
import group.lin.entity.ChatRecordDAO;

public class ReceiveDAO extends BaseDAO {
	private static ReceiveDAO rd = null;
	
	public static synchronized ReceiveDAO getInstance() {
		if(rd == null) {
			rd = new ReceiveDAO();
		}
		return rd;
	}
	
	//返回聊天记录的查询结果。
	public String[][] queryForChatRecord(UserDAO user) {
		String[][] result = null;
		int i = 0;
		//如何判断是否有useID？
		if(user.getUserId() == null) {
			return result;
		}
		
		List<ChatRecordDAO> list = new ArrayList<ChatRecordDAO>(); 
		String sql="select senderId,time,contant from CHATRECORD where receiveId=? ";
		Object[] param = {user.getUserId()};
		rs = db.executeQuery(sql, param);
		try{
			while(rs.next()) {
				buildList(rs, list, i);
				i++;
			}
			if(list.size() > 0) {
				result = new String[list.size()][];
				for(int j = 0; j < list.size(); j++) {
					buildResult(result, list, j);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroy();
		}
		
		return result;
	}

	//将list值放到result中。
	private void buildResult(String[][] result, List<ChatRecordDAO> list, int j) {
		// TODO Auto-generated method stub
		ChatRecordDAO cr = list.get(j);
		result[j][0] = String.valueOf(cr.getSenderId());
		result[j][1] = String.valueOf(cr.getTime());
		result[j][2] = cr.getContent();
		
	}

	//将rs中的记录放到ChatRecordList中。
	private void buildList(ResultSet rs, List<ChatRecordDAO> list, int i) throws SQLException {
		// TODO Auto-generated method stub
		ChatRecordDAO cr = new ChatRecordDAO();
		cr.setSenderId(rs.getInt("senderId"));
		cr.setTime(rs.getDate("time"));
		cr.setContent(rs.getString("content"));
		list.add(cr);
		
	}

}
