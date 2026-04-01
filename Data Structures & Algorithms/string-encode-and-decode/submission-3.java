class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length())
            .append('#')
            .append(str);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
         List<String> result = new ArrayList<>();
         int i=0;

         while(i<str.length()){
            // need w=a j to find length which is appended in encdoe func
            int j = i;

            // to find length we need to find delimiter
            while(str.charAt(j) != '#') {
                j++;
            }
            // after this step, we'll know length which is before #.
            int len = Integer.parseInt(str.substring(i, j));
            // now move i location after delimiter to get sub string
            i= j+1;
            result.add(str.substring(i, i+len));
            i += len;
         }

         return result;
    }
}
