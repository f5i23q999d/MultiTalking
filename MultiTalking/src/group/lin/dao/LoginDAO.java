package group.lin.dao;

import java.sql.SQLException;

import group.lin.base.BaseDAO;
import group.lin.entity.UserDAO;

public class LoginDAO extends BaseDAO {
	private static LoginDAO ld = null ;
	
	public static synchronized LoginDAO getInstance() {
		if(ld == null) {
			ld = new LoginDAO();
		}
		return ld;
	}
	
	public boolean queryForUserName(String name) {
		boolean result = false;		
		
		String sql = "select * from USER where userId = ?";
		String[] param = {name};
		
		rs = db.executeQuery(sql, param);
		try {
			if(rs.next()) {
				if(name.equals(rs.getString("userID"))) {
					result = true;					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			destroy();
		}
		
		return result;
	}
	
	public boolean queryForPassword(String name, String password) {
		boolean result = false;
		
		String sql = "select * from USER where userId = ? and userPassword = ?";
		String[] param = {name, password};
		
		rs = db.executeQuery(sql, param);
		try {
			if(rs.next()) {
				if(password.equals(rs.getString("userPassword"))) {
					result = true;					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			destroy();
		}
		
		return result;
	}
	
	public boolean addUser(UserDAO user) {
		boolean result = false;
		
		String sql ="INSERT INTO `multiTalking`.`USER` (`userId`, `name`, `userPassword`) VALUES (?, ?, ?)";
		String[] param = {user.getUserId(), user.getName(), user.getUserPassword()};
		
		try {
			if(db.executeUpdate(sql, param) != -1)
				result = true;			
		} finally{
			destroy();
		}
		return result;
		
	}

}
