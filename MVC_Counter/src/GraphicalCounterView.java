import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

/**
 * View
 * @author matthewliang
 *
 */
public class GraphicalCounterView extends JTextField implements Observer{
	public GraphicalCounterView(String str){
		super(str);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		setText(arg0.toString());
	}

}
