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
 * The trivia questions grabbed from the trivia questions database.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public final class TriviaQuestions {

    /**
     * Private constructor so we cannot initialize an object of this class.
     */
    private TriviaQuestions() {

    }

    /**
     * String for querying the questions.
     */
    private final static String QUESTION = "Question";

    /**
     * String for querying the answers to the questions.
     */
    private final static String ANSWER = "Answer";
    
    /**
     * Creates an ArrayList of questions from the database of trivia questions.
     * @return An ArrayList of questions from the database of trivia questions.
     */
    public static List<Question> getTriviaQuestions() {
        Connection connection = null;
        final List<Question> questions = new ArrayList<Question>();
        try {
            // Create a database connection.
            // We are using jdbc for the Java database connection and SQLite ("jdbc:sqlite").
            // Then we are using the actual .db physical file that we want to connect to ("jdbc:sqlite:db_name.db").
            final String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/src/model/question/database/TriviaQuestions.db";
            connection = DriverManager.getConnection(url);
            final Statement statement = connection.createStatement();
            // Sets the timeout to 30 seconds (if the query takes too long - good practice).
            statement.setQueryTimeout(30);

            final ResultSet mc = statement.executeQuery("SELECT * FROM MultipleChoice");
            while (mc.next()) {
                final Option answer = new Option(mc.getString(ANSWER), true);
                final Option optionB = new Option(mc.getString("OptionB"), false);
                final Option optionC = new Option(mc.getString("OptionC"), false);
                final Option optionD = new Option(mc.getString("OptionD"), false);
                final Question q = new MultipleChoiceQuestion(mc.getString(QUESTION), answer, optionB, optionC, optionD);
                questions.add(q);
            }

            final ResultSet tf = statement.executeQuery("SELECT * FROM TrueFalse");
            while (tf.next()) {
                final Option answer = new Option(mc.getString(ANSWER), true);
                final Option incorrect = new Option(mc.getString("Incorrect"), false);
                final Question q = new TrueFalseQuestion(tf.getString(QUESTION), answer, incorrect);
                questions.add(q);
            }

            final ResultSet fr = statement.executeQuery("SELECT * FROM FreeResponse");
            while (tf.next()) {
                final Question q = new FreeResponseQuestion(fr.getString(QUESTION), fr.getString(ANSWER));
                questions.add(q);
            }
        }
        catch (final SQLException e) {
            System.out.println("The database file was not found!");
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (final SQLException e) {
                System.out.println("Could not close the connection!");
            }
        }
        return questions;
    }
}