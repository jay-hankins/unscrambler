/* Jay Hankins
 * Avon High School
 * IUPUI Math Contest - Problem #5
 * 
 * Original Contest Problem:
 * You have ten Scrabble
 * tiles with the letters A E F G I L M N O S in that
 * order. Your task is to shuffle them around to obtain a ten-letter English word (there
 * is only one). However, you are only allowed two types of manipulation: you can shift
 * the first letter to the last position, and you can pick the letters in odd positions (in
 * order) followed by the letters in even positions (in order). Thus, starting with the
 * letters in alphabetic order, you can reach E F G I L M N O S A , and A
 * F I M O E G L N S . What is the shortest sequence of moves needed to
 * complete the task?

 * This Java program outputs the number position result of the word "flamingoes," the only 
 * 10-letter English word than can be spelled from the given letters, by performing the 
 * operations like a recursion tree (see diagram). 
 * Note: This program does not output the number of "tries" or "moves" to get to 
 * "flamingoes." I will explain the logic behind deducing the number of moves from the position by hand.
 */

import java.util.ArrayList;

public class Runner {	
	public static String moveToEnd(String todo) //This method moves the first letter of the string to the last position.
	{	String fixit = todo.substring(1)+todo.substring(0,1);		
		return fixit;
	}
	
	public static String oddsEvens(String todo) //This method reconstructs the string by picking the odd then the even letters.
	{	String fixit = todo.substring(0,1)+todo.substring(2,3)+todo.substring(4,5)+todo.substring(6,7)+todo.substring(8,9)+todo.substring(1,2)+todo.substring(3,4)+todo.substring(5,6)+todo.substring(7,8)+todo.substring(9);
		return fixit;
	}

	public static void main(String[] args)	
	{	String original = "AEFGILMNOS"; //The starting string.
		
		ArrayList<String> worker = new ArrayList<String>();		
		worker.add(original);
		
		int i = 0;
		
		do
		{	worker.add(moveToEnd(worker.get(i)));
			worker.add(oddsEvens(worker.get(i)));
			
			System.out.println(worker.get(i));
			i++;
		}while(!(worker.get(i-1).equals("FLAMINGOES")));
		
		System.out.println(i);
		
	}
}
