class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>st=new Stack<>();
        int[] results = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                results[st.peek()] = i - st.pop();
            }
            st.push(i);
        }
        return results;
    }
}