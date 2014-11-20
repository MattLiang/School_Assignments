package UnitTest;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Before;
import org.junit.Test;

import Main.AddressBook;
import Main.BuddyInfo;

public class AddressBookTest {
	private AddressBook book = null;
	private BuddyInfo charles = new BuddyInfo("c","12F","000");
	private BuddyInfo matt = new BuddyInfo("m","12E","123");

	@Before
	public void setUp() throws Exception {
		book = new AddressBook();
	}

	@Test
	public void testAddBuddy() {
		book.addElement(charles);
		assertEquals("Address has added one more",1,book.size());
	}

	@Test
	public void testRemoveBuddy() {
		book.addElement(charles);
		book.removeElement(charles);
		assertEquals("Address book is empty",0,book.size());
		book.removeElement(matt);
		assertEquals("Address book is empty",0,book.size());
	}

	@Test
	public void testToString() {
		String addr = "c-12F-000\n";
		book.addElement(charles);
		assertEquals("AddressBook contains c: 12F, 000",addr,book.toString());
	}

	@Test
	public void testEmptyAddressBook() {
		assertEquals("Address book is empty",0,book.size());
	}

	@Test
	public void testClear() {
		book.addElement(matt);
		book.addElement(charles);
		book.clear();
		assertEquals("Address book is cleared",0,book.size());
	}
	
	
	@Test
	public void testImportExportTextFile(){
		String filename = "./AddressBook.txt";
		String addr = "m-12E-123\nc-12F-000\n";
		book.addElement(matt);
		book.addElement(charles);
		
		//export
		book.exportToTextFile(filename);
		
		//import
		book.importFromTextFile(filename);
		
		assertEquals("Imported address book contains matt and charles info",addr,book.toString());
	}
	
	@Test
	public void testImportExportFile(){
		String filename = "./AddressBook.tmp";
		String addr = "m-12E-123\nc-12F-000\n";
		book.addElement(matt);
		book.addElement(charles);
		
		//export
		book.exportToFile(filename);
		
		//import
		book = book.importFromFile(filename);
		
		assertEquals("Imported address book contains matt and charles info",addr,book.toString());
	}

}
