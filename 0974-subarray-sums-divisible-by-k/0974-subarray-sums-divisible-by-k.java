class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            int rem = ((sum % k) + k) % k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {

//         int count = 0;

//         for (int i = 0; i < nums.length; i++) {

//             int sum = 0;

//             for (int j = i; j < nums.length; j++) {

//                 sum += nums[j];

//                 if (sum % k == 0) {
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }