package Game;
import java.awt.Color;

import javax.swing.JButton;


@SuppressWarnings("serial")
public class TileButton extends JButton {
	
	private int row, column;
	private boolean flipped;

	public TileButton(int r, int c) {
		row = r;
		column = c;
		flipped = false;
		setBackground(Color.LIGHT_GRAY);
	}

	/**
	 * Sets the tile.
	 *
	 * @param t the new tile
	 */
	public void setState(boolean flipped, State.Tile tileState, int bombCount) {
		if (flipped){
			this.flipped = flipped;
			if (tileState==State.Tile.bomb){
				setText("B");
				setBackground(Color.BLACK);
			} else {
				setText(bombCount+"");
				setBackground(Color.WHITE);
			}
		}
	}

	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Gets the column.
	 *
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}
	
	public boolean isFlipped(){
		return flipped;
	}
}
