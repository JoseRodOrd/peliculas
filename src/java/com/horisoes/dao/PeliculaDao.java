package com.horisoes.dao;

import com.horisoes.modelo.Pelicula;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NEOTIC
 */
public class PeliculaDao extends Dao {

//------------------------------------------------------------------------------
//-- METODO DE ACCESO PARA GUARDAR  PELICULAS   
//------------------------------------------------------------------------------
    public void crearPeliculaDao(Pelicula pel) throws SQLException {

        try {
            this.ConectarBd();

            PreparedStatement st = (PreparedStatement) this.getCn().prepareStatement("INSERT INTO Pelicula (titulo, genero,sinopsis,tipo,calificacion,imagen,estreno) values (?,?,?,?,?,?,?)");

            st.setString(1, pel.getTitulo());
            st.setString(2, pel.getGenero());
            st.setString(3, pel.getSinopsis());
            st.setString(4, pel.getTipo());
            st.setInt(5, pel.getCalificacion());
            st.setString(6, pel.getImagen());
            st.setDate(7, new java.sql.Date(pel.getEstreno().getTime()));
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desConectarBD();
        }

    }

//------------------------------------------------------------------------------
//-- METODO DE ACCESO A DATOS PARA LISTAR LAS PELICULAS   
//------------------------------------------------------------------------------
    public List<Pelicula> listarPeliculas(boolean upComing, boolean topRatep) throws Exception {

        List<Pelicula> listPelicula;
        ResultSet rs;
        try {
            PreparedStatement st ;
            this.ConectarBd();
            if(upComing)
            {
                 st = (PreparedStatement) this.getCn().prepareStatement("SELECT id_pel,titulo, genero,sinopsis,tipo,calificacion,imagen,estreno FROM pelicula order by estreno DESC");
            }
            else if (topRatep)
            {
                st = (PreparedStatement) this.getCn().prepareStatement("SELECT id_pel,titulo, genero,sinopsis,tipo,calificacion,imagen,estreno FROM pelicula order by calificacion DESC");
            }
            else
            {
                st = (PreparedStatement) this.getCn().prepareStatement("SELECT id_pel,titulo, genero,sinopsis,tipo,calificacion,imagen,estreno FROM pelicula");
            }
           
            rs = st.executeQuery();
            listPelicula = new ArrayList<>();
            while (rs.next()) {
                Pelicula pel = new Pelicula();
                pel.setId_pel(rs.getInt("id_pel"));
                pel.setTitulo(rs.getString("titulo"));
                pel.setGenero(rs.getString("genero"));
                pel.setSinopsis(rs.getString("sinopsis"));
                pel.setTipo(rs.getString("tipo"));
                pel.setCalificacion(rs.getInt("calificacion"));
                pel.setImagen(rs.getString("imagen"));
                pel.setEstreno(rs.getDate("estreno"));

                listPelicula.add(pel);

            }

        } catch (Exception e) {
            throw e;
        } finally {
            desConectarBD();
        }
        return listPelicula;
    }

//------------------------------------------------------------------------------
//-- METODO DE ACCESO A DATOS PARA LEER LAS PELICULAS  POR ID
//------------------------------------------------------------------------------
    public Pelicula leerIdPelicula(Pelicula peli) throws Exception {

        Pelicula pel = null ;
        ResultSet rs;
        try {
            this.ConectarBd();
            PreparedStatement st = (PreparedStatement) this.getCn().prepareStatement("SELECT id_pel,titulo, genero,sinopsis,tipo,calificacion,imagen,estreno FROM pelicula where id_pel=?");
            st.setInt(1, peli.getId_pel());
            rs = st.executeQuery();

            while (rs.next()) {
                pel = new Pelicula();
                pel.setId_pel(rs.getInt("id_pel"));
                pel.setTitulo(rs.getString("titulo"));
                pel.setGenero(rs.getString("genero"));
                pel.setSinopsis(rs.getString("sinopsis"));
                pel.setTipo(rs.getString("tipo"));
                pel.setCalificacion(rs.getInt("calificacion"));
                pel.setImagen(rs.getString("imagen"));
                pel.setEstreno(rs.getDate("estreno"));

               
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desConectarBD();
        }
        return pel;
    }
    
    
    
    //------------------------------------------------------------------------------
//-- METODO DE ACCESO PARA ELIMINAR UNA  PELICULA   
//------------------------------------------------------------------------------
    public void eliminarPeliculaDao(Pelicula pel) throws SQLException {

        try {
            this.ConectarBd();

            PreparedStatement st = (PreparedStatement) this.getCn().prepareStatement("Delete from pelicula where id_pel = "+pel.getId_pel());
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desConectarBD();
        }

    }
    

//------------------------------------------------------------------------------
//-- METODO DE ACCESO PARA EDITAR  PELICULAS   
//------------------------------------------------------------------------------
    public void editarPeliculaDao(Pelicula pel) throws SQLException {

        try {
            this.ConectarBd();

            PreparedStatement st = (PreparedStatement) this.getCn().prepareStatement("UPDATE  Pelicula SET titulo = ?, genero  = ?,sinopsis  = ?,tipo  = ?,calificacion  = ?,imagen  = ?,estreno  = ? WHERE id_pel=?  ");
            st.setString(1, pel.getTitulo());
            st.setString(2, pel.getGenero());
            st.setString(3, pel.getSinopsis());
            st.setString(4, pel.getTipo());
            st.setInt(5, pel.getCalificacion());
            st.setString(6, pel.getImagen());
            st.setDate(7, new java.sql.Date(pel.getEstreno().getTime()));
            st.setInt(8, pel.getId_pel());
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desConectarBD();
        }

    }


}
