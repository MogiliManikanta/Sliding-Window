class Solution {
    //HashMap<String,List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer>result = new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(checkcharacter(c)){
                String left = expression.substring(0,i);
                String right = expression.substring(i+1);
                List<Integer>leftCompute = diffWaysToCompute(left);
                List<Integer>rightCompute = diffWaysToCompute(right);
                for(int leftValue : leftCompute){
                    for(int rightValue : rightCompute){
                        if(c=='+'){
                            result.add(leftValue + rightValue);
                        }
                        if(c=='-'){
                            result.add(leftValue - rightValue);
                        }
                        if(c=='*'){
                            result.add(leftValue * rightValue);
                        }
                    }
                } 
            }
        }//// if the input string contains only number
        if(result.isEmpty()){
                result.add(Integer.parseInt(expression));
            }
            //map.put(expression,result);
            return result;
    }
    public boolean checkcharacter(char ch){
        if(ch=='+' || ch=='-' || ch=='*'){
            return true;
        }
        return false;
    }
}
/**The problem becomes easier when we think about these expressions as expression trees.
We can traverse over the experssion and whenever we encounter an operator, we recursively divide the expression into left and right part and evaluate them seperately until we reach a situation where our expression is purely a number and in this case we can simply return that number.
Since there can be multiple ways to evaluate an expression (depending on which operator you take first) we will get a list of reults from left and the right part.
Now that we have all the possible results from the left and the right part, we can use them to find out all the possible results for the current operator.
 */
/*
step1 first compute left value and right value and add with the character



watch video of hakunamata*/