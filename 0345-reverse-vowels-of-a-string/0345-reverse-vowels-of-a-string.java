class Solution {
    public String reverseVowels(String s) {
        int left=0;int right=s.length()-1;
        char[] arr=s.toCharArray();
        while(left<right){
            if(!isvowel(arr[left])){
                left++;
            }
            else if(!isvowel(arr[right])){
                right--;
            }
            else{
                char temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
            
        } 
        return new String(arr);
    }
    private boolean isvowel(char ch){
        if(ch=='a'|| ch=='e'||ch=='i'||ch=='o'||ch=='u'|| ch=='A'|| ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            return true;
        }
        return false;
    }
}