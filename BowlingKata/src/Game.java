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
		for(int i=0; i<frames.size()-1; i++) {
			rolls = frames.get(i).getRolls();
			for(int roll: rolls) {
				score += roll;
			}
			if(rolls.get(0) == 10) {
				rolls = frames.get(i+1).getRolls();
				score += rolls.get(0) + rolls.get(1);
				if(rolls.size() == 2 && rolls.get(0) == 10 && rolls.get(1) == 0) {
					score += frames.get(i+2).getRolls().get(0);
				}
			}
			else if(rolls.get(0)+rolls.get(1) == 10) {
				rolls = frames.get(i+1).getRolls();
				score += rolls.get(0);
			}
		}
		rolls = frames.get(frames.size()-1).getRolls();
		for(int roll: rolls) {
			score += roll;
		}
		return score;
	}
}
