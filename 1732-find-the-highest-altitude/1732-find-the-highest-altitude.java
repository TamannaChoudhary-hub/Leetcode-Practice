class Solution {
    public int largestAltitude(int[] gain) {
        int maxaltitude=0;
        int sum=0;
        int[] alt=new int[gain.length+1];
        for(int i=0;i<gain.length;i++){
            alt[i+1]=alt[i]+gain[i];
            
        }
        for(int x:alt){
            maxaltitude=Math.max(maxaltitude,x);  
        }
        return maxaltitude;
    }
}