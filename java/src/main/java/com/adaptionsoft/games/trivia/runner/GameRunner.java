
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		Random rand = new Random();
		playGameWith(rand);
	}

	public static void playGameWith(Random rand) {
		System.out.println("******************* Game Started *********************");
		Game aGame = new Game();

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");

		int roundCount = 1;
		do {
			System.out.println("*************** Round " + roundCount + " Started ***************");
			aGame.roll(rand.nextInt(5) + 1);

			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
			System.out.println("--------------- Round " + roundCount + " Ended -----------------");
			roundCount++;
		} while (notAWinner);
		System.out.println("------------------------- Game Ended ------------------------");
	}
}
