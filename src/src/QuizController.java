
/**
 * 
 * @author 	Kyle Davies
 * @author  Flynn Ellis
 * @version 1.0
 * @since 	2018-04-04
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class QuizController {

	private QuizModel model;
	private QuizView view;
	
	/**
	 * Default Constructor
	 * @param model
	 * @param view
	 */
	public QuizController(QuizModel model, QuizView view) {
		this.model = model;
		this.view = view;
	}

	public static void foo() throws InterruptedException { //need to add ability to break out of quiz and return to menu
		Scanner in = new Scanner(System.in);
		String question = "What is 2+2?\n"; //temp hardcoded question
		int correctAnswerIndex = 1;		  //temp hardcoded correct answer
		String[] answers = {"5", "4", "3", "9"}; //temp hardcoded answers
		
		int questionsAsked = 0;
		int questionsCorrect = 0;
		//start while loop here (will do once we have started pulling questions)
		
		System.out.println(question);
		questionsAsked += 1; //each time loop runs increment
		for(int i = 0; i<answers.length; i++) { //prints all answers
			System.out.println((i+1) + ".  " +answers[i]);
		}
		
		System.out.println("\nAnswer: ");
		String inputtedAnswer = in.nextLine();
		//validate inputtedAnswer, if invalid answer prompt again
		int cleanInput = Integer.parseInt(inputtedAnswer)-1;
		
		System.out.println("");
		System.out.print("Result: ");
		if(answers[cleanInput] == (answers[correctAnswerIndex])) {
			System.out.println("Correct, " +answers[correctAnswerIndex]+" was the right answer!");
			questionsCorrect +=1; //each time answer right increment
		} else {
			System.out.println("Incorrect, the correct answer was actually "+answers[correctAnswerIndex]+"!");
		}
		TimeUnit.SECONDS.sleep(5);

		//while loop end
		
		System.out.println("\n");
		System.out.println("Performance Summary");
		System.out.println("-------------------");
		System.out.println("You answered "+questionsCorrect+ " out of "+questionsAsked+ " questions correctly!");


	}

	/**
	 * main()
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		foo();
		
		
		
	}

}
