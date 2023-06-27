class Solution {
    public int numTrees(int n) {
        int[] res=new int[20];
        res[0]=1;
        res[1]=1;
        for(int i=2;i<=19;i++){
            int num=0;
            for(int j=1;j<=i;j++)
                num+=res[j-1]*res[i-j];
            res[i]=num;
        }
        return res[n];
    }
}