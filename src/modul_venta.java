import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class modul_venta {

    public static ArrayList<String[]> modul_venda(ArrayList<String[]> database) {
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

    public static ArrayList<String[]> venta(ArrayList<String[]> database, ArrayList<String[]> carrito ) {


        Scanner sc = new Scanner(System.in);
        int opcio = 0;

        System.out.println();
        System.out.println("--------------------------------------------------------------");

        System.out.println("Productes al carrito: " + carrito.size());

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
            case 3: System.exit(0); break;
            case -1: break;
        }

        return database;

    }

    public static ArrayList<String[]>  afegir_producte_carrito( ArrayList<String[]> database, ArrayList<String[]> carrito ) {

        String value, cuantitat;
        String[] producte = new String[5];
        Scanner sc = new Scanner(System.in);
        int opcio;
        boolean exists = false;
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
        System.out.print("Introdueix la quantitat a comprar: ");
        cuantitat = sc.nextLine();

        for (int i = 0; i < database.size(); i++) {
            String[] arr = database.get(i);
            if (arr[0].equals(value) ||arr[1].equals(value)) {
                exists = true;
                for (int j = 0; j < arr.length; j++) {
                    producte[j] = arr[j];
                }
                producte[4] = cuantitat;
                carrito.add(producte);
                break;
            }
        }

        if (! exists) {
            System.out.println();
            System.out.println("--------------------------------------------------------------");
            System.out.println();
            System.out.println("No s'ha trobat cap producte amb el codi de barres proporcionat");
            System.out.println("Vols tornar a intentar-ho?");
            System.out.println("\t[1]\t Si");
            System.out.println("\t[2]\t No");
            opcio = sc.nextInt();

            switch (opcio) {
                case 1: afegir_producte_carrito(database, carrito); break;
                case 2: break;
            }

        }


        venta(database, carrito);
        return carrito;

    }

    public static ArrayList<String[]> generar_ticket( ArrayList<String[]> carrito ) {

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
}
