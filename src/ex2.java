import java.io.*;
import java.util.Scanner;
import java.util.*;

/*Pasul 1. Citim 6 nr
* Pasul 2. Generam random 6 numere distincte
* Pasul 3. Comparam numerele si vedem cate am nimerit
* Pasul 4. Afisam rezultatul si stocam fiecare rezultat intr-un fisiera
* Pasul 5. Citirea din fisier si afisarea ultimelor rezultate
* Pasul 6. Sa cream un meniu in care sa alegi ce vrei sa faciȘ joci sau veiz rezult*/

class Loto {
    private int nr,minim,maxim;
    public int[] generateNRandomNumbers(int nr, int minim, int maxim) {
        int currentNumber;
        int[] numbers = new int [nr];
        Random random = new Random();
        for (int i = 0; i < nr; i++) {
            currentNumber = random.nextInt(maxim) + minim;
            if (contains(currentNumber,numbers,i)) {
                i--;
            } else numbers[i] = currentNumber;
        }
        return numbers;
    }


    public boolean contains(int nr, int[] numbers, int pozitie) {
        for (int i = 0; i < pozitie; i++) {
            if (numbers[i] == nr) {

                return true;
            }
        }
        return false;
    }

    public int getCommonNumbersCounter(int [] numbers, int [] loto){
        int count  = 0;
        for(int i = 0; i < numbers.length ; i++){
            if(contains(numbers[i],loto,numbers.length)){
                count++;
            }
        }
       return count;
    }
    public String getCommonNumbers(int [] numbers, int [] loto){
        int count  = 0;
        for(int i = 0; i < numbers.length ; i++){
            if(contains(numbers[i],loto,numbers.length)){
                return numbers[i]+" ";
            }
        }
        return " ";
    }

    public void printToFile6(int [] numbers, int [] loto){
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("6din49.txt"), "utf-8"));
            writer.write("Ati nimerit "+ getCommonNumbersCounter(numbers,loto) +" numere, "+"numerele castigatoare din cele alease fiind: "+getCommonNumbers(numbers,loto)+".");

        } catch (IOException ex) {
            // Report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }
    public void printToFile5(int [] numbers, int [] loto){
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("5din40.txt"), "utf-8"));
            writer.write("Ati nimerit "+ getCommonNumbersCounter(numbers,loto) +" numere, "+"numerele castigatoare din cele alease fiind: "+getCommonNumbers(numbers,loto)+".");


        } catch (IOException ex) {
            // Report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }


}

public class ex2 {

    public static boolean contains(int nr, int[] numbers, int pozitie) {
        for (int i = 0; i < pozitie; i++) {
            if (numbers[i] == nr) {
                return true;
            }
        }
        return false;
    }
    public static void main(String argv[]) {

        Loto loto649 = new Loto();
        int[] tichet1 = loto649.generateNRandomNumbers(6, 0, 49);
        int[] copieTichet1 = new int[6];
        System.arraycopy(tichet1, 0, copieTichet1, 0, tichet1.length);

        int[] tichet2 = loto649.generateNRandomNumbers(5, 0, 40);
        int[] copieTichet2 = new int[6];
        System.arraycopy(tichet2, 0, copieTichet2, 0, tichet2.length);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Alegeti una din urmatoarele variante: ");
            System.out.println("1.Joc 6/49.");
            System.out.println("2.Joc 5/40.");
            System.out.println("3.Afisare rezultate ultimele doua jocuri.");
            System.out.println("4.Stop.");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int[] count = new int[100];
                    int []numar = new int[6];
                    System.out.println("Ati ales sa jucati la loto 6/49, ca urmare alegeti 6 numere DISTINCTE.");
                    for(int i = 0; i< 6; i++){
                        Scanner scan = new Scanner(System.in);
                        numar[i] = scanner.nextInt();
                        if(contains(numar[i],numar,numar.length)==true){
                            count[numar[i]]++;
                            if(count[numar[i]] == 2) {
                                count[numar[i]]--;
                                System.out.println("Ne pare rau, numerele introduse nu au fost distincte. Introduceti din nou.");
                                numar[i] = scanner.nextInt();
                            }
                        }
                        if(numar[i]<0 || numar[i]>49){
                            System.out.println("Jocul se numeste 6/49, nu crezi ca ar trebui ca numerele alese sa fie mai mici, cel mult egale cu 49?");
                            System.out.println("Reintrodu un numar valid.(mai mare sau egal cu 0, mai mic sau egacul cu 49)");
                            numar[i] = scanner.nextInt();
                        }
                    }
                    loto649.printToFile6(tichet1, numar);

                    System.out.println("Numerele castigatoare sunt: ");
                    for (int i = 0; i < 6; i++)
                        System.out.println(tichet1[i]);
                    //loto649.printToFile6(tichet1, loto);
                    break;
                case 2:
                    int[] contor = new int[100];
                    int []nr = new int[5];
                    System.out.println("Ati ales sa jucati la loto 5/40, ca urmare alegeti 5 numere DISTINCTE.");
                    for(int i = 0; i< 5; i++){
                        Scanner scan = new Scanner(System.in);
                        nr[i] = scanner.nextInt();
                        if(contains(nr[i],nr,nr.length)==true){
                            contor[nr[i]]++;
                            if(contor[nr[i]] == 2) {
                                contor[nr[i]]--;
                                System.out.println("Ne pare rau, numerele introduse nu au fost distincte. Introduceti din nou.");
                                nr[i] = scanner.nextInt();
                            }
                        }
                        if(nr[i]<0 || nr[i]>40){
                            System.out.println("Jocul se numeste 6/49, nu crezi ca ar trebui ca numerele alese sa fie mai mici, cel mult egale cu 49?");
                            System.out.println("Reintrodu un numar valid.(mai mare sau egal cu 0, mai mic sau egacul cu 49)");
                            nr[i] = scanner.nextInt();
                        }
                    }
                    loto649.printToFile5(tichet2, nr);

                    System.out.println("Numerele castigatoare sunt: ");
                    for (int i = 0; i < 5; i++)
                        System.out.println(tichet2[i]);

                    break;
                case 3:
                    System.out.println("Jocul 6/49 anterior: ");
                    for (int i = 0; i < 6; i++)
                        System.out.println(copieTichet1[i]);
                    System.out.println("Jocul 5/40 anterior: ");
                    for (int i = 0; i < 5; i++)
                        System.out.println(copieTichet2[i]);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Trebuie sa alegeti una din cele 3 variante anterioare. Apasati 1 sau 2 sau 3.");

            }
        }
    }
}
