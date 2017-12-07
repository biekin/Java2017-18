package databases;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    public void connect(){
        try {
            // load a properties file
            InputStream config = new FileInputStream("./src/databases/db.config");
            Properties prop = new Properties();
            prop.load(config);

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection(prop.getProperty("dbhost"),
                            prop.getProperty("dbuser"), prop.getProperty("dbpass"));

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}
    }

    public void listNames(){
        try {
            connect();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM books");

            while(rs.next()){
                String isbn = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String year = rs.getString(4);
                System.out.println("isbn:: "+ isbn + "," + "title: "+ title + ","+ "author: "+ author + "," + "year: "+year);
            }
        }catch (SQLException ex){
            // handle any errors

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }

    public static void main(String[] args) {
        DB test = new DB();
        test.listNames();

    }
}
