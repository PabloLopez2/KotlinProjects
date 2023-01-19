package exercicis_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


// Aquí farem alguns exercicis en JAVA

public class Exercicis {
    public static void main(String[] args) {
        Exercici1();
        Exercici2();
        Exercici3();
        Exercici4();
        Exercici5();

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
        System.out.print("Ingresa el número: ");
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
            System.out.print("Escribe un numero ");
            Scanner capt = new Scanner(System.in);
            int n = capt.nextInt();

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(n);
                }
                System.out.println();
            }
            if (n == 1){
                return;
            }
        }
    }
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
}

