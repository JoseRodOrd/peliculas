
package com.horisoes.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NEOTIC
 */
public class Dao {
    private Connection cn;

   

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public void ConectarBd() throws ClassNotFoundException{
    try{
        final String Controlador="com.mysql.jdbc.Driver";
        Class.forName(Controlador);
        final String url_bd="jdbc:mysql://localhost:3306/peliculas";
        cn= (Connection) DriverManager.getConnection(url_bd,"root","root");
    }catch(ClassNotFoundException | SQLException e){
        e.printStackTrace();
    }
    }
    
         public void desConectarBD(){
    try{
        if(cn!=null){
            if(cn!=null){
                cn.close();
            }
            cn.close();
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    
}
