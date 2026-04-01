class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hm= new HashMap<>();

        for(String str: strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = new String(ch);

          hm.putIfAbsent(sortedStr, new ArrayList<>());
          hm.get(sortedStr).add(str);  
        }    

        return new ArrayList<>(hm.values());
        
    }
}
