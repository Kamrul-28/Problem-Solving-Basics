package Blind75;
import java.util.*;

/**
 * Leetcode 347. Top K Frequent Elements
 */
class Q5TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        Integer k=2;
        topKFrequent(nums,k);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)-> b.getValue().compareTo(a.getValue()));

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = list.get(i).getKey();
        }

        return ans;
    }

    public static int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = maxHeap.poll();
        }

        return ans;
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //1) Create n empty buckets
        //2) Put array elements in different buckets
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> topK = new ArrayList<>();
        for (int pos = bucket.length - 1;pos >= 0 && topK.size() < k; pos--) {
        if (bucket[pos] != null) {
            topK.addAll(bucket[pos]);
        }
        }

        return topK.stream().mapToInt(i -> i).toArray();
    }
}
