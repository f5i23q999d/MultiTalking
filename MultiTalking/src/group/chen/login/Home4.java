/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.chen.login;

import java.awt.Color;
//import BunifuDrag.BunifuDrag;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
//import javafx.util.converter.LocalDateTimeStringConverter;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
//import diu.swe.habib.JPanelSlider.JPanelSlider;
import java.awt.event.MouseMotionAdapter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
//sql
import group.lin.dao.LoginDAO;
import group.multiTalking.DAO;
import group.li.UI;
import group.lin.base.BaseDAO;
import group.lin.entity.UserDAO;
import javax.swing.JButton;
/**
 *
 * @author proxc
 */
public class Home4 extends javax.swing.JFrame {

    /**
     * Creates new form Home41
     */
    public Home4() {
        initComponents();
        
      new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             LocalDateTime now = LocalDateTime.now();
//        jLabel6.setText(String.valueOf(now.getSecond()));
//        jLabel15.setText(String.valueOf(now.getMinute()));
//        jLabel14.setText(String.valueOf(now.getHour()));  
        
            }
        }).start();
     
 
    
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSlider1 = new diu.swe.habib.JPanelSlider.JPanelSlider();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        password_Signup = new javax.swing.JPasswordField();
        userName_Signup = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        agreeTerms = new javax.swing.JCheckBox();
        SignUp_Button = new javax.swing.JPanel();
        SignUp_Button.addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseMoved(MouseEvent arg0) {
        		
        		
        	}
        });
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
       
        jLabel11 = new javax.swing.JLabel();
        swipeTo_sginIn = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        Password_Signin = new javax.swing.JPasswordField();
        userName_SignIn = new javax.swing.JTextField();
        SignIn_Button = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        swipeTo_Signup = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(850, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSlider1.setPreferredSize(new java.awt.Dimension(420, 554));

        jPanel5.setBackground(new java.awt.Color(36, 47, 65));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Sign Up");
       // jLabel3.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("USERNAME");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("PASSWORD");

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        password_Signup.setBackground(new java.awt.Color(36, 47, 65));
        password_Signup.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        password_Signup.setForeground(new java.awt.Color(255, 255, 255));
        password_Signup.setToolTipText("");
        password_Signup.setBorder(null);
        password_Signup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusGained(evt);
            }
        });

        userName_Signup.setBackground(new java.awt.Color(36, 47, 65));
        userName_Signup.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        userName_Signup.setForeground(new java.awt.Color(255, 255, 255));
        userName_Signup.setText("Enter you username");
        userName_Signup.setBorder(null);
        userName_Signup.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        userName_Signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        email.setBackground(new java.awt.Color(36, 47, 65));
        email.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("Your email here");
        email.setBorder(null);
        email.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
        });
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        agreeTerms.setBackground(new java.awt.Color(36, 47, 65));
        agreeTerms.setForeground(new java.awt.Color(255, 255, 255));
        agreeTerms.setSelected(true);
        agreeTerms.setText("I agree all terms of service");
        agreeTerms.setBorder(null);
        agreeTerms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        SignUp_Button.setBackground(new java.awt.Color(97, 212, 195));
        SignUp_Button.addMouseListener(new java.awt.event.MouseAdapter() {        
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				
            	String password = new String(password_Signup.getPassword());
            	
            	if(isNull(userName_Signup.getText()) || isNull(password)) {
            		JOptionPane.showMessageDialog(null, "账号或密码为空");            		
            	};
            	
            	System.out.println(userName_Signup.getText());
            	System.out.println(password);
            	if(((LoginDAO) BaseDAO.getAbilityDAO(DAO.LoginDAO)).queryForUserName(userName_Signup.getText())){
            		JOptionPane.showMessageDialog(null, "账号已存在");
            	}
            	
            	UserDAO user = new UserDAO();
            	user.setUserId(userName_Signup.getText());
            	user.setUserPassword(password);
            	
            	if(((LoginDAO) BaseDAO.getAbilityDAO(DAO.LoginDAO)).addUser(user)) {
            		JOptionPane.showMessageDialog(null, "账号创建成功");
            	} else {
            		JOptionPane.showMessageDialog(null, "账号创建失败，联系：onefatman@qq.com");
            	}
                 
            }
        	@Override
        	public void mouseExited(MouseEvent arg0) {
        		SignUp_Button.setBackground(new java.awt.Color(97,212, 195));
        		
        		
        		
        		
        	}
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		SignUp_Button.setBackground(Color.magenta);
        	}
        });
        SignUp_Button.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("EMAIL");
        SignUp_Button.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("SignUp");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        SignUp_Button.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("EMAIL");

        swipeTo_sginIn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        swipeTo_sginIn.setForeground(new java.awt.Color(204, 204, 204));
        swipeTo_sginIn.setText("Already a member");
        swipeTo_sginIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel10MouseReleased(evt);
            }
        });

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5Layout.setHorizontalGroup(
        	jPanel5Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel5Layout.createSequentialGroup()
        			.addContainerGap(70, Short.MAX_VALUE)
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jSeparator6, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
        				.addComponent(password_Signup, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
        				.addComponent(email, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel11)
        				.addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3)
        				.addComponent(jLabel4)
        				.addComponent(userName_Signup, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5)
        				.addComponent(agreeTerms)
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addComponent(SignUp_Button, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
        						.addComponent(swipeTo_sginIn))))
        			.addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
        	jPanel5Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel5Layout.createSequentialGroup()
        			.addGap(52)
        			.addComponent(jLabel3)
        			.addGap(42)
        			.addComponent(jLabel4)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(userName_Signup, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel5)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(password_Signup, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jLabel11)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(email, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jSeparator6, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addGap(64)
        			.addComponent(agreeTerms)
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(SignUp_Button, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addGap(52)
        					.addComponent(swipeTo_sginIn)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel5.setLayout(jPanel5Layout);

        jPanelSlider1.add(jPanel5, "card2");

        jPanel6.setBackground(new java.awt.Color(36, 47, 65));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Sign In");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("USERNAME");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("PASSWORD");

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));

        Password_Signin.setBackground(new java.awt.Color(36, 47, 65));
        Password_Signin.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Password_Signin.setForeground(new java.awt.Color(255, 255, 255));
        Password_Signin.setBorder(null);
        Password_Signin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusGained(evt);
            }
        });
        Password_Signin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField2MouseClicked(evt);
            }
        });

        userName_SignIn.setBackground(new java.awt.Color(36, 47, 65));
        userName_SignIn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        userName_SignIn.setForeground(new java.awt.Color(255, 255, 255));
        userName_SignIn.setText("Enter you username");
        userName_SignIn.setBorder(null);
        userName_SignIn.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        userName_SignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        userName_SignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        SignIn_Button.setBackground(new java.awt.Color(97, 212, 195));
        SignIn_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	String password = new String(Password_Signin.getPassword());
            	if(isNull(userName_SignIn.getText()) || isNull(password)) {
            		JOptionPane.showMessageDialog(null, "账号或密码为空");
            	}
            	if(((LoginDAO) BaseDAO.getAbilityDAO(DAO.LoginDAO)).queryForUserName(userName_SignIn.getText())) {
            		if(((LoginDAO) BaseDAO.getAbilityDAO(DAO.LoginDAO)).queryForPassword(userName_SignIn.getText(),password)) {
            			dispose();//关闭登陆窗口
            			UI T2=new UI(userName_SignIn.getText());
            			T2.getContentPane().update(null);
            			T2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            			T2.setSize(970,550);
            			T2.setVisible(true);
            			
            			
            		}
            	} else {
            		JOptionPane.showMessageDialog(null, "账号不存在");
            	}
                //jPanel4MouseClicked(evt);
            }
        });
        SignIn_Button.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("EMAIL");
        SignIn_Button.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("SignIn");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        SignIn_Button.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        swipeTo_Signup.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        swipeTo_Signup.setForeground(new java.awt.Color(204, 204, 204));
        swipeTo_Signup.setText("New Here?");
        swipeTo_Signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel14MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 68, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15)
                    .addComponent(userName_SignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(Password_Signin, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SignIn_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(swipeTo_Signup)
                .addGap(94, 94, 94))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName_SignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password_Signin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(swipeTo_Signup)
                .addGap(15, 15, 15)
                .addComponent(SignIn_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 139, Short.MAX_VALUE))
        );

        jPanelSlider1.add(jPanel6, "card2");

        getContentPane().add(jPanelSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(97, 212, 195));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Communicate with Others");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, 20));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Plan yourself");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, 30));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/icon/ass.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 440, 550));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 842, 551));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        userName_Signup.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        // TODO add your handling code here:
         email.setText("");
    }//GEN-LAST:event_jTextField2FocusGained

    private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusGained
        // TODO add your handling code here:
        password_Signup.setText("");
    }//GEN-LAST:event_jPasswordField1FocusGained

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    
        toFront();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        SignUp_Button.action(null,null);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        userName_SignIn.setText("");          
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jPasswordField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2FocusGained

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
         jPanelSlider1.nextPanel(10, jPanel6, jPanelSlider1.left);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseReleased

    private void jPasswordField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField2MouseClicked
        Password_Signin.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2MouseClicked

    private void jLabel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseReleased
       jPanelSlider1.nextPanel(10, jPanel5, jPanelSlider1.right);
       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Home4 t=new Home4();
                t.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox agreeTerms;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel swipeTo_sginIn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel swipeTo_Signup;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel SignUp_Button;
    private javax.swing.JPanel SignIn_Button;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSlider1;
    private javax.swing.JPasswordField password_Signup;
    private javax.swing.JPasswordField Password_Signin;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField userName_Signup;
    private javax.swing.JTextField email;
    private javax.swing.JTextField userName_SignIn;
    // End of variables declaration//GEN-END:variables
    
    //判断字符串是否为空
    public boolean isNull(String text) {
    	boolean result = true;
    	if(text != null)
    		result = false;
    	return result;
    }
    
    public boolean isNull(char[] text) {
    	boolean result = true;
    	if(text != null)
    		result = false;
    	return result;
    }
}
