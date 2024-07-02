class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int num: nums1 ){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> list = new ArrayList<>();

        for ( int num : nums2 ){
            if ( map.containsKey(num)){
                int freq = map.get(num);
                list.add(num);
                if (freq > 1 ){
                    map.put(num, freq-1);
                }else{
                    map.remove(num);
                }
            }
        }

        int[] intersection = new int[list.size()];
        for( int i = 0; i < list.size(); i++ ){
            intersection[i] = list.get(i); 
        }
        return intersection;
    }
}