package Java.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BucketSort
 * Algorithm: 
 * 1) Create n empty buckets
 * 2) Put array elements in different buckets
 * 3) Sort individual buckets
 * 4) Concatenate all buckets into arr[]
 */
/**
 * InnerBucketSort
 */
public class BucketSort {
    public static void main(String[] args) {
        float[] arr = { (float) 0.42, (float) 0.32, (float) 0.33, (float) 0.52, (float) 0.37, (float) 0.47,
            (float) 0.51 };
            
        bucketSort(arr);

        System.out.println("Sorted array is:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
        
    }
    public static void bucketSort(float[] arr) {
        int n = arr.length;

        // 1) Create n empty buckets
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int bi = (int) (n * arr[i]);
            buckets[bi].add(arr[i]);
        }

        // 3) Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort((buckets[i]));
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
}
