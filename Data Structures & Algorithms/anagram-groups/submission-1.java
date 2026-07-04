class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>  map = new HashMap<>();
        for(String word: strs ){
            int [] count = new int [26];

            for( char c : word.toCharArray ()){
                count [c-'a']++;
            }

            StringBuilder key = new StringBuilder ();

            for(int num : count){
                key.append(num).append('#');

            }

            String k= key.toString();
            map.putIfAbsent(k,new ArrayList());
            map.get(k).add(word);

        }

        return new ArrayList<>(map.values());
    }
}
