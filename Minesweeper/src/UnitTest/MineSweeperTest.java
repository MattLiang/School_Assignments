package UnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.Field;
import Game.State;
import Game.Tile;


public class MineSweeperTest {
	private Field field;
	private Tile[][] tiles;

	@Before
	public void setUp() throws Exception {
		field = new Field();
	}

	@Test
	public void testFlipBombTile() {
		field.setBomb(0, 0);
		field.flipTile(0, 0);
		tiles = field.getTiles();
		
		assertEquals("Tile that is flipped is indeed a bomb",State.Tile.bomb,tiles[0][0].getState());
		assertEquals("Player has lost",State.Game.lose,field.getGameState());
	}
	
	@Test
	public void testFlipEmptyTileWithNoBombs() {
		field.flipTile(0, 0);
		tiles = field.getTiles();
		
		assertEquals("Tile that is flipped is indeed an empty",State.Tile.empty,tiles[0][0].getState());
		assertEquals("Neighbour bomb count is 0",0,tiles[0][0].getNeighbouringbombCount());
		assertEquals("Game can continue",State.Game.none,field.getGameState());
	}
	
	@Test
	public void testFlipEmptyTileWithNearbyBombs() {
		field.setBomb(0, 0);
		field.setBomb(0, 1);
		field.flipTile(1, 1);
		tiles = field.getTiles();
		
		assertEquals("Tile that is flipped is indeed an empty",State.Tile.empty,tiles[1][1].getState());
		assertEquals("Neighbour bomb count is 2",2,tiles[1][1].getNeighbouringbombCount());
		assertEquals("Game can continue",State.Game.none,field.getGameState());
	}
	

	@Test
	public void testInvalidMove() {
		field.flipTile(1, 1);
		field.flipTile(1, 1);
		tiles = field.getTiles();
		
		assertEquals("Number of tiles flipped should still be at 1",1,field.getFlipCount());
	}

	@Test
	public void testWin() {
		field.setBomb(0, 0);
		field.flipTile(0, 1);
		field.flipTile(0, 2);
		field.flipTile(1, 0);
		field.flipTile(1, 1);
		field.flipTile(1, 2);
		field.flipTile(2, 0);
		field.flipTile(2, 1);
		field.flipTile(2, 2);
		tiles = field.getTiles();
		
		assertEquals("Game is over, player wins",State.Game.win,field.getGameState());
	}
	
	@Test
	public void testLose() {
		field.setBomb(0, 0);
		field.flipTile(0, 1);
		field.flipTile(0, 2);
		field.flipTile(1, 0);
		field.flipTile(1, 1);
		field.flipTile(1, 2);
		field.flipTile(2, 0);
		field.flipTile(2, 1);
		field.flipTile(0, 0);
		tiles = field.getTiles();
		
		assertEquals("Player plays last move on 0,0 (mine location). Game is over, player loses",State.Game.lose,field.getGameState());
	}
}
