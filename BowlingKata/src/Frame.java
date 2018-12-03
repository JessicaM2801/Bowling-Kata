import java.util.ArrayList;

public class Frame {
	private ArrayList<Integer> rolls;
	
	public Frame() {
		rolls = new ArrayList<Integer>();
	}
	
	public void addRoll(int value) {
		rolls.add(value);
	}
	
	public ArrayList<Integer> getRolls(){
		return rolls;
	}
}