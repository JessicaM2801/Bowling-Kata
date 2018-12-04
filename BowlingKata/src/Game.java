import java.util.ArrayList;

public class Game {
	
	private ArrayList<Frame> frames;
	
	public Game() {
		frames = new ArrayList<Frame>();
	}
	
	public void addFrame(int roll1) {
		Frame toAdd = new Frame();
		toAdd.addRoll(roll1);
		frames.add(toAdd);
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
			score += getScoreFromRolls(rolls);
			if(rolls.get(0) == 10)
				score += getAdditionalScoreFromStrike(i);
			else if(getScoreFromRolls(rolls) == 10)
				score += getAdditionalScoreFromSpare(i);
		}
		rolls = frames.get(frames.size()-1).getRolls();
		score += getScoreFromRolls(rolls);
		return score;
	}
	
	private int getScoreFromRolls(ArrayList<Integer> rolls) {
		int score = 0;
		for(int roll: rolls)
			score += roll;
		return score;
	}
	
	private int getAdditionalScoreFromStrike(int strikeFrameIndex) {
		int score = 0;
		ArrayList<Integer> rolls = frames.get(strikeFrameIndex+1).getRolls();
		score += rolls.get(0);
		if(rolls.size() == 1)
			score += frames.get(strikeFrameIndex+2).getRolls().get(0);
		else
			score += rolls.get(1);
		return score;
	}
	
	private int getAdditionalScoreFromSpare(int spareFrameIndex) {
		int score = 0;
		ArrayList<Integer> rolls = frames.get(spareFrameIndex+1).getRolls();
		score += rolls.get(0);
		return score;
	}
}
