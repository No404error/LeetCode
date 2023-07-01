class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk=new Stack<>();
        int[] dp=new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                dp[i]=0;
                stk.push(i);
            }
            else{
                if(!stk.isEmpty()){
                    int left=stk.peek();
                    stk.pop();
                    dp[i]=1+i-left+(left==0?0:dp[left-1]);
                }else
                    dp[i]=0;
            }
        } 
        int res=0;
        for(int i=0;i<dp.length;i++)
            res=Math.max(res,dp[i]);
        return res;
    }
}