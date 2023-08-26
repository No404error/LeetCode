class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        int i=0;
        int n=nums.length;
        while(i<n){
            int start=i++;
            while(i<n&&nums[i]==nums[i-1]+1)
                i++;
            StringBuffer sb=new StringBuffer(Integer.toString(nums[start]));
            if(start!=i-1){
                sb.append("->");
                sb.append(Integer.toString(nums[i-1]));
            }
            res.add(sb.toString());
        }
        return res;
    }
}