//SelectionProblem.java

//declare package
package AlgoProjV1;
import java.util.*;
import java.time.*;

public class SelectionProblem {
    public static void main(String[] args) {
        //int alg1Arr = 0, alg2Arr = 0, alg3Arr = 0;
        long[] alg1Arr = new long[10], alg2Arr = new long[10];
        double[] alg3Arr = new double[10];
        int m = 5;
        
        for (int i = 0; i < 10; i++) {
            alg1Arr[i] = alg2Arr[i] = 0;
            alg3Arr[i] = 0;
        }
        
        int n = 10000;
        for (int i = 0; i < m; i++) {
            for (int k = 1; k <= 10; k++) {
                System.out.println("---START ITERATION "+ k +"---");
                runAlgos(k * n);
                System.out.println("----END ITERATION "+ k +"---");
                System.out.println();
                iteration2++;
            }
            iteration1++;
            iteration2 = 0;
        }
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                alg1Arr[i] += t1[j][i];
                alg2Arr[i] += t2[j][i];
                alg3Arr[i] += t3[j][i];
            }
        }
        
        for (int i = 0; i < 10; i++) {
            alg1Arr[i] /= 5;
            alg2Arr[i] /= 5;
            alg3Arr[i] /= 5.00;
        }
        
        System.out.println("-----FINAL AVG TIMES-----");
        System.out.println("ALG1: " + Arrays.toString(alg1Arr));
        System.out.println("ALG2: " + Arrays.toString(alg2Arr));
        System.out.println("ALG3: " + Arrays.toString(alg3Arr));
    }
    
    public static void runAlgos(int n) {
        int i = (2 * n) / 3;        //int division == floor
        int min = 0, max = 32767;
        SelectionProblem sp = new SelectionProblem();
        
        int[] A1 = new int[n];
        int[] A2 = new int[n];
        int[] A3 = new int[n];
        
        for (int k = 0; k < n; k++) {
            A1[k] = min + (int)(Math.random() * (max - min + 1));
        }
        
        System.arraycopy(A1, 0, A2, 0, n);      //deep copy
        System.arraycopy(A1, 0, A3, 0, n);
        
        sp.ALG1(A1, n, i);
        sp.ALG2(A2, n, i);
        sp.ALG3(A3, n, i);
    }
    
    public void ALG1(int[] A, int n, int i) {
        InsertionSort ins = new InsertionSort();
        
        Instant start = Instant.now();
        A = ins.INSERTION_SORT(A);
        Instant end = Instant.now();
        
        System.out.println(A[i-1]);     //i-1 because starting at 0
//        System.out.println("Total time ALG1: " + 
//                Duration.between(start, end).toMillis());
        
        t1[iteration1][iteration2] = Duration.between(start, end).toMillis();
    }
    
    public void ALG2(int[] A, int n, int i) {
        HeapSort hea = new HeapSort();
        
        Instant start = Instant.now();
        A = hea.HEAPSORT(A);
        Instant end = Instant.now();
        
        System.out.println(A[i-1]);     //i-1 because starting at 0
//        System.out.println("Total time ALG2: " + 
//                Duration.between(start, end).toMillis());
        
        t2[iteration1][iteration2] = Duration.between(start, end).toMillis();
    }
    
    public void ALG3(int[] A, int n, int i) {
        RandomizedSelect ran = new RandomizedSelect();
        
        Instant start = Instant.now();
        int x = ran.RANDOMIZED_SELECT(A, 0, n-1, i);    //n-1 bc starting at 0
        Instant end = Instant.now();
        
        System.out.println(x);
//        System.out.println("Total time ALG3: " + 
//                Duration.between(start, end).toMillis());
        
        t3[iteration1][iteration2] = Duration.between(start, end).toMillis();
    }
    
    //instance variables
    static long[][] t1 = new long[5][10], t2 = new long[5][10], 
            t3 = new long[5][10];
    static int iteration1 = 0, iteration2 = 0;
}
