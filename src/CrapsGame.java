// Implements the game of Craps logic

public class CrapsGame
{
  private int point = 0;
  private int savedPoint = 0;

  /**
   *  Calculates the result of the next dice roll in the Craps game.
   *  The parameter total is the sum of dots on two dice.
   *  point is set to the saved total, if the game continues,
   *  or 0, if the game has ended.
   *  Returns 1 if player won, -1 if player lost,
   *  0 if player continues rolling.
   *  
   *  NOTE: ADDED IN ALL THE RULES (en.wikipedia.org/wiki/Craps#Rules_of_play)
   *  "Each round has two phases: "come-out" and "point". To start a round, 
   *  the shooter makes one or more "come-out" rolls. A come-out roll of 2, 3 or 12 is called
   *   "craps" or "crapping out", and anyone betting the Pass line loses.
   *    A come-out roll of 7 or 11 is a "natural", and the Pass line wins. 
   *    The other possible numbers are the point numbers: 4, 5, 6, 8, 9, and 10. 
   *    If the shooter rolls one of these numbers on the come-out roll, this establishes the 
   *    "point" - to "pass" or "win", the point number must be rolled again before a seven."
   */
  public int processRoll(int total)
  {
	int result = 0; // -1 player lost, 0 games continue, 1 player won
	
	if (point == 0){
		if (total == 7 || total == 11){
			result = 1;
			
		}else if(total == 2 || total == 3 || total == 12){
			result = -1;
			
		}else{
			result = 0;
			point = total;
		}
		
	}else if (point != 0){
		if ((total == 7)){
			result = -1;
			point = 0;  //******* Need to reset points
			  
		}else if (total == point){
			result = 1;
			point = 0; // ******** Need to reset points
			  
		}else{
			result = 0;
		  }
	  }
    return result;
  }

  public int getPoint(){
	return point;
  }
}
