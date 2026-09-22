package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Mod_conexao {

    public static Connection conector() {

        Connection conexao = null;

        String url = "jdbc:mysql://localhost:3306/usuarios";
        String user = "root";
        String password = "";

        try {

            conexao = DriverManager.getConnection(url, user, password);

            return conexao;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "Erro na conexão: " + erro.getMessage());

            return null;
        }
    }
}