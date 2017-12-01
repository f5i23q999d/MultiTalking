package group.lin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group.lin.base.BaseDAO;
import group.lin.entity.UserDAO;
import group.lin.entity.ChatRecordDAO;
import group.lin.entity.ContactDAO;

public class QueryInfoDAO extends BaseDAO {
	private static QueryInfoDAO rd = null;
	
	public static synchronized QueryInfoDAO getInstance() {
		if(rd == null) {
			rd = new QueryInfoDAO();
		}
		return rd;
	}
	
	
	public String[][] queryForInfo(UserDAO user) {
		String[][] result = null;
		int i = 0;
		
		if(user.getUserId() == null) {
			return result;
		}
		
		List<UserDAO> list = new ArrayList<UserDAO>(); 
		String sql="select userId,name,information from USER";
		//Object[] param = {user.getUserId()};
		rs = db.executeQuery(sql);
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
	private void buildResult(String[][] result, List<UserDAO> list, int j) {
		// TODO Auto-generated method stub
		UserDAO cr = list.get(j);
		
		
		result[j]= new String[3];
		result[j][0] = cr.getUserId();
		result[j][1] = cr.getName();
		result[j][2] = cr.getPersonalInformation();
	
		
	}

	//将rs中的记录放到ChatRecordList中。
	private void buildList(ResultSet rs, List<UserDAO> list, int i) throws SQLException {
		// TODO Auto-generated method stub
		UserDAO cr = new UserDAO();
		cr.setUserId(rs.getString("userID"));
		cr.setName(rs.getString("name"));
		cr.setPersonalInformation(rs.getString("information"));
		list.add(cr);
		
	}

}
