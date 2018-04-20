package jQuiz.ADT;

/**
 * @author  C1740129
 * @author  Kyle Morris
 * @version 1.0
 * @since   2018-04-04
 */
public class Answer {

    private String[] answers;

    public Answer(){
        //Default Constructor
    }

    /**
     * setAnswer()
     * @param answer
     */
    public void setAnswer(String[] answer) {
        this.answers = answers;
    }

    /**
     * getAnswer()
     */
    public String[] getAnswer() {
        return this.answers;
    }

}