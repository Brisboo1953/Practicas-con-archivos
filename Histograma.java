import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Histograma {
    public static void main(String[] args) {
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader("src/divina_comedia_sp.txt"))) {
            HashMap<Integer, Integer> his = new HashMap<>();
            String leer;
            while ((leer = bufferedreader.readLine()) != null) {
                String[] espacio = leer.split("\\s+");
                for (String letra : espacio) {
                    letra = letra.replaceAll("[^a-zA-Z]", "");
                    int longitud = letra.length();
                    if (longitud >= 1 && longitud <= 10) {
                        his.put(longitud, his.getOrDefault(longitud, 0) + 1);
                    }
                }
            }
            for (int longitud : his.keySet()) {
                int frec = his.get(longitud);
                System.out.println("Longitud de la palabra: " + longitud + " Frecuencia de letra: " + frec);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}

