package Game;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The view of the model
 * Gui gets updated by the model
 * Main is found here
 * @author matthewliang
 *
 */
public class Gui extends JFrame implements Observer, ActionListener{
	
	private JPanel contentPane;
	private TileButton[][] buttons;
	private Controller controller;
	private boolean gameOver;

	public Gui(Controller cont) {
		gameOver = false;
		controller = cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(Field.ROWSIZE,Field.COLUMNSIZE, 0, 0));
		buttons = new TileButton[Field.ROWSIZE][Field.COLUMNSIZE];
		
		for (int r = 0; r < Field.ROWSIZE; r++) {
			for (int c = 0; c < Field.COLUMNSIZE; c++) {
				TileButton tile = new TileButton(r, c);
				tile.addActionListener(this);
				buttons[r][c] = tile;
				contentPane.add(tile);
			}
		}
		
		setContentPane(contentPane);
	}

	public static void main(String[] args) {
		Field field = new Field();
		field.setBomb(0, 0);
		Controller cont = new Controller(field);
		Gui gui = new Gui(cont);
		field.addObserver(gui);
		cont.newGame();
		gui.setSize(300, 300);
		gui.setVisible(true);
	}


	/**
	 * React to model event
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		//update board
		GameUpdate update = (GameUpdate) arg1;
		// Update board
		updateBoard(update.getField(),update.getGameState());
	}
	
	private void updateBoard(Tile[][] field, State.Game gameState){
		for (int r = 0; r < Field.ROWSIZE; r++) {
			for (int c = 0; c < Field.COLUMNSIZE; c++) {
				buttons[r][c].setState(field[r][c].getFlipped(), field[r][c].getState(), field[r][c].getNeighbouringbombCount());
			}
		}
		
		if (gameState != State.Game.none){
			String msg = "";
			if (gameState == State.Game.lose){
				msg = "Lose";
			} else {
				msg = "Win";
			}
			JOptionPane.showMessageDialog(null, msg, "Game Over", JOptionPane.OK_OPTION);
			this.dispose();
		}
		
	}

	/**
	 * React to player button press
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		TileButton button = (TileButton) arg0.getSource();
		if (!button.isFlipped() && !gameOver){
			controller.flipTile(button.getRow(), button.getColumn());
		}
	}

}
