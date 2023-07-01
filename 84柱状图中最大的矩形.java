class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] arr=new int[heights.length+2];
        System.arraycopy(heights,0,arr,1,heights.length);
        arr[0]=0;
        arr[arr.length-1]=0;
        Stack<Integer> stk=new Stack<>();
        stk.push(0);

        int res=0;

        for(int i=1;i<arr.length;i++){
            while(arr[i]<arr[stk.peek()]){
                int curHeight=arr[stk.pop()];
                int curWidth=i-stk.peek()-1;
                res=Math.max(res,curHeight*curWidth);
                //System.out.println(i+" "+res)
            }
            stk.push(i);
        }
        return res;
    }
}