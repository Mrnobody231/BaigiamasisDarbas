import java.sql.*;

public class DbConnection {

        public static void main(String[] args) {
            String url = "jdbc:postgresql://localhost:5432/MokiVeziData";
            String user = "postgres";
            String password = "123456";

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String mokiVeziTable = "CREATE TABLE mokiVezi " +
                        "(id SERIAL PRIMARY KEY, " +
                        "Vardas VARCHAR(250), " +
                        "Pavarde VARCHAR(250)," +
                        "TelefonoNr INT, " +
                        "Slaptazodis VARCHAR(250) ," +
                        "VisiPasiulumai VARCHAR(250))";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(mokiVeziTable);
                    System.out.println("Table created successfully");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public  static PreparedStatement databaseConn (String sql){
            String url = "jdbc:postgresql://localhost/MokiVeziData";
            String user = "postgres";
            String password = "123456";


            try{
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                return pstmt;
            } catch(SQLException e) {
                System.err.println(e.getMessage());
                return null;
            }
        }
    }

