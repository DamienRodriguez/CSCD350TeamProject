package Database;

import java.sql.*;
import java.util.ArrayList;


/* DatabaseConnection.java
 * Author: Damien Rodriguez
 * Revision: 4
 * Rev. Author: Damien Rodriguez
 * Description: Database connection class. Singleton pattern implemented.
 * Has functionality to execute SQL queries within the SQLite database
 */
public class DatabaseConnection {

    private static DatabaseConnection SINGLE_INSTANCE = null;
    private final String DB_CONNECTION = "jdbc:sqlite:trivia.db";
    private final String MULTIPLECHOICE_COUNT_QUERY = "SELECT COUNT(*) AS rowCount FROM questions WHERE wrongAnswerOne IS NOT NULL";
    private final String TRUEFALSE_COUNT_QUERY = "SELECT COUNT(*) AS rowCount FROM questions WHERE length(answer) == 1 AND wrongAnswerOne IS NULL";
    private final String SHORTANSWER_COUNT_QUERY = "SELECT COUNT(*) AS rowCount FROM questions WHERE length(answer) != 1 AND wrongAnswerOne IS NULL";
    private final String TOTAL_COUNT_QUERY = "SELECT COUNT(*) AS rowCount FROM questions";
    private Connection c;

    private int trueFalseRecordCount;
    private int multipleChoiceRecordCount;
    private int shortAnswerChoiceRecordCount;
    private int totalRecordCount;



    ///Returns: nothing, it sets up the connection to our global Connection variable
    ///Throws:
    ///ClassNotFoundException: Throws the exception when the driver .jar file isn't present
    ///SQLException: Throws exception when SQL database connection fails
    private DatabaseConnection() throws Exception {
        connectionSetUp();
        setMultipleChoiceRecordCount(getRecordCount(MULTIPLECHOICE_COUNT_QUERY));
        setTrueFalseRecordCount(getRecordCount(TRUEFALSE_COUNT_QUERY));
        setShortAnswerChoiceRecordCount(getRecordCount(SHORTANSWER_COUNT_QUERY));
        setTotalRecordCount(getRecordCount(TOTAL_COUNT_QUERY));

        if(this.totalRecordCount != (this.multipleChoiceRecordCount + this.trueFalseRecordCount + this.shortAnswerChoiceRecordCount))
            throw new SQLException("SQL statements aren't getting the seperate categories that you are expecting.");

    }


    private int getRecordCount(final String sql)  {

        int count = 0;
        try {
            Statement statement = this.c.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            count = rs.getInt("rowCount");
            rs.close();

        } catch(Exception e) {
            System.out.println("ERROR in getRecordCount");
        }

        return count;
    }


    public static DatabaseConnection getInstance() {
        try {
            if(SINGLE_INSTANCE == null) {
                synchronized (DatabaseConnection.class) {
                    if(SINGLE_INSTANCE == null)
                        SINGLE_INSTANCE = new DatabaseConnection();
                }
            }
            return SINGLE_INSTANCE;
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;

    }


    private void connectionSetUp() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.c = DriverManager.getConnection(DB_CONNECTION);

        } catch (Exception e) {
            System.out.println("Problem in connectionSetUp");
            System.out.println(e);
        }
    }


    public void addQuestion(final Question q) {
        String sql = "insert into questions values(";


        if(q.getWrongAnswerOne() != null) {
            sql = sql + "'"+ q.getId() + "', '" + q.getQuestion() + "', '" + q.getAnswer() + "', '" + q.getWrongAnswerOne() + "', '" + q.getWrongAnswerTwo() + "', '" + q.getWrongAnswerThree() + "', '" + q.getHint() + "')";
        }

        else {
            sql = sql + "'"+ q.getId() + "', '" + q.getQuestion() + "', '" + q.getAnswer() + "', '" + null + "', '" + null + "', '" + null + "', '" + q.getHint() + "')";
        }

        insertQuery(sql);
    }


    public void updateRecordCount(final char token) {
        if(token == 't')
            this.trueFalseRecordCount++;
        else if(token == 'm')
            this.multipleChoiceRecordCount++;
        else if(token == 's')
            this.shortAnswerChoiceRecordCount++;
        else
            throw new IllegalArgumentException("token sent to update the record count is invalid.");

        this.totalRecordCount++; //there might be a problem here if we get the invalid token exception.
    }


    private void insertQuery(final String query) {
        try {
            Statement myStm = this.c.createStatement();
            myStm.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("ERROR HAPPENED AT insertQuery");
            System.out.println(e);
        }

    }


    public ArrayList<Question> searchQuery(final String query) {

        try {
            ArrayList<Question> arrayList = new ArrayList<Question>();
            Statement temp_statement = this.c.createStatement();
            ResultSet rs = temp_statement.executeQuery(query);

            int row = rs.getRow();
            while(row < 1) {

                Question temp = new Question(rs);
                arrayList.add(temp);
                rs.next();
                row = rs.getRow();
            }

            arrayList.trimToSize();
            return arrayList;
        } catch(Exception e) {
            System.out.println("ERROR HAPPENED in searchQuery");
        }

        return null;
    }


    //to be deleted later
    public void clearQuestionData() {
        try {
            Statement temp = this.c.createStatement();
            temp.execute("DELETE FROM questions");

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void closeConnection() {
        try {
            this.c.close();
        } catch(Exception e) {
            System.out.println("ERROR HAPPENED in closeConnection");
            System.out.println(e);
        }

    }


    public int getTrueFalseRecordCount() {
        return trueFalseRecordCount;
    }


    public void setTrueFalseRecordCount(int trueFalseRecordCount) {
        this.trueFalseRecordCount = trueFalseRecordCount;
    }


    public int getMultipleChoiceRecordCount() {
        return multipleChoiceRecordCount;
    }


    public void setMultipleChoiceRecordCount(int multipleChoiceRecordCount) {
        this.multipleChoiceRecordCount = multipleChoiceRecordCount;
    }


    public int getShortAnswerChoiceRecordCount() {
        return shortAnswerChoiceRecordCount;
    }


    public void setShortAnswerChoiceRecordCount(int shortAnswerChoiceRecordCount) {
        this.shortAnswerChoiceRecordCount = shortAnswerChoiceRecordCount;
    }


    public int getTotalRecordCount() {
        return totalRecordCount;
    }


    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }


    //Bug where there appears to be n + 1 rows
    //when checking if a particular ID exists on
    //the database.
    //Could be time to create Hashtables for lookups.
    public boolean exists(final String questionID) {

        try {
            Statement myStm = this.c.createStatement();

            String sql = "SELECT * FROM questions WHERE questionID = ";
            String addedQuotes = "\'" + questionID + "\'";
            sql = sql + addedQuotes;



            ResultSet rs = myStm.executeQuery(sql);
            //need to do some check with the result set here

            return true;

        }
        catch(Exception e) {
            System.out.println("question does not exist.");
            return false;
        }


    }


}
