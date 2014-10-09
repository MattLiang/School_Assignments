import javax.swing.JFrame;


public class AddressBookFrame extends JFrame{
	
	public AddressBookFrame(){
		super("Address Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		BuddyInfo matt = new BuddyInfo();
		matt.setName("Matt");
		matt.setAddress("123 Fake St.");
		matt.setPhoneNum("613-123-4567");
		
		BuddyInfo mike = new BuddyInfo();
		mike.setName("Mike");
		mike.setAddress("999 Fake St.");
		mike.setPhoneNum("613-987-6543");
		
		AddressBook book = new AddressBook();
		book.addBuddy(matt);
		book.addBuddy(mike);
		
		System.out.println(book.toString());
		
		AddressBookFrame addressBookGUI = new AddressBookFrame();
	}
}
