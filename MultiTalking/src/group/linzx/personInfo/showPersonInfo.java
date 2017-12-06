package group.linzx.personInfo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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

import group.lin.util.DBUtil;
/*
 * 调用该类显示、修改个人信息
 * 调用要求：必须告知该类调用的用户名称username
 */
public class showPersonInfo {

	private JFrame frame;
	private JTextField tele;
	String temp1 = "";
	String temp2 = ""; // 存放编辑的文本框内容，用于按钮“apply”
	public String username="b";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showPersonInfo window = new showPersonInfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public showPersonInfo() {
		initialize();

	}
	
	/*
	 * 从网络上读取图片
	 * 
	 */
	public void getImageFromServer(String imgUrl) {
		//String imgUrl="";//图片地址
	    try {
	      // 构造URL
	      URL url = new URL(imgUrl);
	      // 打开连接
	      URLConnection con = url.openConnection();
	      // 输入流
	      InputStream is = con.getInputStream();
	      // 1K的数据缓冲
	      byte[] bs = new byte[1024];
	      // 读取到的数据长度
	      int len;
	      // 输出的文件流
	      OutputStream os = new FileOutputStream("c:\\image.jpg");//保存路径
	      // 开始读取
	      while ((len = is.read(bs)) != -1) {
	        os.write(bs, 0, len);
	      }
	      // 完毕，关闭所有链接
	      os.close();
	      is.close();
	    } catch (MalformedURLException e) {
	      e.printStackTrace();
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String username="a";
		DBUtil db = DBUtil.getDBUtil();
		String DBusername = "";
		String DBtele = "";
		String DBintroduction = "";
		String DBportrait="";
		
		String[] o= {""};
		//username[0]="a";
		//username[0]="b";
		o[0]=username;
		
		try {
			ResultSet rs = db.executeQuery("select * from PERSONAL_INFO where UserName=?",o);
			if (rs.next()) {
				DBusername = rs.getString(1);
				DBportrait=rs.getString(2);
				
				DBtele = rs.getString(3);
				DBintroduction = rs.getString(4);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 22));
		frame.getContentPane().setIgnoreRepaint(true);
		frame.getContentPane().setBackground(new Color(97, 212, 195));
		frame.setBounds(100, 100, 850, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIgnoreRepaint(true);
		lblNewLabel.setIcon(new ImageIcon(DBportrait));//showPersonInfo.class.getResource("/icon/krystal.JPG")
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(195, 42, 198, 200);
		frame.getContentPane().add(lblNewLabel);

		JLabel UserName = new JLabel("Krystal");
		UserName.setFont(new Font("微软雅黑", Font.PLAIN, 37));
		UserName.setForeground(new Color(255, 255, 255));
		UserName.setBounds(442, 26, 172, 93);
		frame.getContentPane().add(UserName);
		UserName.setText(DBusername);

		/*
		 * 修改图片
		 */
		JButton btnNewButton = new JButton("Change Image");
		btnNewButton.setFont(new Font("Utsaah", Font.BOLD, 23));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * JFileChooser chooser = new JFileChooser(); //创建选择文件对象
				 * chooser.setMultiSelectionEnabled(false);
				 * chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); int result
				 * 
				 * chooser.setDialogTitle("请选择文件");//设置标题
				 * chooser.setMultiSelectionEnabled(true); //设置只能选择文件 FileNameExtensionFilter
				 * filter = new FileNameExtensionFilter("jpg", "jpg");//定义可选择文件类型
				 * chooser.setFileFilter(filter); //设置可选择文件类型 chooser.showOpenDialog(null);
				 * //打开选择文件对话框,null可设置为你当前的窗口JFrame或Frame File file = chooser.getSelectedFile();
				 * //file为用户选择的图片文件
				 */
				getPhotoLbl(lblNewLabel, db);
			}
		});
		btnNewButton.setBackground(new Color(102, 204, 204));
		btnNewButton.setBounds(419, 207, 155, 35);
		frame.getContentPane().add(btnNewButton);

		JLabel lblTel = new JLabel("Tel：");
		lblTel.setFont(new Font("微软雅黑", Font.BOLD, 22));
		lblTel.setForeground(new Color(255, 255, 255));
		lblTel.setBounds(195, 275, 85, 60);
		frame.getContentPane().add(lblTel);

		JLabel lblIntroduction = new JLabel("Introduction：");
		lblIntroduction.setForeground(Color.WHITE);
		lblIntroduction.setFont(new Font("微软雅黑", Font.BOLD, 22));
		lblIntroduction.setBounds(151, 322, 179, 65);
		frame.getContentPane().add(lblIntroduction);

		JTextArea introduction = new JTextArea();
		introduction.setBounds(316, 347, 226, 93);
		frame.getContentPane().add(introduction);
		introduction.setText(DBintroduction); //
		introduction.setEditable(false); //

		tele = new JTextField();
		tele.setBounds(316, 296, 226, 28);
		frame.getContentPane().add(tele);
		tele.setColumns(10);
		tele.setText(DBtele); //
		tele.setEditable(false); //
		
		

		/*
		 * 编辑文本框内容
		 */
		JButton btnExit = new JButton("Edit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tele.setEditable(true);
				introduction.setEditable(true);

			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Utsaah", Font.BOLD, 23));
		btnExit.setBackground(new Color(102, 204, 255));
		btnExit.setBounds(598, 472, 68, 47);
		frame.getContentPane().add(btnExit);

		/*
		 * 关闭当前窗口
		 */
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Utsaah", Font.BOLD, 23));
		btnClose.setBackground(new Color(102, 204, 255));
		btnClose.setBounds(687, 472, 92, 47);
		frame.getContentPane().add(btnClose);

		/*
		 * 确认修改信息
		 */
		String[] o1 = new String[3];
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o1[0] = tele.getText();
				o1[1] = introduction.getText();
				o1[2]= username;
				db.executeUpdate("update PERSONAL_INFO set tele=?,introduction=? where UserName=?", o1); // ？不可加单引号
				tele.setEditable(false);
				introduction.setEditable(false);
			}
		});
		btnApply.setForeground(Color.WHITE);
		btnApply.setFont(new Font("Utsaah", Font.BOLD, 23));
		btnApply.setBackground(new Color(102, 204, 255));
		btnApply.setBounds(494, 472, 81, 47);
		frame.getContentPane().add(btnApply);

	}

	public JLabel getPhotoLbl(JLabel lblNewLabel1, DBUtil db) {
		JFileChooser chooser = new JFileChooser();// 文件选择器
		FileNameExtensionFilter filter = new FileNameExtensionFilter("请选择图片文件", "png", "jpg");// 文件名过滤器
		chooser.setFileFilter(filter);// 给文件选择器加入文件过滤器
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			File file = chooser.getSelectedFile();// 得到文件对象
			String fileName = chooser.getSelectedFile().getName();// 得到文件名
			String fileaddr = chooser.getSelectedFile().getAbsolutePath();
			// 得到要存入的路径
			String newFile = fileName;
			byte[] buf=new byte[10240];
			
			// 得到文件后，上传到我们统一文件夹下，并显示出来
			// 使用二进制流进行操作
			try {
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
				
				int j;
				int i = bis.read();
				/*while (i != -1) {
					bos.write(i); // 将原file的图片读到newFile中
				
					i = bis.read();
				}*/
				for(j=0;i!=-1;j++) {
					bos.write(i);
					i = bis.read();
				}
			
				bos.close();
				bis.close();
				// 将上传完的图片显示出来
				lblNewLabel1.setIcon(new ImageIcon(newFile));
				String[] o= {"",""};
				o[0]=fileaddr;
				o[1]=username;
				db.executeUpdate("update PERSONAL_INFO set  portrait=? where UserName=?", o);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return lblNewLabel1;
	}
}
