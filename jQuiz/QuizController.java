package jQuiz;

/**
 * @author  C1740129
 * @author  Kyle Morris
 * @version 1.0
 * @since   2018-04-04
 */
public class QuizController {

    private QuizController controller;
    private QuizModel model;

    /**
     * @param controller
     * @param model
     */
    public QuizController(QuizController controller, QuizModel model) { 
        this.controller = controller;
        this.model = model;    
    }

    /**
     * main()
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(args);
    }

}