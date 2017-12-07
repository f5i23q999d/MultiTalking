package group.lin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group.lin.base.BaseDAO;
import group.lin.entity.UserDAO;
import group.lin.entity.ChatRecordDAO;
import group.lin.entity.ContactDAO;
import group.lin.entity.GroupDAO;

public class GroupsInfoDAO extends BaseDAO {
	private static GroupsInfoDAO rd = null;
	
	public static synchronized GroupsInfoDAO getInstance() {
		if(rd == null) {
			rd = new GroupsInfoDAO();
		}
		return rd;
	}
	

	public String[][] queryForGroup(UserDAO user) {
		String[][] result = null;
		int i = 0;
		//如何判断是否有useID？
		if(user.getUserId() == null) {
			return result;
		}
		
		List<GroupDAO> list = new ArrayList<GroupDAO>(); 
		String sql="select *from groupsview where userid=?";
		Object[] obj={user.getUserId()};
		rs = db.executeQuery(sql,obj);
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
	
	
	public String[][] queryForUser(String Gname) {
		String[][] result = null;
		int i = 0;
		//如何判断是否有useID？
	
		
		List<GroupDAO> list = new ArrayList<GroupDAO>(); 
		String sql="select *from groupsview where name=?";
		Object[] obj={Gname};
		
		rs = db.executeQuery(sql,obj);
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
	
	
	
	
	public String[][] queryForAllgroup() {
		String[][] result = null;
		int i = 0;
	
		
		List<GroupDAO> list = new ArrayList<GroupDAO>(); 
		String sql="select *from groupsview";
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
	private void buildResult(String[][] result, List<GroupDAO> list, int j) {
	
		GroupDAO cr = list.get(j);
		
		
		result[j]= new String[4];
		result[j][0] = cr.getUserId();
		result[j][1] = cr.getGroupName();
		result[j][2] = cr.getFoundId();
		result[j][3] = String.valueOf(cr.getGroupId());
		
		
	}

	//将rs中的记录放到ChatRecordList中。
	private void buildList(ResultSet rs, List<GroupDAO> list, int i) throws SQLException {
	
		GroupDAO cr = new GroupDAO();
		
		cr.setUserId(rs.getString("userid"));
		cr.setGroupName(rs.getString("name"));
		cr.setFoundId(rs.getString("foundid"));
		cr.setGroupId(Integer.valueOf(rs.getString("groupid")));
		list.add(cr);
		
	}

}
