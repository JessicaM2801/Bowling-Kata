import java.util.ArrayList;

public class Game {
	
	private ArrayList<Frame> frames;
	
	public Game() {
		frames = new ArrayList<Frame>();
	}
	
	public void addFrame(int roll1, int roll2) {
		Frame toAdd = new Frame();
		toAdd.addRoll(roll1);
		toAdd.addRoll(roll2);
		frames.add(toAdd);
	}
	
	public void addFrame(int roll1, int roll2, int roll3) {
		Frame toAdd = new Frame();
		toAdd.addRoll(roll1);
		toAdd.addRoll(roll2);
		toAdd.addRoll(roll3);
		frames.add(toAdd);
	}
	
	public int calculateScores() {
		int score = 0;
		ArrayList<Integer> rolls = new ArrayList<Integer>();
		boolean hitAllPins = false;
		for(int i=0; i<frames.size(); i++) {
			rolls = frames.get(i).getRolls();
			
		}
		return score;
	}
}
