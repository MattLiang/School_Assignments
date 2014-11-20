package Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;


public class AddressBook extends DefaultListModel<BuddyInfo>{
	
	public AddressBook(){
	}
	
	public String toString(){
		String addresses = "";
		for (Object buddy : this.toArray()){
			addresses += buddy.toString()+"\n";
		}
		return addresses;
	} 
	
	public void importAddressBook(File source){
		clear();
		Scanner s_book = null;
		try {
			s_book = new Scanner(source).useDelimiter("\n");
			while (s_book.hasNext()){
				String s = s_book.next();
				addElement(BuddyInfo.importBuddy(s));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			s_book.close();
		}
	} 
}
