import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void testAllMiss() {
		Game myGame = new Game();
		for(int i=0; i<9; i++)
			myGame.addFrame(0,0);
		myGame.addFrame(0,0,0);
		assertEquals("Alle Würfe daneben, Punkte: 0", 0, myGame.calculateScores());
	}
	
	@Test
	void testAllStrike() {
		Game myGame = new Game();
		for(int i=0; i<9; i++)
			myGame.addFrame(10);
		myGame.addFrame(10,10,10);
		assertEquals("Alle Würfe Strike, Punkte: 300", 300, myGame.calculateScores());
	}
	
	@Test
	void testAllSpare() {
		Game myGame = new Game();
		for(int i=0; i<9; i++)
			myGame.addFrame(8,2);
		myGame.addFrame(8,2,8);
		assertEquals("Alle Würfe Spare, Punkte: 180", 180, myGame.calculateScores());
	}
	
	@Test
	void testAll2PinsDown() {
		Game myGame = new Game();
		for(int i=0; i<10; i++)
			myGame.addFrame(2,2);
		assertEquals("Alle Würfe 2 getroffen, Punkte: 40", 40, myGame.calculateScores());
	}
	
	@Test
	void test1StrikeRest2PinsDown() {
		Game myGame = new Game();
		myGame.addFrame(10);
		for(int i=0; i<9; i++)
			myGame.addFrame(2,2);
		assertEquals("1 Strike, alle anderen Würfe 2, Punkte: 50", 50, myGame.calculateScores());
	}
	
	@Test
	void testLastStrikeRest2PinsDown() {
		Game myGame = new Game();
		for(int i=0; i<9; i++)
			myGame.addFrame(2,2);
		myGame.addFrame(10,2,2);
		assertEquals("Letzter Wurf Strike, alle anderen Würfe 2, Punkte: 50", 50, myGame.calculateScores());
	}
	
	@Test
	void test1SpareRest2PinsDown() {
		Game myGame = new Game();
		myGame.addFrame(8,2);
		for(int i=0; i<9; i++)
			myGame.addFrame(2,2);
		assertEquals("Erster Frame Spare, alle anderen Würfe 2, Punkte: 48", 48, myGame.calculateScores());
	}
	
	@Test
	void testLastSpareRest2PinsDown() {
		Game myGame = new Game();
		for(int i=0; i<9; i++)
			myGame.addFrame(2,2);
		myGame.addFrame(8,2,2);
		assertEquals("Letzter Wurf Spare, alle anderen Würfe 2, Punkte: 48", 48, myGame.calculateScores());
	}
}
