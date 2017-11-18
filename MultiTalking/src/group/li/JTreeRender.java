package group.li;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class JTreeRender extends DefaultTreeCellRenderer{
	
	public Component getTreeCellRendererComponent(JTree tree, Object value,  
            boolean sel, boolean expanded, boolean leaf, int row,  
            boolean hasFocus) {  
		
		this.setFont(new Font("宋体",Font.PLAIN, 20));
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;  
        // 鏍硅妭鐐逛粠0寮�濮嬶紝渚濇寰�涓�  
        // 鍒嗙粍  
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
