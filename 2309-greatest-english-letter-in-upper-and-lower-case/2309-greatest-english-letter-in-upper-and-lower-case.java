class Solution {
    public String greatestLetter(String s) {
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            seen.add(c);
        }
        for (char c = 'Z'; c >= 'A'; c--) {
            char lower = Character.toLowerCase(c);
            if (seen.contains(c) && seen.contains(lower)) {
                return String.valueOf(c);
            }
        }
        
        return "";
    }
}
