class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int pre=0,now=1;
        for(int i=0;i<n-1;i++){
            int tmp=now+pre;
            pre=now;
            now=tmp;
        }
        return now; 
    }
}