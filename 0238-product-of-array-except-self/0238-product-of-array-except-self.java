// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] ans=new int[nums.length];
//         for(int i=0;i<nums.length;i++){
            
//             int product=1;
//             for(int j=0;j<nums.length;j++){
//                 if(i!=j){
//                     product*=nums[j];
//                 }
//             }
//             ans[i]=product;
//         }
//         return ans;
//     }
// }
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        ans[0] = 1;

        // Prefix Product
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int suffix = 1;

        // Multiply with Suffix Product
        for (int i = n - 1; i >= 0; i--) {

            ans[i] *= suffix;

            suffix *= nums[i];
        }

        return ans;
    }
}