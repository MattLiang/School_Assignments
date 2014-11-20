package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;


public class AddressBookFrame extends JFrame implements ActionListener{
	//Class Variables
	public enum MenuCommands {Create,Save,Display,Add,Import};
	
	//Menu Bar variables
	private JMenuBar menuBar;
	private JMenu addrbook;
	private JMenu buddyInfo;
	private JMenuItem create;
	private JMenuItem mi_import;
	private JMenuItem save;
	private JMenuItem display;
	private JMenuItem add;
	
	//Variables
	private JTextArea mainDialog;
	private AddressBook addressBook;
	
	//Panel Variables
	private BuddyCreationPanel creationPanel;
	private AddressBookPanel addressBookPanel;
	
	public AddressBookFrame(){
		super("Address Book");
		
		//Initialize
		setLayout(new OverlayLayout(getContentPane()));
		mainDialog = new JTextArea();
		creationPanel = new BuddyCreationPanel(this);
		
		//Setup Menu bar
		menuBar = new JMenuBar();
		addrbook = new JMenu("Address Book");
		buddyInfo = new JMenu("BuddyInfo");
		
		create = new JMenuItem(MenuCommands.Create.toString());
		create.addActionListener(this);
		mi_import = new JMenuItem(MenuCommands.Import.toString());
		mi_import.addActionListener(this);
		save = new JMenuItem(MenuCommands.Save.toString());
		save.setEnabled(false);
		save.addActionListener(this);
		display = new JMenuItem(MenuCommands.Display.toString());
		display.setEnabled(false);
		display.addActionListener(this);
		add = new JMenuItem(MenuCommands.Add.toString());
		add.addActionListener(this);
		
		addrbook.add(create);
		addrbook.add(mi_import);
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
			addressBook = new AddressBook();
			addressBookPanel = new AddressBookPanel(this);
			add(addressBookPanel);
			addressBookPanel.setVisible(false);
			
			//Manage menu items
			create.setEnabled(false);
			mi_import.setEnabled(true);
			save.setEnabled(true);
			display.setEnabled(true);
			buddyInfo.setEnabled(true);
			add.setEnabled(true);
			
		} else if (MenuCommands.Display.toString() == command){
			//Display Address Book Panel
			addressBookPanel.setVisible(true);
			creationPanel.setVisible(false);
			mainDialog.setVisible(false);
			
		} else if (MenuCommands.Save.toString() == command){
			//Save Address Book to txt
			System.out.println("in");
			System.out.println(addressBook.toString());
			addressBook.exportToFile("./AddressBook.tmp");
			
			mainDialog.setText("AddressBook.txt created");

			addressBookPanel.setVisible(false);
			creationPanel.setVisible(false);
			mainDialog.setVisible(true);
			
		} else if (MenuCommands.Add.toString() == command){
			//Add BuddyInfo to Address Book
			creationPanel.refresh();
			
			//Manage menu items		
			addressBookPanel.setVisible(false);
			creationPanel.setVisible(true);
			mainDialog.setVisible(false);
		}
		
		else if (MenuCommands.Import.toString() == command){
			addressBook = addressBook.importFromFile("./AddressBook.tmp");
			mainDialog.setText("Import Successful");

			addressBookPanel.setVisible(false);
			creationPanel.setVisible(false);
			mainDialog.setVisible(true);
		}
	}
	
	public void save(BuddyInfo buddy){
		addressBook.addElement(buddy);
		mainDialog.setText("BuddyInfo saved");
		
		addressBookPanel.setVisible(false);
		creationPanel.setVisible(false);
		mainDialog.setVisible(true);
	}
	
	public void deleteBuddy(BuddyInfo buddy){
		addressBook.removeElement(buddy);
	}
	
	public void editBuddyInfo(BuddyInfo buddy){
		creationPanel.editBuddy(buddy);
		
		addressBookPanel.setVisible(false);
		creationPanel.setVisible(true);
		mainDialog.setVisible(false);
	}
	
	public AddressBook getAddressBook(){
		return addressBook;
	}
}
