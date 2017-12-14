package group.li;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import group.linzx.personInfo.GetImageFromServer;

public class JTreeRender extends DefaultTreeCellRenderer{
	
	//添加字库方法
		public Font getFont(float size) {  
	        String pathString = getClass().getClassLoader().getResource("HanYix.ttf").getFile();  
	        try {  
	            Font dynamicFont = Font.createFont(Font.PLAIN, new File(pathString));  
	            dynamicFont = dynamicFont.deriveFont(size);  
	            return dynamicFont;  
	        } catch (FontFormatException ex) {  
	            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);  
	        } catch (IOException ex) {  
	            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);  
	        }  
	          
	        return null;  
	}
	
	public Component getTreeCellRendererComponent(JTree tree, Object value,  
            boolean sel, boolean expanded, boolean leaf, int row,  
            boolean hasFocus) {  
		
		
		this.setFont(this.getFont(20.0f));
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;  
       
        if (node.getLevel() == 1) {         	//父节点
        	
        	//this.setBackground(new Color(228,228,228));
            if (expanded) {  
                this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icon/151.png")));  
            } else {  
                this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icon/131.png")));  
            }  
        }  
       
        if (node.getLevel() == 2) {  //子节点
        	String FaceFile=null;
        	FaceFile=UI.getPortrait(value.toString());
        	
        	if(FaceFile!=null)
        	{
        		
        	
        	this.setIcon((ImageIcon)ContactPanel.face.get(value.toString()));
          	}
        	else
            this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icon/big1.png")));  
        }
        this.setOpaque(true);//设置透明，否则Text不能与背景色融合
        this.setText(value.toString()+"                                  ");  //拉长，使得cell背景色能覆盖整行
        
        if(node.getLevel() == 2&&sel)
        {	
        	
        	
        	this.setBackground(new Color(200, 200, 200));
        	//System.out.println(UI.CP.tree.getLastSelectedPathComponent().toString());
        	DefaultMutableTreeNode getSelect=(DefaultMutableTreeNode)UI.CP.tree.getLastSelectedPathComponent();
        	
        	UI.MOVE.setSelectedItem(getSelect.getParent().toString());
        	
        }
        else
        	this.setBackground(new Color(228,228,228));//这里要适应登陆界面的主题
        return this;  
    }  

}
