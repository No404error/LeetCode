class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length;){
            int val=nums[i];
            List<List<Integer>> a=findTwoNumsToTarget(nums,i+1,0-val);
            for(int j=0;j<a.size();j++){
                a.get(j).add(val);
                res.add(a.get(j));
            }
            while(i<nums.length&&nums[i]==val) i++;
        }
        return res;
    }
    //双指针算法
    public List<List<Integer>> findTwoNumsToTarget(int[] nums,int start,int target){
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        int end=nums.length-1;
        int left,right;
        while(start<end){
            if(target==nums[start]+nums[end]){
                List<Integer> list=new ArrayList<>();
                list.add(nums[start]);
                list.add(nums[end]);
                res.add(list);
                left=nums[start];
                right=nums[end];
                while(start<end&&nums[start]==left) start++;
                while(start<end&&nums[end]==right) end--;
            }else if(target<nums[start]+nums[end]){
                right=nums[end];
                while(start<end&&nums[end]==right) end--;
            }else{
                left=nums[start];
                while(start<end&&nums[start]==left) start++;
            }
        }
        return res;
    };
}