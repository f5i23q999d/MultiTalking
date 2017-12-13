package groupTest;

import java.io.FileFilter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UItest extends JFrame{
	public UItest() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(88, 91, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel2=new JLabel();
		lblNewLabel2.setBounds(0, 0, 54, 15);
		getContentPane().add(lblNewLabel2);
		
		
		JLabel lblNewLabel3=lblNewLabel;
		lblNewLabel3.setBounds(200, 200, 54, 15);
		getContentPane().add(lblNewLabel3);
		
		JLabel label = new JLabel("New label");
		label.setBounds(226, 338, 54, 15);
		getContentPane().add(label);
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
