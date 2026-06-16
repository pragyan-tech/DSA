class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>m=new HashMap<>();
        for(String word:strs){
            char[]arr=word.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            m.putIfAbsent(key,new ArrayList<>());
            m.get(key).add(word);
        }
        return new ArrayList<>(m.values());
    }
}