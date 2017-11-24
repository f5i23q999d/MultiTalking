package group.linzx.personInfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class showPersonInfo {

	private JFrame frame;

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
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 22));
		frame.getContentPane().setIgnoreRepaint(true);
		frame.getContentPane().setBackground(new Color(97, 212, 195));
		frame.setBounds(100, 100, 850, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("头像图片");
		lblNewLabel.setIgnoreRepaint(true);
		lblNewLabel.setIcon(new ImageIcon(showPersonInfo.class.getResource("/icon/krystal.JPG")));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(195, 42, 198, 200);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblJessy = new JLabel("Krystal");
		lblJessy.setFont(new Font("微软雅黑", Font.PLAIN, 37));
		lblJessy.setForeground(new Color(255, 255, 255));
		lblJessy.setBounds(442, 26, 172, 93);
		frame.getContentPane().add(lblJessy);
		
		JButton btnNewButton = new JButton("Change Image");
		btnNewButton.setFont(new Font("Utsaah", Font.BOLD, 23));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(102, 204, 204));
		btnNewButton.setBounds(419, 207, 155, 35);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblTel = new JLabel("Tel：");
		lblTel.setFont(new Font("微软雅黑", Font.BOLD, 22));
		lblTel.setForeground(new Color(255, 255, 255));
		lblTel.setBounds(195, 298, 85, 60);
		frame.getContentPane().add(lblTel);
		
		JLabel lblIntroduction = new JLabel("Introduction：");
		lblIntroduction.setForeground(Color.WHITE);
		lblIntroduction.setFont(new Font("微软雅黑", Font.BOLD, 22));
		lblIntroduction.setBounds(194, 371, 179, 65);
		frame.getContentPane().add(lblIntroduction);
		
		JButton btnExit = new JButton("Edit");
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Utsaah", Font.BOLD, 23));
		btnExit.setBackground(new Color(102, 204, 255));
		btnExit.setBounds(601, 460, 68, 47);
		frame.getContentPane().add(btnExit);
		
		JButton btnClose = new JButton("Close");
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Utsaah", Font.BOLD, 23));
		btnClose.setBackground(new Color(102, 204, 255));
		btnClose.setBounds(693, 460, 92, 47);
		frame.getContentPane().add(btnClose);
	}
}
