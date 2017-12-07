package group.li;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class IDTextPane extends JTextArea{
	public String ID;
	
	public IDTextPane(String ID)
	{
		this.ID=ID;
		setLineWrap(true);
		
	}

	public String getID() {
		return ID;
	}

}
