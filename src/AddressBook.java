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
}
