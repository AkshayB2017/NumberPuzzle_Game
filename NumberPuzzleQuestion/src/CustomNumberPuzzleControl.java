import java.awt.*;
import java.util.HashSet;
import java.util.Random;


class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int i=0;
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		for(Button b: buttons) {
			if(b == buttonClicked) {
				if((emptyCellId == (i+1))  || (emptyCellId == (i-1)) || (emptyCellId == (i+4)) || (emptyCellId == (i-4))) {
					swapButton(buttons[emptyCellId],buttonClicked);
					emptyCellId = i;
					break;	
				}
			}i++;		
		}
	return emptyCellId;


	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		int e,g;
		int num=1;
		int a= getRandomNumber();
		for (int i=0; i<15; i++) {
		    arr[i]=(i+a)%15;
		    }

  
		return arr;
	}
	
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr=getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=i+1)
			{winner=false;
			  break;
			}
			
		}
		return winner;
	}
}