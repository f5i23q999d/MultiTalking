package group.li;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextField;

import group.lin.util.DBUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class RaiseMission extends JFrame{
	private JTextField TaskTitle;
	static JLabel dest;
	public RaiseMission() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("标题：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(25, 76, 54, 15);
		getContentPane().add(lblNewLabel);
		
		TaskTitle = new JTextField();
		TaskTitle.setBounds(81, 65, 358, 31);
		getContentPane().add(TaskTitle);
		TaskTitle.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("接收人：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(25, 47, 71, 15);
		getContentPane().add(lblNewLabel_1);
		
		dest = new JLabel("");
		dest.setBounds(81, 47, 358, 15);
		getContentPane().add(dest);
		
		JButton choose = new JButton("选择人员");
		choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectDest RM=new selectDest();
				RM.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				RM.setSize(600, 550);
				RM.setLocale(null);
				RM.setVisible(true);
				
				
				
			}
		});
		choose.setBounds(85, 14, 93, 23);
		getContentPane().add(choose);
		
		JLabel lblNewLabel_2 = new JLabel("内容：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(26, 103, 54, 15);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("添加附件");
		btnNewButton.setBounds(250, 362, 93, 23);
		getContentPane().add(btnNewButton);
		
		
		JTextArea TaskContext = new JTextArea();
		//textArea.setBounds(81, 103, 358, 223);
		JScrollPane scrollBar = new JScrollPane(TaskContext);
		scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBar.setBounds(81, 103, 358, 223);
		getContentPane().add(scrollBar);
		
		
		JButton btnNewButton_1 = new JButton("发送");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []tmp;
				tmp=dest.getText().split(" ");
				DBUtil db=DBUtil.getDBUtil();
				for(int i=0;i<tmp.length;i++)
				{
					if(!tmp[i].equals(""))
					{
					String sql="insert into Task values (null,?,?,?,?,null,?,0)";
					Object[] obj = {UI.ID,tmp[i],TimeGet.FullTime(),TaskContext.getText(),TaskTitle.getText()};
					db.executeUpdate(sql, obj);
					}
				}
				JOptionPane.showMessageDialog(null,"已发送任务!");
				
			}
		});
		btnNewButton_1.setBounds(367, 362, 93, 23);
		getContentPane().add(btnNewButton_1);
		

	}
}
