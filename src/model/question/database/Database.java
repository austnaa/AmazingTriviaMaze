/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */

package model.question.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Database for the trivia questions.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public class Database {
    
    // Use for testing and understanding of databases.

    // public static void main(final String[] theArgs) {
    //     Connection connection = null;

    //     try {
    //         // Create a database connection.
    //         // We are using jdbc for the Java database connection and SQLite ("jdbc:sqlite").
    //         // Then we are using the actual .db physical file that we want to connect to ("jdbc:sqlite:db_name.db").
    //         // If the database file has not been created yet, it will be created.
    //         connection = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "/src/model/question/database/questions.db");
    //         final Statement statement = connection.createStatement();
    //         // Sets the timeout to 30 seconds (if the query takes too long - good practice).
    //         statement.setQueryTimeout(30);

    //         final Statement statement2 = connection.createStatement();
    //         statement2.setQueryTimeout(30);

    //         statement.executeUpdate("DROP TABLE if EXISTS freeresponse");
    //         statement.executeUpdate("CREATE TABLE freeresponse (question String, answer String)");
    //         statement.executeUpdate("INSERT INTO freeresponse VALUES('What is 2 + 2?', '4')");
    //         statement.executeUpdate("INSERT INTO freeresponse VALUES('What is 10 * 4?', '40')");

    //         // executeUpdate modifies the table contents.
    //         // We drop the table if it already exists before so we can create a new table (defensive programming).
    //         statement.executeUpdate("DROP TABLE if EXISTS questions");
    //         statement.executeUpdate("CREATE TABLE questions (question String, answer String)");
    //         statement.executeUpdate("INSERT INTO questions VALUES('How are you?', 'Good!')");
    //         statement.executeUpdate("INSERT INTO questions VALUES('Are you really good?', 'Ye bro')");

    //         final ResultSet rs = statement.executeQuery("SELECT * FROM questions");
    //         while (rs.next()) {
    //             // Read out from the result set.
    //             System.out.println("Question: " + rs.getString("question"));
    //             System.out.println("Answer: " + rs.getString("answer"));
    //         }
    //         rs.close();
    //     }
    //     catch (final SQLException e) {
    //         // If the error message is "out of memory" it probably means no database file was found
    //         System.out.println("Database file was not found!");
    //     }
    //     finally {
    //         try {
    //             if (connection != null) {
    //                 connection.close();
    //             }
    //         }
    //         catch (final SQLException e) {
    //             // Connection closed failed.
    //             System.out.println("Connection closed failed!");
    //         }
    //     }
    // }
}