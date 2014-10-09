import java.util.ArrayList;
import java.util.List;


public class AddressBook {
	private List<BuddyInfo> book;
	
	public AddressBook(){
		book = new ArrayList<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo bud){
		book.add(bud);
	}
	
	public void removeBuddy(BuddyInfo bud){
		book.remove(bud);
	}
	
	public String toString(){
		String addresses = "";
		for (BuddyInfo buddy : book){
			addresses += buddy.toString()+"\n";
		}
		
		return addresses;
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
	}
}
