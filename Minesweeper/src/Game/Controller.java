package Game;

/*
 * The controller of the minesweeper model
 */
public class Controller {
	private Field minesweeper;
	
	public Controller(Field m){
		minesweeper = m;
	}
	
	public void newGame(){
		minesweeper.start();
	}
	
	public void flipTile(int row, int column){
		minesweeper.flipTile(row, column);
	}
}
