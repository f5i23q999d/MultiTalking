package group.li;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class UI extends JFrame{
	
	ArrayList<ListPanel> list=new ArrayList<ListPanel>();
	int currentPage=1;
	JPanel panel;
	
	JButton chatButton;
	JButton contactButton;
	ContactPanel CP=new ContactPanel();
	public static JPanel panel_2;
	
	
	public void addMouseListener(int i)
	{
		
		System.out.println("listener:"+i);
				list.get(i).addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						for(int k=0;k<list.size();k++)
								list.get(k).setBackground(Color.white);
						
						list.get(i).setBackground(new Color(200, 200, 200));
						
					}
				});
		
		
	}
	
	public static void test(int k)
	{
		
		//pageSwitch(0);
		
		
	}
	
	
	public void pageSwitch(int k)
	{
		
		panel.removeAll();
		panel.setLayout(new GridLayout(10, 1, 0, 0));
		
		currentPage+=k;
		int total=list.size();
		 if(list.size()-(currentPage-1)*10>10)
			 total=10+(currentPage-1)*10;
		 else
			 total=list.size();
		

		for(int i=(currentPage-1)*10;i<total;i++)
		{
			
			list.get(i).setName("好友"+i);
			list.get(i).setU(new ImageIcon(UI.class.getResource("/icon/"+i+".png")));
			panel.add(list.get(i));
			addMouseListener(i);
					}
		
		panel.revalidate();//ˢ��ҳ�棬������֤
		panel.repaint();
		
		
	}
	
	
	public UI() {
		
		
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(55, 0, 245, 500);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton lastPage = new JButton("\u4E0A\u4E00\u9875");
		lastPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pageSwitch(-1);
				
			}
		});
		lastPage.setBounds(55, 499, 93, 23);
		getContentPane().add(lastPage);
		
		JButton nextPage = new JButton("\u4E0B\u4E00\u9875");
		nextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pageSwitch(1);
				
			}
		});
		nextPage.setBounds(209, 499, 93, 23);
		getContentPane().add(nextPage);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(0, 0, 55, 500);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		chatButton = new JButton("");
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contactButton.setIcon(new ImageIcon(UI.class.getResource("/tab/8.png")));
				chatButton.setIcon(new ImageIcon(UI.class.getResource("/tab/7.png")));
				pageSwitch(0);
				
			}
		});
		chatButton.setIcon(new ImageIcon(UI.class.getResource("/tab/7.png")));
		chatButton.setBounds(0, 80, 55, 55);
		panel_1.add(chatButton);
		
		contactButton = new JButton("");
		contactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contactButton.setIcon(new ImageIcon(UI.class.getResource("/tab/9.png")));
				chatButton.setIcon(new ImageIcon(UI.class.getResource("/tab/6.png")));

				
				panel.removeAll();
				panel.setLayout(null);
				panel.add(CP);
				
				panel.revalidate();//ˢ��ҳ�棬������֤
				panel.updateUI();
				panel.repaint();
				
				
			}
			
			
		});
	
		contactButton.setIcon(new ImageIcon(UI.class.getResource("/tab/8.png")));
		contactButton.setBounds(0, 135, 55, 55);
		panel_1.add(contactButton);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(UI.class.getResource("/tab/10.png")));
		button_1.setBounds(0, 435, 55, 55);
		panel_1.add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(UI.class.getResource("/tab/11.png")));
		lblNewLabel.setBounds(0, 5, 55, 55);
		panel_1.add(lblNewLabel);
		
		panel_2 = new JPanel();
		panel_2.setBounds(300, 0, 600, 500);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel teatLabel = new JLabel("\u6B63\u5728\u4E0E   \u5BF9\u8BDD");
		teatLabel.setFont(new Font("����", Font.PLAIN, 26));
		teatLabel.setBounds(112, 166, 186, 157);
		panel_2.add(teatLabel);
		
		


	
		
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		
		
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		
		
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		int total;
 if(list.size()>10)
	 total=10;
 else
	 total=list.size();
		
		for(int i=0;i<total;i++)
		{
			list.get(i).setName("好友"+i);
			list.get(i).setU(new ImageIcon(UI.class.getResource("/icon/"+i+".png")));
			panel.add(list.get(i));
			addMouseListener(i);
		//	System.out.println(list.get(i));

		}

	
		
		
		
}
	
	
	
	
	
	public static void main(String[] args) {
		UI T2=new UI();
		T2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		T2.setSize(970,550);
		T2.setVisible(true);

	}
	 
}
