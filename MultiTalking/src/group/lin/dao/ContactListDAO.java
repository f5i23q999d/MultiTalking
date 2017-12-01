package group.lin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group.lin.base.BaseDAO;
import group.lin.entity.UserDAO;
import group.lin.entity.ChatRecordDAO;
import group.lin.entity.ContactDAO;

public class ContactListDAO extends BaseDAO {
	private static ContactListDAO rd = null;
	
	public static synchronized ContactListDAO getInstance() {
		if(rd == null) {
			rd = new ContactListDAO();
		}
		return rd;
	}
	

	public String[][] queryForContactList(UserDAO user) {
		String[][] result = null;
		int i = 0;
		//如何判断是否有useID？
		if(user.getUserId() == null) {
			return result;
		}
		
		List<ContactDAO> list = new ArrayList<ContactDAO>(); 
		String sql="select receiverId,GroupName from CONTACT where accept=1 and senderId=?";
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
	private void buildResult(String[][] result, List<ContactDAO> list, int j) {
		// TODO Auto-generated method stub
		ContactDAO cr = list.get(j);
		
		
		result[j]= new String[2];
		result[j][0] = cr.getReceiverId();
		result[j][1] = cr.getGroupName();
	
		
	}

	//将rs中的记录放到ChatRecordList中。
	private void buildList(ResultSet rs, List<ContactDAO> list, int i) throws SQLException {
		// TODO Auto-generated method stub
		ContactDAO cr = new ContactDAO();
		
		cr.setReceiverId(rs.getString("receiverid"));
		cr.setGroupName(rs.getString("GroupName"));
		list.add(cr);
		
	}

}
