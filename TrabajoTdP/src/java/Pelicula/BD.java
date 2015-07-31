package Pelicula;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fede
 */
public class BD {

    File F;
    BufferedReader lector;
    BufferedWriter escritor;

    public BD() {
        F = new File(this.getClass().getResource("BD.class").getFile());
        String J = F.getAbsolutePath();
        J = J.replace("BD.class", "Peliculas.txt");
        J = J.replace("%20", " ");
        F = new File(J);

        if (!F.exists()) {
            try {
                F.createNewFile();
                F = new File(J);
            } catch (IOException ex) {
                Logger.getLogger(BD.class.getName()).log(Level.SEVERE, "Error constructor", ex);
            }
        }
        try {
            escritor = new BufferedWriter(new FileWriter(J, true));
            lector = new BufferedReader(new FileReader(J));
        } catch (IOException ex) {
            System.out.println("error constructor " + ex.toString());
        }
    }

    public int getCantidad() {
        return (int) (F.length() / 6);
    }

    public String leerLinea() {
        String L = null;
        try {
            L = lector.readLine();
        } catch (IOException ex) {
            System.out.println("error al leer Linea " + ex.toString());
        }

        return L;
    }

    public void escribir(String L) {
        try {
            escritor.append(L);
        } catch (IOException ex) {
            System.out.println("error al escribir al final " + ex.toString());
        }
    }

    public void cerrarBuffers() {
        try {
            escritor.close();
            lector.close();
        } catch (IOException ex) {
            System.out.println("error al cerrar " + ex.toString());
        }
    }

    public void vaciar() {
        F = new File(this.getClass().getResource("Peliculas.txt").getFile());
        String J = F.getAbsolutePath();
        J = J.replace("%20", " ");
        try {
            escritor = new BufferedWriter(new FileWriter(J, false));
        } catch (IOException ex) {
            System.out.println("error al vaciar" + ex.toString());
        }
    }
}
