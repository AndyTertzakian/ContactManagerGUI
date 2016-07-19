package view;

/*
 * Author: Andre Tertzakian
 * September, 2014
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.ContactManagerController;

public class ContactManagerGUI {

	ContactManagerController contactManagerController = new ContactManagerController();
	private JFrame	frame;
	private JList<String>	list;
	private Vector<String>	listData;
	private JButton addbtn,
					rembtn,
					savebtn;
	private JTextField newEmailtxt;
	
	public ContactManagerGUI() throws Exception {
		contactManagerController.useFileDb();
		loadContacts();
	}

	private void loadContacts() throws Exception {
		listData = contactManagerController.getAllContacts();
	}

	public void execute() {
		//FRAME
		frame = new JFrame("Zippy Contact Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,500,400);
		Container content = frame.getContentPane();
		content.setLayout(new GridLayout(1, 3));
		
		// PANEL ONE
		JPanel firstPanel = new JPanel();
		firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.Y_AXIS));
		JLabel emailContactslbl = new JLabel("Email Contacts");
		emailContactslbl.setForeground(Color.red);
		emailContactslbl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		list = new JList<String>(listData);
		list.setVisibleRowCount(5);
		JScrollPane listWithScroll = new JScrollPane(list);
		firstPanel.add(emailContactslbl);
		firstPanel.add(listWithScroll);
		
		// PANEL TWO
		JPanel secondPanel = new JPanel();
		secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));
		addbtn = new JButton("<- ADD");
		addbtn.addActionListener(new AddButtonListener());
		rembtn = new JButton("REM ->");
		rembtn.addActionListener(new RemButtonListener());
		savebtn = new JButton("SAVE");
		savebtn.addActionListener(new SaveButtonListener());
		secondPanel.add(addbtn);
		secondPanel.add(rembtn);
		secondPanel.add(savebtn);
		
		//PANEL THREE
		JPanel thirdPanel = new JPanel();
		thirdPanel.setLayout(new BoxLayout(thirdPanel, BoxLayout.Y_AXIS));
		JLabel newEmaillbl = new JLabel("Enter new email below");
		newEmailtxt = new JTextField(20);
		thirdPanel.add(newEmaillbl);
		thirdPanel.add(newEmailtxt);
		
		content.add(firstPanel);
		content.add(secondPanel);
		content.add(thirdPanel);
		
		frame.setVisible(true);
		
	}

	class AddButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String newEmail = newEmailtxt.getText();
			listData.add(newEmail);
			newEmailtxt.setText("");
			list.updateUI();
		}
		
	}
	
	class RemButtonListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String emailToRemove = list.getSelectedValue();
			listData.remove(emailToRemove);
			list.updateUI();
		}
		
	}
	
	class SaveButtonListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				boolean result = contactManagerController.saveList(listData);
				if(result) {
					JOptionPane.showMessageDialog(null, "Saved!");
				}else {
					JOptionPane.showMessageDialog(null, "Not saved...");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
