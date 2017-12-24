package group.linzx.personInfo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import group.li.ContactPanel;
import group.li.UI;
import group.lin.util.DBUtil;
/*
 * 调用该类显示、修改个人信息
 * 调用要求：必须告知该类调用的用户名称username
 */

public class showOtherPersonInfo {
	public static String ResetURL;
	public static int isnull = 0;
	public static JFrame Personframe;
	public static JLabel po;
	private JTextField tele;
	String temp1 = "";
	String temp2 = ""; // 存放编辑的文本框内容，用于按钮“apply”
	public String DBuserId = "";
	public String DBtele = "";
	public String DBintroduction = "";
	public String DBportrait="";
	public String DBdepartment="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showOtherPersonInfo window = new showOtherPersonInfo();
					window.Personframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public showOtherPersonInfo() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//String username="a";
		DBUtil db = DBUtil.getDBUtil();
		
		
		
		String[] o= {""};
	
		o[0]=UI.CP.tree.getLastSelectedPathComponent().toString();
		
		try {
			ResultSet rs = db.executeQuery("select * from USER where userId=?",o);
			if (rs.next()) {
				DBuserId = rs.getString(1);
				DBportrait=rs.getString(5);
				DBtele = rs.getString(6);
				DBintroduction = rs.getString(7);
				ResetURL=DBportrait;
				
			}
			
			rs = db.executeQuery("select * from CONTACT where receiverId=?",o);
			if (rs.next())
				DBdepartment=rs.getString(4);
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Personframe = new JFrame();
		Personframe.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 22));
		Personframe.getContentPane().setIgnoreRepaint(true);
		Personframe.getContentPane().setBackground(new Color(47, 79, 79));
		Personframe.setBounds(100, 100, 850, 580);
		Personframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Personframe.getContentPane().setLayout(null);
			/*if(isnull==0) {
				po.setIcon(new ImageIcon(GetImageFromServer.getImageFromServer("http://123.207.117.122/UsersPortraits/b.JPG")));//showPersonInfo.class.getResource("/icon/krystal.JPG")
				System.err.println(ResetURL);			
			}else {
				System.out.println("正在上传新图片");
			}*/
		
		
		JLabel UserName = new JLabel("Krystal");
		UserName.setFont(new Font("微软雅黑", Font.PLAIN, 37));
		UserName.setForeground(new Color(255, 255, 255));
		UserName.setBounds(442, 26, 172, 93);
		Personframe.getContentPane().add(UserName);
		UserName.setText(DBuserId);

		JLabel lblTel = new JLabel("Tel：");
		lblTel.setFont(new Font("微软雅黑", Font.BOLD, 22));
		lblTel.setForeground(new Color(255, 255, 255));
		lblTel.setBounds(195, 275, 85, 60);
		Personframe.getContentPane().add(lblTel);

		JLabel lblIntroduction = new JLabel("Introduction：");
		lblIntroduction.setForeground(Color.WHITE);
		lblIntroduction.setFont(new Font("微软雅黑", Font.BOLD, 22));
		lblIntroduction.setBounds(151, 322, 179, 65);
		Personframe.getContentPane().add(lblIntroduction);

		JTextArea introduction = new JTextArea();
		introduction.setEditable(false);
		introduction.setBounds(316, 347, 226, 93);
		Personframe.getContentPane().add(introduction);
		introduction.setText(DBintroduction);

		tele = new JTextField();
		tele.setEditable(false);
		tele.setBounds(316, 296, 226, 28);
		Personframe.getContentPane().add(tele);
		tele.setColumns(10);
		tele.setText(DBtele);

		/*
		 * 关闭当前窗口
		 */
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Personframe.dispose();
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Utsaah", Font.BOLD, 23));
		btnClose.setBackground(new Color(192, 192, 192));
		btnClose.setBounds(687, 472, 92, 47);
		Personframe.getContentPane().add(btnClose);
		
		JLabel po = new JLabel("");
		ImageIcon  u2=new ImageIcon(GetImageFromServer.getImageFromServer(ResetURL));
		//下面这行表示按比例缩放图片
		u2.setImage(u2.getImage().getScaledInstance(200, 200,  Image.SCALE_DEFAULT));
		po.setIcon(u2);
		System.out.println(ResetURL);
		po.setBounds(151, 54, 201, 186);
		Personframe.getContentPane().add(po);
		
		JLabel label = new JLabel("部门：");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("微软雅黑", Font.BOLD, 22));
		label.setBounds(442, 147, 85, 60);
		Personframe.getContentPane().add(label);
		
		JLabel department = new JLabel(DBdepartment);
		department.setForeground(Color.WHITE);
		department.setFont(new Font("微软雅黑", Font.BOLD, 22));
		department.setBounds(550, 147, 218, 60);
		Personframe.getContentPane().add(department);

		/*
		 * 确认修改信息
		 */
		String[] o1 = new String[4];
		
		
		

	}

	/*
	 * public JLabel getPhotoLbl(JLabel lblNewLabel1, DBUtil db) { JFileChooser
	 * chooser = new JFileChooser();// 文件选择器 FileNameExtensionFilter filter = new
	 * FileNameExtensionFilter("请选择图片文件", "png", "jpg");// 文件名过滤器
	 * chooser.setFileFilter(filter);// 给文件选择器加入文件过滤器 int returnVal =
	 * chooser.showOpenDialog(null); if (returnVal == JFileChooser.APPROVE_OPTION) {
	 * 
	 * File file = chooser.getSelectedFile();// 得到文件对象 String fileName =
	 * chooser.getSelectedFile().getName();// 得到文件名 String fileaddr =
	 * chooser.getSelectedFile().getAbsolutePath(); // 得到要存入的路径 String newFile =
	 * fileName; byte[] buf=new byte[10240];
	 * 
	 * // 得到文件后，上传到我们统一文件夹下，并显示出来 // 使用二进制流进行操作 try { BufferedInputStream bis = new
	 * BufferedInputStream(new FileInputStream(file)); BufferedOutputStream bos =
	 * new BufferedOutputStream(new FileOutputStream(newFile));
	 * 
	 * int j; int i = bis.read(); while (i != -1) { bos.write(i); //
	 * 将原file的图片读到newFile中
	 * 
	 * i = bis.read(); } for(j=0;i!=-1;j++) { bos.write(i); i = bis.read(); }
	 * 
	 * bos.close(); bis.close(); // 将上传完的图片显示出来 lblNewLabel1.setIcon(new
	 * ImageIcon(newFile)); String[] o= {"",""}; o[0]=fileaddr; o[1]=username;
	 * db.executeUpdate("update PERSONAL_INFO set  portrait=? where UserName=?", o);
	 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } }
	 * 
	 * return lblNewLabel1; }
	 */
	public static void repaint1(String url) {
		isnull = 1;
		ResetURL = url;
	
	}
}
