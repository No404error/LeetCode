class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return findNNumsToTarget(nums,4,0,target);
    }
     //双指针算法,要求nums排好序
    public List<List<Integer>> findNNumsToTarget(int[] nums,int n,int start,long target){
        List<List<Integer>> res=new ArrayList<>();
        //Arrays.sort(nums);
        if(n<2||nums.length-start<n)
            return res;
        
        if(n==2){
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
        }else if(n>2){
            for(int i=start;i<nums.length;){
                int val=nums[i];
                List<List<Integer>> a=findNNumsToTarget(nums,n-1,i+1,target-val);
                for(int j=0;j<a.size();j++){
                    a.get(j).add(val);
                    res.add(a.get(j));
                }
                while(i<nums.length&&nums[i]==val) i++;
            }
        }
        return res;
    };
}