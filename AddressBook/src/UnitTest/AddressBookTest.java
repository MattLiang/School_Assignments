package UnitTest;

import static org.junit.Assert.*;

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
		book.addBuddy(charles);
		assertEquals("Address has added one more",1,book.size());
	}

	@Test
	public void testRemoveBuddy() {
		book.addBuddy(charles);
		book.removeBuddy(charles);
		assertEquals("Address book is empty",0,book.size());
		book.removeBuddy(matt);
		assertEquals("Address book is empty",0,book.size());
	}

	@Test
	public void testToString() {
		String addr = "c: 12F, 000\n";
		book.addBuddy(charles);
		assertEquals("AddressBook contains c: 12F, 000",addr,book.toString());
	}

	@Test
	public void testEmptyAddressBook() {
		assertEquals("Address book is empty",0,book.size());
	}

	@Test
	public void testClear() {
		book.addBuddy(matt);
		book.addBuddy(charles);
		book.clear();
		assertEquals("Address book is cleared",0,book.size());
	}

}
