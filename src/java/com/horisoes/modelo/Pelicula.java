package com.horisoes.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author NEOTIC
 */
public class Pelicula implements Serializable {

    private int id_pel;
    private String titulo;
    private String genero;
    private String sinopsis;
    private String tipo;
    private int calificacion;
    private String imagen;
    private Date estreno;

    public int getId_pel() {
        return id_pel;
    }

    public void setId_pel(int id_pel) {
        this.id_pel = id_pel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getImagen() {

        if (imagen != null) {
            return imagen.trim();
        }
        else{
               return "";
        }
    }

    public void setImagen(String imagen) {
        this.imagen = imagen.trim();
    }

    public Date getEstreno() {
        return estreno;
    }

    public void setEstreno(Date estreno) {
        this.estreno = estreno;
    }

}
