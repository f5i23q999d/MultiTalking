package groupTest;

import java.sql.ResultSet;
import java.sql.SQLException;

import group.lin.dao.ContactListDAO;
import group.lin.dao.GroupsInfoDAO;
import group.lin.dao.ReceiveDAO;
import group.lin.entity.UserDAO;
import group.lin.util.DBUtil;

public class RecordQuery {

	public static void main(String[] args) {
		/*
		String record[][];
		UserDAO t=new UserDAO();
		t.setUserId("Chen");
		ReceiveDAO r=new ReceiveDAO();
		record=r.queryForChatRecord(t);
		for(int a=0;a<record.length;a++)
			
			System.out.println("sender:"+record[a][0]+"	time:"+record[a][1]+" context:"+record[a][2]);
		
		*/
		/*
		String record[][];
		UserDAO t=new UserDAO();
		t.setUserId("Kiux");
		ContactListDAO r=new ContactListDAO();
		record=r.queryForContactList(t);
		for(int a=0;a<record.length;a++)
			
			System.out.println("receiverid:"+record[a][0]+"	group:"+record[a][1]);
		*/
		
		/*
		String record[][];
		UserDAO t=new UserDAO();
		t.setUserId("Ass");
		GroupsInfoDAO r=new GroupsInfoDAO();
		record=r.queryForGroup(t);
		for(int a=0;a<record.length;a++)
			
			System.out.println("name:"+record[a][1]+"groupid:"+record[a][2]);
		*/
		
		
		String a="sdoasndoasnd@a";
		String []aa=a.split("/");
		
		for(int i=0;i<aa.length;i++)
		{
			System.out.println(aa[i]);
			System.out.println("aa.length"+aa.length);
		
		}
		/*
		DBUtil db=DBUtil.getDBUtil();
		ResultSet a=db.executeQuery("select * from USER");
		try {
			while(a.next())
			{
				System.out.println(a.getString(1));
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

	}

}
