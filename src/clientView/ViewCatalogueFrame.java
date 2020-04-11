package clientView;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewCatalogueFrame {
	private JFrame inputFrame;
	private JPanel inputPanel;
	private JTextArea textArea;
	
	public ViewCatalogueFrame() {
		
		inputFrame= new JFrame("View All courses in catalogue");
		inputPanel = new JPanel();
		textArea= new JTextArea(50,50);
		
		inputPanel.add(textArea);
		inputFrame.add(inputPanel);
		
		inputFrame.pack();
		inputFrame.setVisible(true);
		
		textArea.setText("This is the defalut output becasue there is no course catalogue input");
		



}

}
