import java.util.ArrayList;
import java.util.Scanner;

public class modul_estoc {

    public static void modul_estoc(ArrayList<String[]> database) {

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

    public static void  afegir_producte( ArrayList<String[]> database ) {

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
            case 2: modul_estoc(database);
        }

    }

    public static void eliminar_producte(ArrayList<String[]> database) {

        Scanner sc = new Scanner(System.in);
        String id = "0";
        int opcio = 0;
        boolean exist = false;

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
                exist = true;

                System.out.println();
                System.out.println("--------------------------------------------------------------");

                System.out.println("Producte eliminat correctament! Vols eliminar un altre? ");

                System.out.println("\t[1] Si");
                System.out.println("\t[2] No\n");

                System.out.print("Opció: \t ");
                opcio = sc.nextInt();

                switch (opcio) {
                    case 1: eliminar_producte(database); break;
                    case 2: modul_estoc(database);
                }

            }
        }

        if (!exist) {

            System.out.println();
            System.out.println("--------------------------------------------------------------");

            System.out.println("No existeix el producte amb codi " + id +"! Vols tornar-ho a provar? ");

            System.out.println("\t[1] Si");
            System.out.println("\t[2] No\n");

            System.out.print("Opció: \t ");
            opcio = sc.nextInt();

            switch (opcio) {
                case 1: eliminar_producte(database); break;
                case 2: modul_estoc(database);
            }

        }

    }

    public static void llistar_producte(ArrayList<String[]> database) {

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

}
