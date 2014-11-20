package UnitTest;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Before;
import org.junit.Test;

import Main.AddressBook;
import Main.BuddyInfo;

public class BuddyInfoTest {
	private BuddyInfo buddy = null;
	private String name = "Matt";
	private String address = "88 Fake st.";
	private String phoneNum = "613-123-4567";

	@Before
	public void setUp() throws Exception {
		buddy = new BuddyInfo(name,address,phoneNum);
	}

	@Test
	public void testGetName() {
		assertEquals("Buddy name is Matt","Matt",buddy.getName());
	}

	@Test
	public void testSetName() {
		buddy.setName("Charles");
		assertEquals("Buddy name is Charles","Charles",buddy.getName());
	}

	@Test
	public void testGetAddress() {
		assertEquals("Buddy's address is 88 Fake st.","88 Fake st.",buddy.getAddress());
	}

	@Test
	public void testSetAddress() {
		buddy.setAddress("123 Concord ave.");
		assertEquals("Buddy's address is 123 Concord ave.","123 Concord ave.",buddy.getAddress());
	}

	@Test
	public void testGetPhoneNum() {
		assertEquals("Buddy's phone# is 613-123-4567","613-123-4567",buddy.getPhoneNum());
	}

	@Test
	public void testSetPhoneNum() {
		buddy.setPhoneNum("123-456-7890");
		assertEquals("Buddy's phone# is 123-456-7890","123-456-7890",buddy.getPhoneNum());
	}

	@Test
	public void testToString() {
		assertEquals("Info - Matt: 88 Fake st., 613-123-4567","Matt-88 Fake st.-613-123-4567",buddy.toString());
	}

	@Test
	public void testBuddyInfoCopy(){
		BuddyInfo charles = new BuddyInfo("c","12F","000");
		buddy = new BuddyInfo(charles);
		assertEquals("Name: c","c",buddy.getName());
		assertEquals("Address: 12F","12F",buddy.getAddress());
		assertEquals("Phone#: 000","000",buddy.getPhoneNum());
	}
	
	@Test
	public void testGetGreeting(){
		assertEquals("Message - Matt: Hello!","Matt: Hello!",buddy.getGreeting());
	}

	@Test
	public void testSetAge(){
		buddy.setAge(15);
		assertEquals("Age 15",15,buddy.getAge());
	}
	
	@Test
	public void testGetAge(){
		buddy.setAge(12);
		assertEquals("Age 12",12,buddy.getAge());
	}
	
	@Test
	public void testIsOver18(){
		assertTrue("Is under 18",!buddy.isOver18());
	}
	
	@Test
	public void testSerializable(){
		
		//export
		FileOutputStream ostream = null;
		ObjectOutputStream p = null;
		try {
			ostream = new FileOutputStream("./Buddy.tmp");
			p = new ObjectOutputStream(ostream);
			p.writeObject(buddy);
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
		
		//Import
		FileInputStream istream = null;
		ObjectInputStream input = null;
		try {
			istream = new FileInputStream("./Buddy.tmp");
			input = new ObjectInputStream(istream);
			buddy = (BuddyInfo)(input.readObject());
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
		
		assertEquals("Info - Matt: 88 Fake st., 613-123-4567","Matt-88 Fake st.-613-123-4567",buddy.toString());
	}
}
