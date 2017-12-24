package group.lin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group.lin.base.BaseDAO;
import group.lin.entity.UserDAO;
import group.lin.entity.ChatRecordDAO;
import group.lin.entity.ContactDAO;
import group.lin.entity.TaskDAO;

public class QueryApplyDAO extends BaseDAO {
	private static QueryApplyDAO rd = null;
	
	public static synchronized QueryApplyDAO getInstance() {
		if(rd == null) {
			rd = new QueryApplyDAO();
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
		
		List<TaskDAO> list = new ArrayList<TaskDAO>(); 
		String sql="select * from Task where Receiver=?";
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
	private void buildResult(String[][] result, List<TaskDAO> list, int j) {
		// TODO Auto-generated method stub
		TaskDAO cr = list.get(j);
		
		
		result[j]= new String[7];
		result[j][0] = cr.getSender();
		result[j][1] = cr.getReceiver();
		result[j][2] = cr.getTime();
		result[j][3] = cr.getContext();
		result[j][4] = cr.getAttachment();
		result[j][5] = cr.getTitle();
		result[j][6] = String.valueOf(cr.getState());		
	
		
	}

	//将rs中的记录放到ChatRecordList中。
	private void buildList(ResultSet rs, List<TaskDAO> list, int i) throws SQLException {
		// TODO Auto-generated method stub
		TaskDAO cr = new TaskDAO();
		
		cr.setSender(rs.getString("Sender"));
		cr.setReceiver(rs.getString("Receiver"));
		cr.setTime(rs.getString("Time"));
		cr.setContext(rs.getString("Context"));
		cr.setAttachment(rs.getString("Attachment"));
		cr.setTitle(rs.getString("Title"));
		cr.setState(rs.getInt("State"));
		list.add(cr);
		
	}

}
