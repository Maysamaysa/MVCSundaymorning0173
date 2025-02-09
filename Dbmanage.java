import java.io.*;
import java.util.*;
//to load , update database
public class Dbmanage {
    public static List<suit> loadSuits() {
        ArrayList<suit> suits = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Super.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int j = Integer.parseInt(data[2]);
                suits.add(new suit(data[0], data[1], j));
            }
        } catch (IOException e) {
            System.out.println("Error loading: " + e.getMessage());
        }
        return suits;
    }

    public static void saveSuits(List<suit> suits) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Super.csv"))) {
            for (suit suit1 : suits) {
                bw.write(suit1.getId() + "," + suit1.getType() + "," + suit1.getDurability() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }
}
