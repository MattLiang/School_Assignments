import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;


public class AddressBookFrame extends JFrame implements ActionListener{
	//Class Variables
	public enum MenuCommands {Create,Save,Display,Add};
	
	//Menu Bar variables
	private JMenuBar menuBar;
	private JMenu addrbook;
	private JMenu buddyInfo;
	private JMenuItem create;
	private JMenuItem save;
	private JMenuItem display;
	private JMenuItem add;
	
	//Variables
	private AddressBook book;
	private JTextArea mainDialog;
	
	//Panel Variables
	private BuddyCreationPanel creationPanel;
	
	public AddressBookFrame(){
		super("Address Book");
		
		//Init
		setLayout(new FlowLayout());
		mainDialog = new JTextArea();
		creationPanel = new BuddyCreationPanel(this);
		
		//Setup Menu bar
		menuBar = new JMenuBar();
		addrbook = new JMenu("Address Book");
		buddyInfo = new JMenu("BuddyInfo");
		
		create = new JMenuItem(MenuCommands.Create.toString());
		create.addActionListener(this);
		save = new JMenuItem(MenuCommands.Save.toString());
		save.setEnabled(false);
		save.addActionListener(this);
		display = new JMenuItem(MenuCommands.Display.toString());
		display.setEnabled(false);
		display.addActionListener(this);
		add = new JMenuItem(MenuCommands.Add.toString());
		add.addActionListener(this);
		
		addrbook.add(create);
		addrbook.add(save);
		addrbook.add(display);
		
		buddyInfo.add(add);
		buddyInfo.setEnabled(false);
		
		menuBar.add(addrbook);
		menuBar.add(buddyInfo);
		
		//Setup Panel
		mainDialog.setEditable(false);
		add(mainDialog);
		add(creationPanel);
		creationPanel.setVisible(false);

		//Setup Frame
		setJMenuBar(menuBar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
	    setVisible(true);
	}
	
	public static void main(String[] args) {		
		AddressBookFrame addressBookGUI = new AddressBookFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (MenuCommands.Create.toString() == command){
			//Create Address Book
			mainDialog.setText(" Address Book successfully created.");
			book = new AddressBook();
			
			//Manage menu items
			create.setEnabled(false);
			save.setEnabled(true);
			display.setEnabled(true);
			buddyInfo.setEnabled(true);
			add.setEnabled(true);
			
			setCreationPanelFocus(false);
			
		} else if (MenuCommands.Display.toString() == command){
			//Display Address Book
			if (book.count()>0){
				mainDialog.setText(book.toString());
			} else {
				mainDialog.setText(" No Entries :(");
			}
			
			setCreationPanelFocus(false);
			
		} else if (MenuCommands.Save.toString() == command){
			//Save Address Book to txt
			BufferedWriter out;
			try {
				out = new BufferedWriter(new FileWriter("AddressBook.txt"));
				out.write(book.toString());
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			mainDialog.setText("AddressBook.txt created");
			setCreationPanelFocus(false);
		} else if (MenuCommands.Add.toString() == command){
			//Add BuddyInfo to Address Book
			creationPanel.refresh();
			
			//Manage menu items		
			setCreationPanelFocus(true);
		}
	}
	
	public void save(BuddyInfo buddy){
		book.addBuddy(buddy);
		mainDialog.setText("BuddyInfo saved");
		
		setCreationPanelFocus(false);
	}
	
	private void setCreationPanelFocus(boolean panelFocus){
		//Toggle main dialog visibility
		creationPanel.setVisible(panelFocus);
		mainDialog.setVisible(!panelFocus);
		mainDialog.validate();
	}
}
