package group.lin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group.lin.base.BaseDAO;
import group.lin.entity.UserDAO;
import group.lin.entity.ChatRecordDAO;
import group.lin.entity.ContactDAO;
import group.lin.entity.TaskCDAO;
import group.lin.entity.TaskDAO;

public class QueryConsentDAO extends BaseDAO {
	private static QueryConsentDAO rd = null;
	
	public static synchronized QueryConsentDAO getInstance() {
		if(rd == null) {
			rd = new QueryConsentDAO();
		}
		return rd;
	}
	

	public String[][] queryApply(UserDAO user) {
		String[][] result = null;
		int i = 0;
		//如何判断是否有useID？
		if(user.getUserId() == null) {
			return result;
		}
		
		List<TaskCDAO> list = new ArrayList<TaskCDAO>(); 
		String sql="select * from TaskConfirm where Receiver=?";
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
	private void buildResult(String[][] result, List<TaskCDAO> list, int j) {
		// TODO Auto-generated method stub
		TaskCDAO cr = list.get(j);
		
		
		result[j]= new String[4];
		result[j][0] = cr.getSender();
		result[j][1] = cr.getReceiver();
		result[j][2] = cr.getTitle();
		result[j][3] = String.valueOf(cr.getConsent());		
	
		
	}

	//将rs中的记录放到ChatRecordList中。
	private void buildList(ResultSet rs, List<TaskCDAO> list, int i) throws SQLException {
		// TODO Auto-generated method stub
		TaskCDAO cr = new TaskCDAO();
		
		cr.setSender(rs.getString("Sender"));
		cr.setReceiver(rs.getString("Receiver"));
		cr.setTitle(rs.getString("Title"));
		cr.setConsent(rs.getInt("Consent"));
	
		list.add(cr);
		
	}

}
