package Game;
public class Tile {
	private State.Tile state;
	private boolean flipped;
	private int neighbouringbombCount;
	
	public Tile(State.Tile s){
		state = s;
		flipped = false;
		neighbouringbombCount = 0;
	}

	public State.Tile getState() {
		return state;
	}

	public void setState(State.Tile state) {
		this.state = state;
	}
	
	public void setFlipped(boolean flip){
		flipped = flip;
	}
	
	public boolean getFlipped(){
		return flipped;
	}

	public int getNeighbouringbombCount() {
		return neighbouringbombCount;
	}

	public void setNeighbouringbombCount(int neighbouringbombCount) {
		this.neighbouringbombCount = neighbouringbombCount;
	}
}
