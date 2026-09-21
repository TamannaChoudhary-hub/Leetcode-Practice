class Solution {
    public String simplifyPath(String path) {
        Stack<String>stack=new Stack<>();
        String[] pt=path.split("/");
        for(String p:pt){
            if(p.equals("")||p.equals(".")){
                continue;
            }
            if(p.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(p);
            }
        }
        StringBuilder res=new StringBuilder();
        for(String f:stack){
            res.append("/");
            res.append(f);

        }
        if(res.length()==0){
            return "/";
        }
        return res.toString();
    }
}