package Game;
import java.util.Observable;

/**
 * The model
 * @author matthewliang
 *
 */
public class Field extends Observable {
	private Tile[][] field;
	public static int ROWSIZE = 3;
	public static int COLUMNSIZE = 3;
	private int flipCount, bombCount;
	private boolean bombHit;
	
	public Field(){
		field = new Tile[ROWSIZE][COLUMNSIZE];
		flipCount = 0;
		bombCount = 0;
		bombHit = false;
		
		//init board
		for (int r = 0; r<ROWSIZE;r++){
			for (int c=0; c<COLUMNSIZE;c++){
				field[r][c]= new Tile(State.Tile.empty);
			}
		}
	}
	
	public void setBomb(int row, int column){
		field[row][column].setState(State.Tile.bomb);
		bombCount++;
		
		//Lay out bomb count values
		for (int r = 0; r<ROWSIZE;r++){
			for (int c=0; c<COLUMNSIZE;c++){
				field[r][c].setNeighbouringbombCount(getBombCount(r,c));
			}
		}
	}
	
	public void start(){
		//Notify game is ready
		this.setChanged();
		this.notifyObservers(new GameUpdate(field,getGameState()));
	}
	
	public void flipTile(int row, int column){
		//Flip only if the tile hasn't already been flipped
		if (!field[row][column].getFlipped()){
			//flip
			field[row][column].setFlipped(true);
			flipCount++;
			
			//check if flipped tile is bomb
			bombHit = field[row][column].getState()==State.Tile.bomb;
			
			//notify observers
			this.setChanged();
			this.notifyObservers(new GameUpdate(field,getGameState()));
		}
	}
	
	/**
	 * Made public for the purpose of the unittest
	 * @return
	 */
	public State.Game getGameState(){
		//Win
		if (!bombHit && (flipCount == (ROWSIZE*COLUMNSIZE-bombCount))){
			return State.Game.win;
		} 
		//Lose
		else if (bombHit) {
			return State.Game.lose;
		} 
		//Nothing
		else {
			return State.Game.none;
		}
	}
	
	//Count the number of adjacent bombs surrounding a given empty space
	private int getBombCount(int row, int column){
		int bcount = 0;
		
		if (field[row][column].getState()!=State.Tile.bomb){
			for (int r=row-1;r<=row+1;r++){
				for (int c=column-1;c<=column+1;c++){
					if (r>=0 && r<ROWSIZE && c>=0 && c<COLUMNSIZE && field[r][c].getState()==State.Tile.bomb){
							bcount++;
					}
				}
				
			}
		}
		
		return bcount;
	}
	
	/**
	 * For unit test purpose only
	 */
	public Tile[][] getTiles(){
		return field;
	}
	
	/**
	 * For unit test purpose only
	 */
	public int getFlipCount(){
		return this.flipCount;
	}
}
