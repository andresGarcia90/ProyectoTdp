package Pelicula;

public class Pelicula {

    String nombre, review, puntaje, genero, trailer;
    boolean publica;
    int nro;

    public Pelicula() {
        nombre = "";
        review = "";
        genero = "";
        trailer = "";
        nro = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String r) {
        review = r;
    }

    public int getNumero() {
        return nro;
    }

    public void setNumero(int n) {
        nro = n;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String p) {
        puntaje = p;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String g) {
        genero = g;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String t) {
        trailer = t;
    }
}