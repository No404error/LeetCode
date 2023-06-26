class Solution {
    class Queue{
        private LinkedList<Integer> list=new LinkedList<>();

        public void push(int val){
            while(!list.isEmpty()&&list.getLast()<val)
                list.pollLast();
            list.addLast(val);
        }

        public int getMax(){
            return list.getFirst();
        }
        
        public void pop(int val){
            if(getMax()==val)
                list.pollFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue window=new Queue();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i<k-1)
                window.push(nums[i]);
            else{
                window.push(nums[i]);
                res.add(window.getMax());
                window.pop(nums[i-k+1]);
            }
        }
        int[] arr=new int[res.size()];
        for(int i=0;i<arr.length;i++)
            arr[i]=res.get(i);
        return arr;
    }
}