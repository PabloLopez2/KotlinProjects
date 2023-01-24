package linkedList;

public class Main {
   //Ex 1: Crea una classe Main i fes print de totes les seves variables i funcions
   public static void main(String[] args) {
      MyLinkedList<String> list = new MyLinkedList<>();
      MyLinkedList<String> list2 = new MyLinkedList<>();

      list.addFirst("hola");
      list.addFirst("adeu");
      list.get(0);
      list2.get(0);

      Node<String> node1 = new Node<>("hola",null, null);
      Node<String> node2 = new Node<>("1",node1, null);

      MyLinkedList<Integer> llista3 = new MyLinkedList<>();

      System.out.println("Size: " + llista3.size());
      llista3.addFirst(5);
      System.out.println("Size after adding element: " + llista3.size());
      llista3.set(0, 10);
      System.out.println("Value at index 0: " + llista3.get(0));
      llista3.remove(0);
      System.out.println("Size after removing element: " + llista3.size());

      /*Ex 2: Dissenya en un paper quines variables i funcions auxiliars necessitaràs per tal d’implementar aquesta classe.
      Algunes variables i funcions auxiliars que podem trobar son:
      head i tail, on head seria el principi de la llista i tail el final
      size, que ens manté la mida de la llista

      En l'àmbit de funcions:
      constructors, add(int indez, T element), getNode(int index)*/

      /* Ex 3:
      Implementa totes les funcions de la classe MyLinkedList. (Escriure el codi perquè funcioni correctament)
         a)Implementa les funcions get(), set(), remove().
         b)Implementa les funcions addFirst(), addLast(), popFirst(), popLast().
         */


   }

}
