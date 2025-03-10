package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static Connexion instance = null;
    private Connection cn = null;

    private final String url = "jdbc:mysql://localhost:9090/jdbc";
    private final String login = "root";  
    private final String password = "";  

    private Connexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion réussie !");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur de connexion : " + ex.getMessage());
        }
    }

    public static synchronized Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }

    public Connection getCn() {
        return cn;
    }
}
