package test;

import connexion.Connexion;
import java.sql.Connection;

public class TestConnexion {
    public static void main(String[] args) {
        Connection cn = Connexion.getInstance().getCn();
        if (cn != null) {
            System.out.println("Connexion réussie !");
        } else {
            System.out.println("Erreur de connexion !");
        }
    }
}
