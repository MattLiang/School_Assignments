import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class BuddyCreationPanel extends JPanel implements ActionListener{
	private JLabel lbl_dialog, lbl_name, lbl_address, lbl_phone; 
	private JButton jb_save;
	private JTextField tf_name, tf_address, tf_phone;
	private AddressBookFrame abFrame;
	
	public BuddyCreationPanel(AddressBookFrame abFrame){
		//Initialize
		this.abFrame=abFrame;
		lbl_dialog = new JLabel("Buddy Info: ");
		lbl_name = new JLabel("Name:");
		lbl_address = new JLabel("Address:");
		lbl_phone = new JLabel("Phone #:");
		jb_save = new JButton("Save");
		tf_name = new JTextField();
		tf_address = new JTextField();
		tf_phone = new JTextField();
		
		//Setup Layout
		setLayout(new GridLayout(0,2));
		this.add(lbl_dialog);
		this.add(new JPanel());
		this.add(lbl_name);
		this.add(tf_name);
		this.add(lbl_address);
		this.add(tf_address);
		this.add(lbl_phone);
		this.add(tf_phone);
		this.add(jb_save);
		
		jb_save.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		abFrame.save(new BuddyInfo(tf_name.getText(),tf_address.getText(),tf_phone.getText()));
	}
	
	public void refresh(){
		tf_name.setText("");
		tf_address.setText("");
		tf_phone.setText("");
	}
}
