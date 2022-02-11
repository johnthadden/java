//randomly selects 4 cards from specific directory housing the 52 playing card .png files

import java.util.Random;
import java.io. * ;
import java.awt.Desktop;

public class Main {
    public static void main(String args[]){
        Random random = new Random();
        int i = 1;

        while (i < 5){
            try {
                    int random1 = random.nextInt(52);
                    File file = new File("/Users/johnhadden/Desktop/csd/AssignmentCards/" + random1 + ".png");
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(file);
                    i++;
                }
            catch(IOException e) {
                System.out.println("Oopsie...");
            }
        }
    }   
}
