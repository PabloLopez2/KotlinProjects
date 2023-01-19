package exercicis_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;


// Aquí farem alguns exercicis en JAVA

public class Exercicis {
    public static void main(String[] args) {
        Exercici1();
        Exercici2();
        Exercici3();
        Exercici4();
        Exercici5();
        Exercici6();
        Exercici7();
        Exercici8();
        Exercici9();
        Exercici10();
    }

    public static void Exercici1() {
          /* Ex 1 (sintaxi): Escriu un programa que demana la següent informació a l’usuari i imprimeix una frase fent servir aquestes dades.
        a. El nom de l’usuari
        b. El nom d’un artista
        c. Un hobby (verb) */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the name of an artist: ");
        String artist = scanner.nextLine();

        System.out.print("Enter a hobby (verb): ");
        String hobby = scanner.nextLine();

        System.out.println(name + " likes listening to " + artist + " while " + hobby);
    }

    public static void Exercici2() {
        //Ex 4 (condicionals i loops): Fes un programa que llegeix un nombre n i escriu tots els nombres entre 0 i n.
        System.out.println("\nIngresa el número: ");
        Scanner number = new Scanner(System.in);

        int n = number.nextInt();
        for (int i = 0; i <= n; i++) {
            System.out.print(i);
        }
    }

    public static void Exercici3() {
        ArrayList<Integer> llista = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            llista.add(i);
        }

        for (Integer llista2 : llista) {
            if (llista.indexOf(llista2) == llista.size() - 1) {
                System.out.print(llista2);
            } else {
                System.out.print(llista2 + ", ");
            }
        }
    }

    public static void Exercici4() {
        //Ex 6 (loops inside loops): Fes un programa que llegeix diversos números. Per cada número n imprimirà quadrat de dimensions n x n ple de n’s.
        while (true) {
            System.out.println("\nEscribe un numero ");
            Scanner capt = new Scanner(System.in);
            int n = capt.nextInt();

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(n);
                }
                System.out.println();
            }
            if (n == 1) {
                return;
            }
        }
    }

    /*
    Ex 2 (Excepcions): Dissenya una funció que rep una llista d’elements de qualsevol mena i una llista d’índexs.
    Aquesta ha de retornar els elements de la primera llista que es troben en les posicions indicades
    a la llista d’índexs.
    fun filterByIndex(list: List<Any>, indexs: List<Int?>): List<Any>
     */
    public static List<Object> filterByIndex(List<Object> list, List<Integer> indexs) {
        List<Object> result = new ArrayList<>();
        for (Integer index : indexs) {
            try {
                result.add(index == null ? null : list.get(index));
            } catch (IndexOutOfBoundsException e) {
                //cacheo
            }
        }
        return result;
    }

    public static void Exercici5() {
        List<Object> list = new ArrayList<>();
        list.add("element1");
        list.add("element2");
        list.add("element3");

        List<Integer> indexs = Arrays.asList(1, 2, 3, 4, 5);
        List<Object> result = filterByIndex(list, indexs);
        System.out.println(result);
    }

    //Ex 4 (funcions) Implementa una funció que multiplica dos nombres sense fer ús de l’operador
    public static void Exercici6() {
        multiply(3, 8);
    }

    public static void multiply(double a, int b) {
        double multi = 0.0;
        for (int i = 1; i <= b; i++) {
            multi += a;
        }
        System.out.println(multi);
    }

    /* Ex 5 (nullability) Escriu una funció que rep una llista que pot contenir enters nuls i imprimeix per pantalla només
    els nombres senars. */

    public static void Exercici7() {
        printOnlyOdds(new ArrayList<>());
    }

    public static void printOnlyOdds(List<Integer> list) {
        for (Integer element : list) {
            if (element != null && element % 2 != 0) {
                System.out.print(element + " ");
            }
        }
    }

    /*Ex 1 (hashmap)
    Implementa un programa que, donada una paraula, compti quantes vegades apareix
    cada lletra de l’abecedari. El programa ha de tenir les següents característiques:
        a. Llegeix paraules indefinidament.
        b. Finalitza quan l’usuari introdueix el caràcter ‘#’.Tingues en compte que aquest símbol pot aparèixer intercalat dins d’una paraula.
        c. El programa ha de comptar les lletres minúscules i majúscules com a la mateixa lletra.
        d. Si una lletra apareix 0 vegades, no s’ha d’imprimir.
        e. Només es tenen en compte les lletres. Els símbols o números no han d’aparèixer al resultat final.
        f. L’entrada serà sense caràcters accentuats. */
    public static void Exercici8() {
        Scanner scanner = new Scanner(System.in);
        String palabra;
        do {
            System.out.print("Escriu la paraula per analizar o escriu'#' per sortir: ");
            palabra = scanner.nextLine().toLowerCase();
            if (!palabra.equals("#")) {
                HashMap<Character, Integer> emptyMap = new HashMap<>();
                for (int i = 0; i < palabra.length(); i++) {
                    char c = palabra.charAt(i);
                    if (Character.isLetter(c)) {
                        if (emptyMap.containsKey(c)) {
                            emptyMap.put(c, emptyMap.get(c) + 1);
                        } else {
                            emptyMap.put(c, 1);
                        }
                    }
                }
                for (char c = 'a'; c <= 'z'; c++) {
                    if (emptyMap.containsKey(c) && emptyMap.get(c) != 0) {
                        System.out.println("La letra " + c + " aparece " + emptyMap.get(c) + " veces.");
                    }
                }
            }
        } while (!palabra.equals("#"));
    }

    //Ex 4 (llistes+hackaton) Digues si una paraula es un palíndrom o no

    public static void Exercici9() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriu una paraula i et diré si es un palíndrom o no: ");
        String palabr = scanner.nextLine().toLowerCase().replaceAll("\s+", "");
        char[] palabrChar = palabr.toCharArray();
        char[] reversedPalabrChar = new char[palabrChar.length];

        for (int i = 0; i < palabrChar.length; i++) {
            reversedPalabrChar[i] = palabrChar[palabrChar.length - 1 - i];
        }

        String reversedPalabr = new String(reversedPalabrChar);
        System.out.println(reversedPalabr);

        if (reversedPalabr.equals(palabr)) {
            System.out.println(reversedPalabr + " es un palindrom");
        } else {
            System.out.println(reversedPalabr + " no es un palindrom");
        }
    }

    //Ex 10 (recursivitat): fes el quicksort ;)
    public static void Exercici10() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(3, 1, 8, 10, 4, 2, 5));
        quickSort(list1);
        System.out.println("Alguien ha pedido un quicksort a domicilio?: ");
        System.out.println(list1);
    }

    public static void quickSort(ArrayList<Integer> list) {
        if (list.size() <= 1) return;

        int pivot = list.get(list.size() / 2);
        ArrayList<Integer> lesser = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() / 2) continue;
            if (list.get(i) < pivot) {
                lesser.add(list.get(i));
            } else {
                greater.add(list.get(i));
            }
        }

        quickSort(lesser);
        quickSort(greater);

        list.clear();
        list.addAll(lesser);
        list.add(pivot);
        list.addAll(greater);
    }
}











