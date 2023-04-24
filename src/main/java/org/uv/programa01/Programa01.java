/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package org.uv.programa01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo Mencías
 */
public class Programa01 {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:8000/ejemplo";
        String pws = "postgres";
        String user = "postgres";
        Connection con = null;
        Statement st=null;
        try {
            String sql="INSERT INTO usuarios (id, nombre, direccion, telefono) VALUES"
                    + "('01', 'Rodrigo', 'av. orizaba', '123 ')";
            con = DriverManager.getConnection(url, user, pws);
            Logger.getLogger(Programa01.class.getName()).log(Level.INFO, "se conecto");
            st=con.createStatement();
            st.execute(sql);
            Logger.getLogger(Programa01.class.getName()).log(Level.INFO, "se guardo");
            
        } catch (SQLException ex) {
            Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
