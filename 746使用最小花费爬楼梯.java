class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int pre=0;
        int now=0;
        int tmp;
        for(int i=2;i<cost.length+1;i++){
            tmp=Math.min(now+cost[i-1],pre+cost[i-2]);
            pre=now;
            now=tmp;
        }
        return now;
    }
}