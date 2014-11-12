// Implements the game of Craps logic
// Yingli's Code
// This implements the game, Craps, and outlines the rules and processes of the game

public class CrapsGame
{
  private int point = 0;

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
			result = 1; // if the player rolls a 7 or 11 on the first turn, they win once
			
		}else if(total == 2 || total == 3 || total == 12){
			result = -1; // if the player rolls a 2, 3 or 12 on the first turn, they lose once
			
		}else{
			result = 0; // if they player gets anything other than 7, 11, 2, 3, or 12, they continue in the code
			point = total;
		}
		
	}else if (point != 0){
		if ((total == 7)){ // if the player gets a 7 on the second round after a point is established, they lose
			result = -1;
			point = 0;  // resets the total points so that it doesn't create an infinite loop
			  
		}else if (total == point){ // if the player gets the same number as in the 'point' round, they win
			result = 1;
			point = 0; // resets the total points so that it doesn't create an infinite loop
			  
		}else{ // if the player gets anything that's not 7 or the point, they repeat
			result = 0;
		  }
	  }
    return result;
  }

  public int getPoint(){
	return point;
  }
}
