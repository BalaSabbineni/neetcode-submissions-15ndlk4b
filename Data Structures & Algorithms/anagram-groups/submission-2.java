class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
HashMap<String, List<String>> hm = new HashMap<>();

        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String sortedStr = new String(s);
            hm.putIfAbsent(sortedStr, new ArrayList<>());
            hm.get(sortedStr).add(str);
        }

        return new ArrayList<>(hm.values());
        
        
    }
}
