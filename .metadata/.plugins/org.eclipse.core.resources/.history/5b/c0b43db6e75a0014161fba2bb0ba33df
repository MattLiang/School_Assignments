import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;


public class AddressBookPanel extends JPanel implements ActionListener{
	private JButton jb_remove;
	private JButton jb_edit;
	private JList<BuddyInfo> bookList;
	private AddressBookFrame abFrame;
	
	public AddressBookPanel(AddressBookFrame abFrame){
		this.abFrame = abFrame;
		
		//Setup Buttons and Address Book list
		jb_remove = new JButton("Remove");
		jb_edit = new JButton("Edit");
		
		jb_remove.addActionListener(this);
		jb_edit.addActionListener(this);
		
		bookList = new JList<BuddyInfo>(abFrame.getAddressBook());
		
		bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookList.setLayoutOrientation(JList.VERTICAL);
		
		// Setup button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.LINE_AXIS));
		buttonPanel.add(jb_edit);
		buttonPanel.add(jb_remove);
		
		// Setup main panel
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        add(bookList, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (bookList.getSelectedIndex()!= -1){
			if ("Edit".equals(e.getActionCommand())) {
	            abFrame.editBuddyInfo(bookList.getSelectedValue());
	        }
			else if ("Remove".equals(e.getActionCommand())) {
				abFrame.deleteBuddy(bookList.getSelectedValue());
			}
		}
	}

}
