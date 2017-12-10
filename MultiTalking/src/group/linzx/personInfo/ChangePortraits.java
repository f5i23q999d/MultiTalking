package group.linzx.personInfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ChangePortraits {
	public JFrame frame;

	private JTextField textField;
	public String url;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePortraits window = new ChangePortraits();
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
	public ChangePortraits() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 672, 212);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("输入图片路径：");
		label.setBounds(26, 26, 128, 37);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(147, 33, 389, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("上传");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url=textField.getText();
				showPersonInfo.repaint1(url);
				frame.dispose();
			}
		});
		button.setBounds(400, 105, 113, 27);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		           frame.dispose();
			}
		});
		button_1.setBounds(527, 105, 113, 27);
		frame.getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("注意：当下次登录时，即可看到修改后的图片。");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(14, 131, 306, 23);
		frame.getContentPane().add(label_1);
	}
}
