class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        String[] phone = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };
        solve(0, digits, phone, "", ans);
        return ans;
    }
    void solve(int index, String digits,
               String[] phone,
               String current,
               List<String> ans) {
        // Base case
        if (index == digits.length()) {
            ans.add(current);
            return;
        }
        // Current digit
        int digit = digits.charAt(index) - '0';
        String letters = phone[digit];
        // Try every letter
        for (int i = 0; i < letters.length(); i++) {
            current += letters.charAt(i);
            solve(index + 1, digits, phone, current, ans);
            current = current.substring(0, current.length() - 1);
        }
    }
}