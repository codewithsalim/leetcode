class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        String[] sentence1 = s1.split(" ");
        String[] sentence2 = s2.split(" ");

        for(String word: sentence1 ){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        for(String word: sentence2 ){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        for ( Map.Entry<String, Integer> entry : map.entrySet() ){
            if ( entry.getValue() == 1 ){
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[0]);
    }

}


