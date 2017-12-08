package workers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class db {
        private Connection conn = null;
        private Statement stmt = null;
        private ResultSet rs = null;
        public void connect(){
            try {
                // load a properties file
                InputStream config = new FileInputStream("./src/databases/db.config");
                Properties prop = new Properties();
                prop.load(config);

                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
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

        public void findWorker(Worker worker){
            try {
                connect();
                stmt = conn.createStatement();

                // Wyciagamy wszystkie pola z kolumny name
                // znajdujące się w tabeli users
                rs = stmt.executeQuery("SELECT * from workers WHERE  pesel = " + worker.getPesel());

                double brutto = rs.getDouble(2);
                worker.setWynagrodzniaBrutto(brutto);
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
        public void deleteWorker(String pesel) {
            try {
                connect();
                stmt = conn.createStatement();

                stmt.execute("DELETE * from workers WHERE  pesel = " + pesel);

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

    public void insertWorker(String pesel, double brutto) {
        try {
            connect();
            stmt = conn.createStatement();

            stmt.executeUpdate(
                    "INSERT INTO workers (pesel, brutto) "
                            + "values ("
                            + pesel + ","
                            + brutto
                            + ") ");

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

    public void createWorkersTable(){
        try {
            connect();
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "CREATE TABLE workers ("
                            + "pesel VARCHAR(11) NOT NULL"
                            + "brutto DOUBLE, PRIMARY KEY (pesel))");
        } catch (SQLException ex){

        } finally {
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

    public void dropWorkersTable(){
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE workers");
        } catch (SQLException ex){

        } finally {
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

}
