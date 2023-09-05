class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] dirs = path.split("/");
        for(String dir : dirs){
            if(!dir.equals("") && !dir.equals(".")){
                if(!dir.equals("..")) stack.add(dir);
                else if(!stack.isEmpty()) stack.pollLast();
            }
        }
        String finalPath = "";
        if(stack.isEmpty()){
            finalPath += "/";
        } else {
            for(String str : stack){
                finalPath += "/";
                finalPath += str;
            }
        }
        return finalPath;
    }
}