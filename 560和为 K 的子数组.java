class Solution {
    public int subarraySum(int[] nums, int k) {
        for(int i=0;i<nums.length;i++)
            nums[i]+=(i==0?0:nums[i-1]);
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-k)){
                res+=map.get(nums[i]-k);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return res;
    }
}