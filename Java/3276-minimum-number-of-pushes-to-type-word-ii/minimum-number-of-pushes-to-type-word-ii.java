class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort the freq array in ascending order
        Arrays.sort(freq);

        // Reverse the sorted freq array to get descending order
        reverseArray(freq);

        int count = 0;
        int result = 0;
        for (int num : freq) {
            if (num == 0) {
                break;
            }
            if (count < 8) {
                result += 1 * num;
            } else if (count < 16) {
                result += 2 * num;
            } else if (count < 24) {
                result += 3 * num;
            } else {
                result += 4 * num;
            }
            count++;
        }
        return result;
    }

    private void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}