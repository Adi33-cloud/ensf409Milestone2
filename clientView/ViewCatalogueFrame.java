package clientView;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewCatalogueFrame {
	private JFrame inputFrame;
	private JPanel inputPanel;
	private JTextArea textArea;
	private JScrollPane scrollPane;


	public ViewCatalogueFrame() {
		
		inputFrame= new JFrame("View All courses in catalogue");
		inputPanel = new JPanel();
		textArea= new JTextArea(25,40);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		inputPanel.add(scrollPane);
		scrollPane.setVisible(true);
		
		inputFrame.add(inputPanel);
		
		inputFrame.pack();
		inputFrame.setVisible(true);

	}
	
	public JFrame getInputFrame() {
		return inputFrame;
	}

	public void setInputFrame(JFrame inputFrame) {
		this.inputFrame = inputFrame;
	}

	public JPanel getInputPanel() {
		return inputPanel;
	}

	public void setInputPanel(JPanel inputPanel) {
		this.inputPanel = inputPanel;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}



}
