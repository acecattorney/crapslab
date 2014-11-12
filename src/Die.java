/*
 * Die class for the "Craps" project 
 * Simulates a dice, generates 1-6 and stores in a field.
 */
public class Die {
	private int numDots = 1;
	public void roll(){
		numDots = (int)(Math.random()*6+1);
	}
	public int getNumDots(){
		return numDots;
	}
}
