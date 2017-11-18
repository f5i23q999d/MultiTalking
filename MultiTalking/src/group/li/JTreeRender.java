package group.li;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

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

        if (node.getLevel() == 1) {  
            if (expanded) {  
                this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icon/151.png")));  
            } else {  
                this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icon/131.png")));  
            }  
        }  
        // 濂藉弸  
        if (node.getLevel() == 2) {  
            this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icon/big1.png")));  
        }
        this.setOpaque(true);
        this.setText(value.toString()+"                                  ");  
        
        if(node.getLevel() == 2&&sel)
        {	
        	
        	
        	this.setBackground(new Color(200, 200, 200));
        	
        }
        else
        	this.setBackground(null);
        return this;  
    }  

}
