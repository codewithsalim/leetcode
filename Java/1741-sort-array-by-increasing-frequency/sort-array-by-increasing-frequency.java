class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int num: nums ){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        Integer[] numbers = new Integer[nums.length];
        for ( int i = 0; i < nums.length; i++ ){
            numbers[i] = nums[i];
        }

        Arrays.sort(numbers, (a,b) -> {
            if ( map.get(a) == map.get(b) ){
                return Integer.compare(b, a);
            }
            return Integer.compare(map.get(a), map.get(b));
        }
        
        );

        for ( int i = 0; i < nums.length; i++ ){
            nums[i] = numbers[i];
        }
        return nums;
    }
}
