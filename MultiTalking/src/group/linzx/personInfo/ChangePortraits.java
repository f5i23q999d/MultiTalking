package group.linzx.personInfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

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
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		//frame.setUndecorated(true);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		/*
		 * 设置窗口居中
		 */
		int windowWidth = frame.getWidth();                     //获得窗口宽  
		 int windowHeight = frame.getHeight();                   //获得窗口高  
		 Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包  
		 Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸  
		 int screenWidth = screenSize.width;                     //获取屏幕的宽  
		 int screenHeight = screenSize.height;                   //获取屏幕的高  
		 frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示  
		
		JLabel label = new JLabel("输入图片路径：");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("幼圆", Font.BOLD, 18));
		label.setBounds(42, 17, 150, 61);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(178, 33, 469, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("上传");
		button.setFont(new Font("幼圆", Font.BOLD, 17));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(128, 128, 128));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url=textField.getText();
				showPersonInfo.repaint1(url);
				frame.dispose();
			}
		});
		button.setBounds(370, 108, 122, 40);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setFont(new Font("幼圆", Font.BOLD, 16));
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(128, 128, 128));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		           frame.dispose();
			}
		});
		button_1.setBounds(525, 108, 116, 40);
		frame.getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("注意：当下次登录时，修改后的图片生效。");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("幼圆", Font.PLAIN, 13));
		label_1.setBounds(14, 169, 306, 30);
		frame.getContentPane().add(label_1);
	}
}
