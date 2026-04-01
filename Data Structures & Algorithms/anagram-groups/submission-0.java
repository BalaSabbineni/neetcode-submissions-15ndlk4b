class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

       Map<String, List<String>> map = new HashMap<>();

       for(String str : strs) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        String sorted = new String(c);
        map.putIfAbsent(sorted, new ArrayList<>());
        map.get(sorted).add(str);
       }

       return new ArrayList<>(map.values());
        
        
    }
}
