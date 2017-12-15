package group.li;

import javax.swing.JFrame;
import javax.swing.JTextField;

import group.lin.dao.QueryInfoDAO;
import group.lin.entity.UserDAO;
import group.lin.util.DBUtil;
import group.linzx.personInfo.GetImageFromServer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;

public class FriendAdd extends JFrame{
	static String ID;
	private JTextField IDInput;
	JButton Find;
	JButton apply;
	JLabel portrait;
	JLabel theID;
	JLabel theName;
	JLabel theInfo;
	
	public FriendAdd(String ID)
	{
		setResizable(false);
		getContentPane().setLayout(null);
		
		IDInput = new JTextField();
		IDInput.setBounds(28, 60, 215, 34);
		getContentPane().add(IDInput);
		IDInput.setColumns(10);
		
		JLabel describe = new JLabel("查找好友/群");
		describe.setBounds(37, 35, 119, 15);
		getContentPane().add(describe);
		
		Find = new JButton("查找");
		Find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String record[][];
				UserDAO u=new UserDAO();
				u.setUserId(IDInput.getText());//冗余
				QueryInfoDAO QI=new QueryInfoDAO();
				record=QI.queryForInfo(u);
				
				boolean exist=false;
				for(int a=0;a<record.length;a++)
				{	
					//System.out.println("userid:"+record[a][0]+"	name:"+record[a][1]+"    info:"+record[a][2]);
					if(record[a][0].equals(IDInput.getText()))
					{
						//System.out.println("更改前："+theID.getText()+"	"+theName.getText()+"     "+theInfo.getText());
						theID.setText(record[a][0]);
						theName.setText(record[a][1]);
						theInfo.setText(record[a][2]);
						ImageIcon  u2=new ImageIcon(GetImageFromServer.getImageFromServer(UI.getPortrait(record[a][0])));
						u2.setImage(u2.getImage().getScaledInstance(90, 90,Image.SCALE_DEFAULT));
						portrait.setIcon(u2);
						exist=true;
						//System.out.println("更改后："+theID.getText()+"	"+theName.getText()+"     "+theInfo.getText());
						
					}
				
				}
				
				if(!exist)
				{
					JOptionPane.showMessageDialog(null,"查无此人");
				}
				else
				{
				portrait.setVisible(true);
				theID.setVisible(true);
				theName.setVisible(true);
				theInfo.setVisible(true);
				apply.setVisible(true);
				repaint();
				}
				
			}
		});
		Find.setBounds(300, 65, 93, 23);
		getContentPane().add(Find);
		
		apply = new JButton("申请好友");
		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				applyFriend fa=new applyFriend(theID.getText());
				fa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				fa.setSize(400, 100);
				fa.setLocale(null);
				fa.setVisible(true);
				
				//DBUtil db=DBUtil.getDBUtil();
				//String sql="insert into CONTACT values (?,?,0,?)";
				//Object[] obj = {user.getUserId()};
				//db.executeQuery(sql, obj);
				
				
				
				
			}
		});
		apply.setBounds(121, 213, 93, 23);
		apply.setVisible(false);
		getContentPane().add(apply);
		
		portrait = new JLabel("这个是头像框");
		portrait.setBounds(28, 142, 90, 90);
		portrait.setVisible(false);
		getContentPane().add(portrait);
		
		theID = new JLabel("对方ID");
		theID.setBounds(121, 142, 272, 15);
		theID.setVisible(false);
		getContentPane().add(theID);
		
		theName = new JLabel("对方姓名");
		theName.setBounds(121, 167, 272, 15);
		theName.setVisible(false);
		getContentPane().add(theName);
		
		theInfo = new JLabel("对方个人信息");
		theInfo.setBounds(121, 188, 272, 15);
		theInfo.setVisible(false);
		getContentPane().add(theInfo);
		FriendAdd.ID=ID;
		
	}
}
