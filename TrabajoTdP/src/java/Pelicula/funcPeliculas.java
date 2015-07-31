package Pelicula;

public class funcPeliculas {

    public static boolean agregarPelicula(Pelicula T) {
        boolean toR = false;
        BD D = null;
        try {
            D = new BD();
            D.escribir("" + "\r\n");
            D.escribir(T.getNombre() + "\r\n");
            D.escribir(T.getGenero() + "\r\n");
            D.escribir(T.getPuntaje() + "\r\n");
            D.escribir(T.getReview() + "\r\n");
            D.escribir(T.getTrailer() + "\r\n");
            D.cerrarBuffers();
            toR = true;
        } catch (Exception e) {
            D.cerrarBuffers();
        }

        return toR;
    }

    public Pelicula[] getPeliculas() {
        BD D = new BD();
        Pelicula[] T = new Pelicula[D.getCantidad() + 1];

        String L;
        int I = 0;
        D.leerLinea();

        while ((L = D.leerLinea()) != null) {
            T[I] = new Pelicula();

            T[I].setNombre(L);

            L = D.leerLinea();
            T[I].setGenero(L);

            L = D.leerLinea();
            T[I].setPuntaje(L);

            L = D.leerLinea();
            T[I].setReview(L);

            L = D.leerLinea();
            T[I].setTrailer(L);

            T[I].setNumero(I);
            D.leerLinea();
            I++;
        }

        D.cerrarBuffers();

        return T;
    }

    public static void setPeliculas(Pelicula[] T) {
        BD D = new BD();
        D.vaciar();
        D.cerrarBuffers();
        for (int I = 0; I < T.length; I++) {
            if (T[I] != null) {
                agregarPelicula(T[I]);
            }
        }
    }

}
