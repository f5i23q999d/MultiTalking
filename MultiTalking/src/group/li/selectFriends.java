package group.li;

import javax.swing.JFrame;

import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import group.lin.util.DBUtil;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class selectFriends extends JFrame{
	
	static ArrayList<JCheckBox> JB=new ArrayList<JCheckBox>();
	JCheckBox chckbxNewCheckBox;
	private JTextField groupName;
	
	
	public selectFriends() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBUtil db=DBUtil.getDBUtil();
				String sql="insert into GROUPS values (null,?,?)";
				Object []obj={UI.ID,groupName.getText()};
				db.executeUpdate(sql,obj);
				
				//查询刚新建的groupID
				db=DBUtil.getDBUtil();
				sql="select groupid from GROUPS where name='"+groupName.getText()+"'";
				ResultSet rs=db.executeQuery(sql);
				try {
					rs.next();
					int gID=Integer.valueOf(rs.getString(1));
					
					for(int i=0;i<JB.size();i++)
						if(JB.get(i).isSelected()==true)
						{
							//System.out.println(JB.get(i).toString());
							sql="insert into GROUP_USER values (?,?)";
							Object []obj2={JB.get(i).getText(),gID};
							db.executeUpdate(sql,obj2);
							
							UI.thread.SendAMessage(JB.get(i).getText(),"/");
						}
					
					//UI.CP=new ContactPanel(UI.ID);//刷新好友面板
					
					JOptionPane.showMessageDialog(null,"创建群聊成功!");
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
						
				
				
			}
		});
		btnNewButton.setBounds(255, 158, 93, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("起个名字：");
		lblNewLabel.setBounds(214, 38, 93, 15);
		getContentPane().add(lblNewLabel);
		
		groupName = new JTextField();
		groupName.setBounds(219, 98, 215, 21);
		getContentPane().add(groupName);
		groupName.setColumns(10);
		
		
		System.out.println("UI.CP.record.length:"+UI.CP.Frirecord.length);
		int i=0;
		//自己也加上
		chckbxNewCheckBox = new JCheckBox(UI.ID);
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(0, 25*i, 100, 25);
		JB.add(chckbxNewCheckBox);
		getContentPane().add(chckbxNewCheckBox);
		
		for(i=1;i<UI.CP.Frirecord.length;i++)
		{
					chckbxNewCheckBox = new JCheckBox(UI.CP.Frirecord[i][0]);
					chckbxNewCheckBox.setBounds(0, 25*i, 100, 25);
					JB.add(chckbxNewCheckBox);
					getContentPane().add(chckbxNewCheckBox);
					
		}
		
		
		
		
		
	}
}
