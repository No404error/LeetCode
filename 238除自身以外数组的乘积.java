class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        int sum=1;
        for(int i=0;i<res.length;i++){
            res[i]=sum;
            sum*=nums[i];
        }
        sum=1;
        for(int i=res.length-1;i>=0;i--){
            res[i]*=sum;
            sum*=nums[i];
        }
        return res;
    }
}