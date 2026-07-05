class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets
        List<Integer>[] freq = new ArrayList[nums.length + 1];

        for (int num : count.keySet()) {
            int c = count.get(num);

            if (freq[c] == null) {
                freq[c] = new ArrayList<>();
            }

            freq[c].add(num);
        }

        // Step 3: Collect top k frequent elements
        int[] res = new int[k];
        int index = 0;

        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            if (freq[i] != null) {
                for (int num : freq[i]) {
                    res[index++] = num;

                    if (index == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}