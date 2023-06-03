class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int size=nums2.length;
        int[] next=new int[size];
        Stack<Integer> s=new Stack<>();
        for(int i=size-1;i>=0;i--){
            while(!s.isEmpty()&&s.peek()<=nums2[i])
                s.pop();
            next[i]=s.isEmpty()?-1:s.peek();
            s.push(nums2[i]);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<size;i++)
            map.put(nums2[i],next[i]);
        int[] res=new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
            res[i]=map.get(nums1[i]);
        return res;
    }
}