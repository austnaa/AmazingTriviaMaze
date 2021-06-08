/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package model.question;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for retrieving trivia questions from the trivia questions database.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public final class TriviaQuestions {
    
    /** String for querying the questions. */
    private final static String QUESTION = "Question";

    /** String for querying the answers to the questions. */
    private final static String ANSWER = "Answer";

    /**
     * Private constructor so we cannot initialize an object of this class.
     */
    private TriviaQuestions() {

    }
    
    /**
     * Creates an ArrayList of questions from the database of trivia questions.
     * @return An ArrayList of questions from the database of trivia questions.
     */
    public static List<Question> getTriviaQuestions() {
        Connection connection = null;
        final List<Question> questionsList = new ArrayList<Question>();
        try {
            // Create a database connection.
            // We are using jdbc for the Java database connection and SQLite ("jdbc:sqlite").
            // Then we are using the actual .db physical file that we want to connect to ("jdbc:sqlite:db_name.db").
            final String url = "jdbc:sqlite:" + System.getProperty("user.dir") + 
                    "/src/model/question/TriviaQuestions.db";
            connection = DriverManager.getConnection(url);
            final Statement statement = connection.createStatement();
            // Sets the timeout to 30 seconds (if the query takes too long - good practice).
            statement.setQueryTimeout(30);

            // Adds the multiple choice questions to the question list.
            final ResultSet multipleChoiceSet = statement.executeQuery("SELECT * FROM MultipleChoice");
            while (multipleChoiceSet.next()) {
                final Option answer = new Option(multipleChoiceSet.getString(ANSWER), true);
                final Option optionB = new Option(multipleChoiceSet.getString("OptionB"), false);
                final Option optionC = new Option(multipleChoiceSet.getString("OptionC"), false);
                final Option optionD = new Option(multipleChoiceSet.getString("OptionD"), false);
                final Question question = new MultipleChoiceQuestion(multipleChoiceSet.getString(QUESTION),
                        answer, optionB, optionC, optionD);
                questionsList.add(question);
            }

            // Adds the true/false questions to the question list.
            final ResultSet trueFalseSet = statement.executeQuery("SELECT * FROM TrueFalse");
            while (trueFalseSet.next()) {
                final Option answer = new Option(multipleChoiceSet.getString(ANSWER), true);
                final Option incorrect = new Option(multipleChoiceSet.getString("Incorrect"), false);
                final Question question = new TrueFalseQuestion(trueFalseSet.getString(QUESTION),
                        answer, incorrect);
                questionsList.add(question);
            }

            // Adds the free response questions to the questions list.
            final ResultSet freeResponseSet = statement.executeQuery("SELECT * FROM FreeResponse");
            while (trueFalseSet.next()) {
                final Question question = new FreeResponseQuestion(freeResponseSet.getString(QUESTION),
                        freeResponseSet.getString(ANSWER));
                questionsList.add(question);
            }
        }
        catch (final SQLException exception) {
            System.out.println("The database file was not found!");
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (final SQLException exception) {
                System.out.println("Could not close the connection!");
            }
        }
        return questionsList;
    }
}