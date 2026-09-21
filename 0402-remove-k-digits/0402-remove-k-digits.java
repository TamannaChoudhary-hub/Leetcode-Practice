class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        for (char c : stack) {
            ans.append(c);
        }
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }
        ans = ans.delete(0, i);
        if (ans.length() == 0) {
            return "0";
        }
        return ans.toString();
    }
}