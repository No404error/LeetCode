class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk=new Stack<>();
        int[] arr=new int[temperatures.length];
        for(int i=arr.length-1;i>=0;i--){
            if(stk.isEmpty())
                arr[i]=0;
            else{
                while(!stk.isEmpty()&&temperatures[stk.peek()]<=temperatures[i])
                    stk.pop();
                if(stk.isEmpty())
                    arr[i]=0;
                else
                    arr[i]=stk.peek()-i;
            }
            stk.push(i);
        }
        return arr;
    }
}