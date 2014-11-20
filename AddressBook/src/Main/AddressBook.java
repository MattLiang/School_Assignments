package Main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;


public class AddressBook extends DefaultListModel<BuddyInfo> implements Serializable{
	
	public AddressBook(){
	}
	
	public String toString(){
		String addresses = "";
		for (Object buddy : this.toArray()){
			addresses += buddy.toString()+"\n";
		}
		return addresses;
	} 
	
	public void importFromTextFile(String filename){
		clear();
		File source = new File(filename);
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
	
	public void exportToTextFile(String filename){ //"./AddressBook.txt"
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(filename));
			out.write(this.toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void exportToFile(String filename){//"./AddressBook.tmp"
		//export
		FileOutputStream ostream = null;
		ObjectOutputStream p = null;
		try {
			ostream = new FileOutputStream(filename);
			p = new ObjectOutputStream(ostream);
			p.writeObject(this);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				p.close();
				ostream.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public AddressBook importFromFile(String filename){
		AddressBook importedBook = null;
		FileInputStream istream = null;
		ObjectInputStream input = null;
		try {
			istream = new FileInputStream("./AddressBook.tmp");
			input = new ObjectInputStream(istream);
			importedBook = (AddressBook)(input.readObject());
		} catch (IOException | ClassNotFoundException e1) {
			e1.printStackTrace();
		} finally {
			try {
				input.close();
				istream.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return importedBook;
	}
	
	
}
