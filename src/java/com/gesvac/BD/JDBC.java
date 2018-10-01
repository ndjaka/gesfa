/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gesvac.BD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lesli
 */
public class JDBC {
    
    //URL de connexion
    private static String url = "jdbc:postgresql://localhost:5432/gesfa_db";
    
    //nom de l'utilisateur
    private static String user = "postgres";
    
    //mot de passe de l'utilisateur
    private static String password = "ndjaka";
    
    private static String driver = "org.postgresql.Driver";
    
    //Objet de connexion
    private static Connection con;

    
    
    
    /*méthode qui va renvoyer une instance de la connexion a la base de donné 
    si et seulement si c'est la première connection utilisation du pattern singletton */
     synchronized public static Connection getInstance() {
        if(con==null){
            try {
                //chargement du driver !!! très important
                Class.forName(driver);
                con = (Connection) DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return con;
    } 
    public static void verifier(){
        if (getInstance() != null){
            System.out.println("true");
        }
    }
    
   
}
