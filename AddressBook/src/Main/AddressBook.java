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
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


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
			istream = new FileInputStream(filename);
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
	
	public String toXml(){
		StringBuilder xml = new StringBuilder();
		xml.append("<addressbook>\n");
		for (Object buddy : this.toArray()){
			xml.append(((BuddyInfo)buddy).toXml());
		}
		xml.append("</addressbook>");
		return xml.toString();
	}
	
	public void ExportToXmlFile(){
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("AddressBook.xml"));
			out.write(this.toXml());
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
	
	public void importFromXmlFileDOM() throws Exception{
		this.clear();
		//AddressBook importedBook = new AddressBook();
		BuddyInfo tempBuddy = null;
		File f = new File("AddressBook.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder d = factory.newDocumentBuilder();
		Document doc = d.parse(f);
		
		System.out.println("Root: "+doc.getDocumentElement().getNodeName());
		
		//Buddy Node list
		NodeList lst = doc.getDocumentElement().getChildNodes();
		for(int ii=0; ii<lst.getLength();ii++){
			Node n = lst.item(ii);

			//Buddy node found, initialize new buddy
			if (n.getNodeName().compareTo("buddy")==0){
				tempBuddy = new BuddyInfo();
				NodeList buddyLst = n.getChildNodes();
				
				//Go through information about buddy
				for(int in=0; in<buddyLst.getLength();in++){
					Node n_inner = buddyLst.item(in);
					if (n_inner.getNodeName().compareTo("name")==0){
						System.out.println("Child: "+n_inner.getNodeName()+" ==> "+n_inner.getTextContent());
						tempBuddy.setName(n_inner.getTextContent());
					} else if (n_inner.getNodeName().compareTo("address")==0){
						System.out.println("Child: "+n_inner.getNodeName()+" ==> "+n_inner.getTextContent());
						tempBuddy.setAddress(n_inner.getTextContent());
					} else if (n_inner.getNodeName().compareTo("phone")==0){
						System.out.println("Child: "+n_inner.getNodeName()+" ==> "+n_inner.getTextContent());
						tempBuddy.setPhoneNum(n_inner.getTextContent());
					}
				}
				
				//Finished grabbing info from the buddy, add to addressbook
				this.addElement(tempBuddy);
			}
		}
		
		System.out.println("+++Imported Book+++\n"+toString());
		//return importedBook;
	}
}
