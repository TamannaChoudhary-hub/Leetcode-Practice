class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder clean=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                clean.append(Character.toLowerCase(c));
            }
        }
        String f=clean.toString();
        String b=clean.reverse().toString();
        return f.equals(b);
    }
}