class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> result = new ArrayList<>();
         HashMap<String, List<String>> hm = new HashMap<>();

         for(String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String sorted = new String(s);
           
            hm.putIfAbsent(sorted,  new ArrayList<>());
            hm.get(sorted).add(str);
            
         }

         return new ArrayList<>(hm.values());
    }
}
