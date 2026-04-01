class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> e : hm.entrySet()){
            list.add(new int[]{e.getKey(), e.getValue()});
        }
        list.sort((a,b) -> b[1] - a[1]);
         
      
        int[] r = new int[k];
       for(int i=0;i<k;i++){
           r[i] = list.get(i)[0];
        }
        return r;
        
    }
}
