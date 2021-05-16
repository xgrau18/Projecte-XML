import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {

    static void modul_estoc(ArrayList<String[]> database) {

        Scanner sc = new Scanner(System.in);
        int opcio = 0;

        System.out.println();
        System.out.println("--------------------------------------------------------------");

        System.out.println("Mòdul d'stock: ");
        System.out.println("\t[1]\t Afegir producte");
        System.out.println("\t[2]\t Eliminar producte");
        System.out.println("\t[3]\t Llistar productes");
        System.out.println("\t[-1] Tornar al menú principal\n");

        System.out.print("Opció: \t ");
        opcio = sc.nextInt();

        switch (opcio) {
            case 1: afegir_producte(database); break;
            case 2: eliminar_producte(database); break;
            case 3: llistar_producte(database); break;
            case -1: break;
        }

    }

    static ArrayList<String[]>  afegir_producte( ArrayList<String[]> database ) {

        String codi_barres, nom, seccio, preu;
        int opcio;
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Codi de barres: ");
        codi_barres = sc.nextLine();

        System.out.print("Nom: ");
        nom = sc.nextLine();

        System.out.print("Secció: ");
        seccio = sc.nextLine();

        System.out.print("Preu: ");
        preu = sc.nextLine();

        String[] register = new String[]{codi_barres, nom, seccio, preu};
        database.add(database.size(), register);

        System.out.println();
        System.out.println("--------------------------------------------------------------");

        System.out.println("Producte afegit correctament! Vols afegir un altre? ");

        System.out.println("\t[1] Si");
        System.out.println("\t[2] No\n");

        System.out.print("Opció: \t ");
        opcio = sc.nextInt();

        switch (opcio) {
            case 1: afegir_producte(database); break;
            case 2: break;
        }

        return database;

    }

    static ArrayList<String[]> eliminar_producte(ArrayList<String[]> database) {

        Scanner sc = new Scanner(System.in);
        String id = "0";

        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println();

        for (int i = 0; i < database.size(); i++) {
            String[] array = database.get(i);
            System.out.println((i + 1) + ". Codi: " + array[0] +
                    "\t Nom: " + array[1] +
                    "\t Secció: " + array[2] +
                    "\t Preu: " + array[3] + "€" );
        }

        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println();

        System.out.print("Codi del producte a eliminar: ");
        id = sc.nextLine();
        for (int i = 0; i < database.size(); i++) {
            String[] arr = database.get(i);
            if (arr[0].equals(id)) {
                database.remove(i);
                return database;
            }
        }

        System.out.println("No existeix el producte amb codi de barres " + id);
        return database;
    }

    static void llistar_producte(ArrayList<String[]> database) {

        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println();

        for (int i = 0; i < database.size(); i++) {
            String[] array = database.get(i);
            System.out.println((i + 1) + ". Codi: " + array[0] +
                    "\t Nom: " + array[1] +
                    "\t Secció: " + array[2] +
                    "\t Preu: " + array[3] + "€" );
        }

        Scanner sc = new Scanner(System.in);
        int opcio = 0;

        System.out.println();
        System.out.println("--------------------------------------------------------------");

        System.out.println("Tornar al menú principal: ");
        System.out.println("\t[1] Si\n");

        System.out.print("Opció: \t ");
        opcio = sc.nextInt();
        System.out.println();

        switch (opcio) {
            case 1: break;
            case 2: break;
        }

    }

    static ArrayList<String[]> modul_venda(ArrayList<String[]> database) {
        ArrayList<String[]> carrito = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcio = 0;

        System.out.println();
        System.out.println("--------------------------------------------------------------");

        System.out.println("Mòdul venta: ");
        System.out.println("\t[1]\t Fer una venta");
        System.out.println("\t[-1] Tornar al menú principal\n");

        System.out.print("Opció: \t ");
        opcio = sc.nextInt();
        System.out.println();

        switch (opcio) {
            case 1: venta(database, carrito); break;
            case -1: break;
        }

        return database;

    }

    static ArrayList<String[]> venta(ArrayList<String[]> database, ArrayList<String[]> carrito ) {


        Scanner sc = new Scanner(System.in);
        int opcio = 0;

        System.out.println();
        System.out.println("--------------------------------------------------------------");

        System.out.println("Venta: ");
        System.out.println("\t[1]\t Afegir producte");
        System.out.println("\t[2]\t Generar ticket");
        System.out.println("\t[3]\t Finalitzar compra");
        System.out.println("\t[-1] Tornar al menú principal\n");

        System.out.print("Opció: \t ");
        opcio = sc.nextInt();

        switch (opcio) {
            case 1: afegir_producte_carrito(database, carrito); break;
            case 2: generar_ticket(carrito); break;
            case -1: break;
        }

        return database;

    }

    static ArrayList<String[]>  afegir_producte_carrito( ArrayList<String[]> database, ArrayList<String[]> carrito ) {

        String value, cuantitat;
        String[] producte = new String[5];
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println();

        for (int i = 0; i < database.size(); i++) {
            String[] array = database.get(i);
            System.out.println((i + 1) + ". Codi: " + array[0] +
                    "\t Nom: " + array[1] +
                    "\t Secció: " + array[2] +
                    "\t Preu: " + array[3] + "€" );
        }

        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println();

        System.out.print("Introdueix el nom o el codi de barres del producte: ");
        value = sc.nextLine();
        System.out.print("Introdueix la cuantitat a comprar: ");
        cuantitat = sc.nextLine();

        for (int i = 0; i < database.size(); i++) {
            String[] arr = database.get(i);
            if (arr[0].equals(value) ||arr[1].equals(value)) {
                for (int j = 0; j < arr.length; j++) {
                    producte[j] = arr[j];
                }
                producte[4] = cuantitat;
                carrito.add(producte);
            }
        }

        venta(database, carrito);
        return carrito;

    }

    static ArrayList<String[]> generar_ticket( ArrayList<String[]> carrito ) {

        for (int i = 0; i < carrito.size(); i++) {
            System.out.println(Arrays.toString(carrito.get(i)));
        }
        String pattern = "dd-M-yyyy";
        SimpleDateFormat DateFormat = new SimpleDateFormat(pattern);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss");
        String date = dtf.format(LocalDateTime.now());

        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("ticket_" + date + ".txt"));
            int total = 0;
            int suma = 0;

            bf.write("-----------------------------------");
            bf.newLine();
            bf.write("Ticket Supermercat");
            bf.newLine();
            bf.write("Num: " + (int) (Math.random() + 100001));
            bf.newLine();
            bf.write("-----------------------------------");
            bf.newLine();

            for (int i = 0; i < carrito.size(); i++) {
                String[] array = carrito.get(i);
                suma = Integer.parseInt(array[4]) * Integer.parseInt(array[3]);
                bf.write(array[1] + "\t\t" + array[4] + " x " + array[3] + "€ \t " + suma + "€");
                bf.newLine();
                total += suma;
            }

            bf.newLine();
            bf.write("TOTAL: " + total + "€");

            bf.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return carrito;

    }

    public static void main(String[] args) {

        ArrayList<String[]> database = new ArrayList<String[]>();
        Scanner sc = new Scanner(System.in);
        int primera_opcio = 0;

        while (primera_opcio != -1) {

            System.out.println();
            System.out.println("--------------------------------------------------------------");
            System.out.println("Benvingut al Supermarket!");
            System.out.println("--------------------------------------------------------------");

            System.out.println("Menú pricipal: ");
            System.out.println("\t[1]\t Mòdul d’estoc");
            System.out.println("\t[2]\t Mòdul venda");
            System.out.println("\t[-1] Sortir\n");

            System.out.print("Introdueix l'acció a realitzar: ");
            primera_opcio = sc.nextInt();


            switch (primera_opcio) {
                case 1: modul_estoc(database); break;
                case 2: modul_venda(database); break;
                case -1: primera_opcio = -1; break;
            }
        }
    }
}
