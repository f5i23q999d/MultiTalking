package group.linzx.personInfo;

import group.lin.util.DBUtil;

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


public class showPersonInfo {

	private JFrame frame;
	private JTextField tele;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DBUtil db=DBUtil.getDBUtil();
		String DBusername="";
		String DBtele="";
		String DBintroduction="";
		try {
			ResultSet rs=db.executeQuery("select * from PERSONAL_INFO where UserName='a'");
			if(rs.next()) {
				DBusername=rs.getString(1);
				
				DBtele=rs.getString(3);
				DBintroduction=rs.getString(4);
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
		lblNewLabel.setIcon(new ImageIcon(showPersonInfo.class.getResource("/icon/krystal.JPG")));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(195, 42, 198, 200);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel UserName = new JLabel("Krystal");
		UserName.setFont(new Font("微软雅黑", Font.PLAIN, 37));
		UserName.setForeground(new Color(255, 255, 255));
		UserName.setBounds(442, 26, 172, 93);
		frame.getContentPane().add(UserName);
		UserName.setText(DBusername);
		
		JButton btnNewButton = new JButton("Change Image");
		btnNewButton.setFont(new Font("Utsaah", Font.BOLD, 23));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*JFileChooser chooser = new JFileChooser(); //创建选择文件对象
				chooser.setMultiSelectionEnabled(false);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result
				
				chooser.setDialogTitle("请选择文件");//设置标题
				chooser.setMultiSelectionEnabled(true);  //设置只能选择文件
				FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "jpg");//定义可选择文件类型
				chooser.setFileFilter(filter); //设置可选择文件类型
			    chooser.showOpenDialog(null); //打开选择文件对话框,null可设置为你当前的窗口JFrame或Frame
				File file = chooser.getSelectedFile(); //file为用户选择的图片文件
*/			
				getPhotoLbl(lblNewLabel);
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
		
		JButton btnExit = new JButton("Edit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Utsaah", Font.BOLD, 23));
		btnExit.setBackground(new Color(102, 204, 255));
		btnExit.setBounds(598, 472, 68, 47);
		frame.getContentPane().add(btnExit);
		
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
		
		tele = new JTextField();
		tele.setBounds(316, 296, 226, 28);
		frame.getContentPane().add(tele);
		tele.setColumns(10);
		tele.setText(DBusername);
		
		JTextArea introduction = new JTextArea();
		introduction.setBounds(316, 347, 226, 93);
		frame.getContentPane().add(introduction);
		introduction.setText(DBintroduction);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setForeground(Color.WHITE);
		btnApply.setFont(new Font("Utsaah", Font.BOLD, 23));
		btnApply.setBackground(new Color(102, 204, 255));
		btnApply.setBounds(494, 472, 81, 47);
		frame.getContentPane().add(btnApply);
		
		
		
		
	}
	
	 public JLabel getPhotoLbl(JLabel lblNewLabel1) {
	                    JFileChooser chooser = new JFileChooser();//文件选择器
	                    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                    		"请选择图片文件", "png", "jpg");//文件名过滤器
	                    chooser.setFileFilter(filter);//给文件选择器加入文件过滤器
	                    int returnVal = chooser.showOpenDialog(null);
	                    if(returnVal == JFileChooser.APPROVE_OPTION) {
	                 
	                    File file = chooser.getSelectedFile();//得到文件对象
	                    String fileName = chooser.getSelectedFile().getName();//得到文件名
	                            //得到要存入的路径
	                            String newFile = fileName;
	                            //得到文件后，上传到我们统一文件夹下，并显示出来
	                            //使用二进制流进行操作
	                            try {
	                                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
	                                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
	                                
	                                int i = bis.read();
	                                while(i!=-1){
	                                    bos.write(i);
	                                    i = bis.read();
	                                }
	                                bos.close();
	                                bis.close();
	                                //将上传完的图片显示出来
	                                lblNewLabel1.setIcon(new ImageIcon(newFile));
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

