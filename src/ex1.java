import java.util.Scanner;
import java.util.*;


public class ex1 {
    public static void main(String argv[]) {
        int arr[] = new int [6];
        Scanner scanner = new Scanner(System.in);//imi declar un obiect de tip scanner din fisierul System.in
        for(int i = 0; i < 6 && scanner.hasNextInt(); i++) {//asteapta sa introduc ceva si verifica daca e numar intreg
            arr[i] = scanner.nextInt();//imi ia numarul pe care l-am dat din clasa scanner

        }

        for(int i = 0; i<6;i++){
            System.out.println(arr[i]);
        }
    }
}
