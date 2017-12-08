package databases;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

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

    public void Add(String isbn, String title, String author, String year){
        try {
            connect();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli user
            String a = "INSERT INTO books VALUES ('"+isbn+"','"+title+"', '"+author+"',"+year+")";
            //String a = "INSERT INTO books VALUES ('1111111111111','Nowy wspanialy swiat', 'Aldous Huxley',2008)";
            stmt.executeUpdate(a);

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


    public void FindByName(String surname){
        try {
            connect();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli user
            String a = "SELECT * FROM books WHERE author LIKE '%"+surname+"'";
            rs = stmt.executeQuery(a);

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

    public void listAll(){
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
       // test.listAll();

        int whattado=0;

        while (!(whattado==4)){

            System.out.println("what to do");
            Scanner sc = new Scanner(System.in);
            whattado=sc.nextInt();

            if (whattado==1){

                sc.nextLine();
                String surname = sc.nextLine();
                test.FindByName(surname);
            }
            else if (whattado==2){
                test.Add("1111111111112", "testtesttest", "test testejowski", "2017" );

            }
        }

    }
}
