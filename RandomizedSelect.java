//RandomizedSelect.java

//declare package
package AlgoProjV1;

public class RandomizedSelect {
    public int RANDOMIZED_SELECT(int[] A, int p, int r, int i) {
        if (p == r) {
            return A[p];
        }
        
        int q = RANDOMIZED_PARTITION(A, p, r);
        int k = q - p + 1;
        
        if (i == k) {
            return A[q];
        }
        else if (i < k) {
            return RANDOMIZED_SELECT(A, p, q-1, i);
        }
        else {
            return RANDOMIZED_SELECT(A, q+1, r, i-k);
        }
        
        
    }
    
    public int RANDOMIZED_PARTITION(int[] A, int p, int r) {
        int i = p + (int)(Math.random() * (r - p + 1));
        
        int temp = A[r];
        A[r] = A[i];
        A[i] = temp;
        
        return PARTITION(A, p, r);
    }
    
    public int PARTITION(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        
        return i + 1;
    }
}
