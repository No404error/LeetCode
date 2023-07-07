class Solution {
    public boolean isMatch(String s, String p) {
        char[] s1=s.toCharArray(),p1=p.toCharArray();
        int len1=s1.length+1,len2=p1.length+1;
        boolean[][] dp=new boolean[len1][len2];
        dp[0][0]=true;
        for(int j=1;j<len2;j++)
            if(p1[j-1]=='*')
                dp[0][j]=dp[0][j-2];
        for(int i=1;i<len1;i++)
            for(int j=1;j<len2;j++){
                if(s1[i-1]==p1[j-1]||p1[j-1]=='.')
                    dp[i][j]=dp[i-1][j-1];
                else if(p1[j-1]=='*'){
                    if(s1[i-1]==p1[j-2]||p1[j-2]=='.')
                        dp[i][j]=dp[i][j-2]||dp[i-1][j];
                    else
                        dp[i][j]=dp[i][j-2];
                }
            }
        return dp[len1-1][len2-1];
    }
}