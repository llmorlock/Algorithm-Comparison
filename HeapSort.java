//HeapSort.java

//declare package
package AlgoProjV1;

public class HeapSort {
    public int[] HEAPSORT(int[] A) {
        int n = heap_size = A.length;
        BUILD_MAX_HEAP(A);
        
        for (int i = n-1; i >= 0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            
            heap_size--;
            MAX_HEAPIFY(A, 0);
        }
        
        return A;
    }
    
    public void BUILD_MAX_HEAP(int[] A) {
        int n = heap_size = A.length;
        for (int i = (n / 2); i >= 0; i--) {    //int division
            MAX_HEAPIFY(A, i);
        }
    }
    
    public int[] MAX_HEAPIFY(int[] A, int i) {
        int n = heap_size;
        int l = LEFT(i);
        int r = RIGHT(i);
        int largest;
        
        if (l <= n-1 && A[l] > A[i]) {
            largest = l;
        }
        else {
            largest = i;
        }
        
        if (r <= n-1 && A[r] > A[largest]) {
            largest = r;
        }
        
        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            
            MAX_HEAPIFY(A, largest);
        }

        return A;
    }
    
    public int PARENT(int i) {
        return i / 2;       //int division
    }
    
    public int LEFT(int i) {
        return 2 * i;
    }
    
    public int RIGHT(int i) {
        return (2 * i) + 1;
    }
    
    //instance variables
    int heap_size;
}
