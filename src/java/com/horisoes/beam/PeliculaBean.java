
package com.horisoes.beam;

import com.horisoes.dao.PeliculaDao;
import com.horisoes.modelo.Pelicula;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("peliculaBean")
@ViewScoped
public class PeliculaBean implements Serializable{
    
    private Pelicula pelicula;
    List<Pelicula> listPeliculas;
    private Pelicula peliculaSeleccionada;
    private boolean topRated = false;
    private boolean upcoming = false;
    
    @PostConstruct
    public void init() {
        try {
            listarPeliculas();
        } catch (Exception ex) {
            Logger.getLogger(PeliculaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isTopRated() {
        return topRated;
    }

    public void setTopRated(boolean topRated) {
        this.topRated = topRated;
    }

    public boolean isUpcoming() {
        return upcoming;
    }

    public void setUpcoming(boolean upcoming) {
        this.upcoming = upcoming;
    }

    public void setPeliculaSeleccionada(Pelicula peliculaSeleccionada) {
        this.peliculaSeleccionada = peliculaSeleccionada;
    }

    public Pelicula getPeliculaSeleccionada() {
        return peliculaSeleccionada;
    }
    
    

    public Pelicula getPelicula() {
        return pelicula;
    }

    public List<Pelicula> getListPeliculas() {
        return listPeliculas;
    }

    public void setListPeliculas(List<Pelicula> listPeliculas) {
        this.listPeliculas = listPeliculas;
    }
    
//------------------------------------------------------------------------------
//-- METODO DE ACCESO A DAO PARA GUARDAR  PELICULAS   
//------------------------------------------------------------------------------

   
    
    public void crearPelicula() throws Exception{
        PeliculaDao dao;       
        try {
            dao=new PeliculaDao();
           dao.crearPeliculaDao(pelicula);
           listPeliculas= dao.listarPeliculas(upcoming,topRated);
        } catch (Exception e) {
            throw e;
        }
    
    }

//------------------------------------------------------------------------------
//-- METODO DE ACCESO  A DAO PARA LISTAR LAS PELICULAS   
//------------------------------------------------------------------------------
    
        public void listarPeliculas() throws Exception{
        PeliculaDao dao;       
        try {
            dao=new PeliculaDao();
           listPeliculas= dao.listarPeliculas(upcoming,topRated);
        } catch (Exception e) {
            throw e;
        }
    
    }
        
        
     public void seleccionarPelicula(Pelicula pel)
     {
         peliculaSeleccionada = pel;
     }
     
     public void openCrearPelicula()
     {
         pelicula = new Pelicula();}
     
     public void eliminarPelicula(Pelicula pel)throws Exception
     {
        PeliculaDao dao;       
        try {
            dao = new PeliculaDao(); 
           dao.eliminarPeliculaDao(pel);
           listPeliculas= dao.listarPeliculas(upcoming,topRated);
        } catch (Exception e) {
            throw e;
        } 
     }
     
     public void leerEdirarPelicula(Pelicula pel)throws Exception
     {
        PeliculaDao dao;   
        Pelicula temPel;
        try {
            dao = new PeliculaDao(); 
           temPel=dao.leerIdPelicula(pel);
           
           if(temPel!=null){
               this.pelicula=temPel;
           }
       //    listPeliculas= dao.listarPeliculas(upcoming,topRated);
        } catch (Exception e) {
            throw e;
        } 
     }
     
     public void editarPelicula()throws Exception
     {
        PeliculaDao dao;       
        try {
            dao = new PeliculaDao(); 
           dao.editarPeliculaDao(pelicula);
          listPeliculas= dao.listarPeliculas(upcoming,topRated);
        } catch (Exception e) {
            throw e;
        } 
     }
     
     public void topRated()throws Exception
     {
        upcoming = false;
        topRated = true;
        PeliculaDao dao;       
        try {
            dao = new PeliculaDao(); 
           listPeliculas= dao.listarPeliculas(upcoming,topRated);
        } catch (Exception e) {
            throw e;
        } 
     }
     
     public void upcoming()throws Exception
     {
        upcoming = true;
        topRated = false;
        PeliculaDao dao;       
        try {
            dao = new PeliculaDao(); 
           listPeliculas= dao.listarPeliculas(upcoming,topRated);
        } catch (Exception e) {
            throw e;
        } 
     }
     

}
