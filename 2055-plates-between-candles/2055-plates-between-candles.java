// class Solution {
//     public int[] platesBetweenCandles(String s, int[][] queries) {
//         int[] ans = new int[queries.length];
//         for (int q = 0; q < queries.length; q++) {
//             int left = queries[q][0];
//             int right = queries[q][1];
//             int first = -1;
//             int last = -1;
//             // Find first candle
//             for (int i = left; i <= right; i++) {
//                 if (s.charAt(i) == '|') {
//                     first = i;
//                     break;
//                 }
//             }
//             // Find last candle
//             for (int i = right; i >= left; i--) {
//                 if (s.charAt(i) == '|') {
//                     last = i;
//                     break;
//                 }
//             }
//             if (first == -1 || last == -1 || first >= last) {
//                 ans[q] = 0;
//                 continue;
//             }
//             int count = 0;
//             for (int i = first + 1; i < last; i++) {
//                 if (s.charAt(i) == '*')
//                     count++;
//             }
//             ans[q] = count;
//         }
//         return ans;
//     }
// }


class Solution {

    public int[] platesBetweenCandles(String s, int[][] queries) {

        int n = s.length();

        int[] prefix = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        // Prefix Plates
        prefix[0] = s.charAt(0) == '*' ? 1 : 0;

        for (int i = 1; i < n; i++) {

            prefix[i] = prefix[i - 1];

            if (s.charAt(i) == '*')
                prefix[i]++;
        }

        // Left Candle
        int last = -1;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '|')
                last = i;

            left[i] = last;
        }

        // Right Candle
        last = -1;

        for (int i = n - 1; i >= 0; i--) {

            if (s.charAt(i) == '|')
                last = i;

            right[i] = last;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int start = right[l];
            int end = left[r];

            if (start == -1 || end == -1 || start >= end)
                ans[i] = 0;
            else
                ans[i] = prefix[end] - prefix[start];
        }

        return ans;
    }
}