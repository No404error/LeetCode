import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] twoSum(int[] nums, int target) {
        //return hashFunc(nums,target);
        return ptrFunc(nums,target);
    }

    //采用map储存已经记录过的数字
    public int[] hashFunc(int[] nums, int target){
        HashMap<Integer,Integer> valToIndex=new HashMap<>();
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++){
            int last=target-nums[i];
            //System.out.println(last);
            if(valToIndex.containsKey(last)){
                Integer index = valToIndex.get(last);
                res[0]=index;
                res[1]=i;
                return res;
            }
            valToIndex.put(nums[i],i);
        }
        return null;
    }

    private class Node implements Comparable<Node>{
        public int val;
        public int order;

        @Override
        public int compareTo(Node o) {
            return val-o.val;
        }
    }

    //采用双指针进行查找数对
    public int[] ptrFunc(int[] nums, int target){
        Node[] nodes =new Node[nums.length];
        for(int i=0;i<nums.length;i++){
            Node node=new Node();
            node.val=nums[i];
            node.order=i;
            nodes[i]=node;
        }
        Arrays.sort(nodes);
        int s=0,e=nums.length-1;
        int[] res=new int[2];
        while(s<e){
            int sum=nodes[s].val+nodes[e].val;
            if(sum==target){
                res[0]=nodes[s].order;
                res[1]=nodes[e].order;
                return res;
            }
            else if(sum<target)
                s++;
            else
                e--;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
