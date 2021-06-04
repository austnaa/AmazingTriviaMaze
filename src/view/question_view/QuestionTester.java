package view.question_view;

import model.Player;
import model.question.Question;
import model.question.TriviaQuestions;
import view.GamePanel;

public class QuestionTester {
    public static void main(String[] aegs) {
        Question q = TriviaQuestions.getTriviaQuestions().get(69);
        Player p = new Player();
        FreeResponseQuestionPanel panel = new FreeResponseQuestionPanel(p, q);
        QuestionFrame frame = new QuestionFrame(panel);

        
        
    }

}
