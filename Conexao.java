import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/escola";
            String usuario = "root";
            String senha = "123456";

            return DriverManager.getConnection(url, usuario, senha);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
