import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class AlojadosHotel {
    public static void main(String[] args) {
        escribirAlojados("alojados.txt", extraerAlojados("jugadores.txt"));
    }

    public static ArrayList<String> extraerAlojados(String fileName) {
        ArrayList<String> lineas = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader entrada = new BufferedReader(fr);
            String linea;

            while ((linea = entrada.readLine()) != null) {
                String[] palabrasLinea = linea.split(";");

                if (palabrasLinea.length >= 8 && palabrasLinea[7].contains("H")) {
                    String ranking = palabrasLinea[0];
                    String nombre = palabrasLinea[2];
                    lineas.add(ranking + ", " + nombre);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lineas;
    }

    public static void escribirAlojados(String fileName, ArrayList<String> lineas) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {

            bufferedWriter.write("Ranking; Nombre");
            bufferedWriter.newLine();

            for (String linea : lineas) {
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Se han añadido los nuevos alojados con éxito.");
    }
}
