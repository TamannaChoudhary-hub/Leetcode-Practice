class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            while(j<strs[i].length() && j<prefix.length() && strs[i].charAt(j)==prefix.charAt(j)){
                j++;
            }
            prefix=prefix.substring(0,j);
        }
        if(prefix.isEmpty())return "";
        return prefix;
    }
}