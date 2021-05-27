import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        ArrayList<String[]> database = new ArrayList<String[]>();
        Scanner sc = new Scanner(System.in);
        int primera_opcio = 0;

        while (primera_opcio != -1) {

            System.out.println();
            System.out.println("--------------------------------------------------------------");
            System.out.println("Benvingut al Supermarket!");
            Date data = new Date();
            System.out.println(data+" Grau Sebastian_Ortega Farrerons");
            System.out.println("--------------------------------------------------------------");

            System.out.println("Menú pricipal: ");
            System.out.println("\t[1]\t Mòdul d’estoc");
            System.out.println("\t[2]\t Mòdul venda");
            System.out.println("\t[-1] Sortir\n");

            System.out.print("Opció: ");
            primera_opcio = sc.nextInt();

            switch (primera_opcio) {
                case 1: modul_estoc.modul_estoc(database); break;
                case 2: modul_venta.modul_venda(database); break;
                case -1: primera_opcio = -1; break;
            }
        }
    }
}
