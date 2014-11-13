package Game;

public class GameUpdate {
	private Tile[][] field;
	private State.Game state;
	
	public GameUpdate(Tile[][] f, State.Game s){
		field = f;
		state = s;
	}

	public Tile[][] getField() {
		return field;
	}

	public State.Game getGameState() {
		return state;
	}
}
