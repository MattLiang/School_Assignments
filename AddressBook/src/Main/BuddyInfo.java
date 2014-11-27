package Main;

import java.io.Serializable;
import java.util.Scanner;

public class BuddyInfo implements Serializable {
	private String name;
	private String address;
	private String phoneNum;
	private int age;
	
	public BuddyInfo(String name, String address, String phoneNum){
		this.address = address;
		this.name = name;
		this.phoneNum = phoneNum;
	}
	
	public BuddyInfo(){
	}
	
	public BuddyInfo(BuddyInfo buddy){
		this.address = buddy.getAddress();
		this.name = buddy.getName();
		this.phoneNum = buddy.getPhoneNum();
	}
	
	public String getGreeting(){
		return name + ": Hello!";
	}

	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
	
	public boolean isOver18(){
		return age>18;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String toString(){
		return name+"-"+address+"-"+phoneNum;
	}
	
	public static BuddyInfo importBuddy(String info){
		Scanner s = null;
		BuddyInfo buddy = null;
		
		try {
			s = new Scanner(info);
			s.useDelimiter("-");
			String str1 = s.next();
			String str2 = s.next();
			String str3 = s.next();
			buddy = new BuddyInfo(str1,str2,str3);
			System.out.println("Buddy:" + buddy.toString());
		} catch (Exception e){
			
		} finally {
			s.close();
		}
		
		return buddy;
	}
	
	public String toXml(){
		StringBuilder xml = new StringBuilder();
		xml.append("<buddy>\n");
		xml.append("\t<name>"+name+"</name>\n");
		xml.append("\t<address>"+address+"</address>\n");
		xml.append("\t<phone>"+phoneNum+"</phone>\n");
		xml.append("</buddy>\n");
		return xml.toString();
	}
}
