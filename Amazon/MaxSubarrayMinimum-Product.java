class Solution {
    long MOD = 1000000007;
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] sum = new long[n+1];//key point
        sum[0] = nums[0];
        //prefix sum
        for(int i =1;i<n+1;i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
        
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        for(int i = n-1;i>=0;i--){//find the nearst right element which is smaller than nums[i]
            while(!rightStack.isEmpty() && nums[rightStack.peek()] >= nums[i])
                rightStack.pop();
            
            right[i] = rightStack.isEmpty()? n-1:rightStack.peek()-1;
            rightStack.push(i);
        }
        
        for(int i = 0;i<n;i++){//find the nearst left element which is smaller than nums[i]
            while(!leftStack.isEmpty() && nums[leftStack.peek()] >= nums[i])
                leftStack.pop();
            
            left[i] = leftStack.isEmpty()? 0:leftStack.peek()+1;
            leftStack.push(i);
        }
        
        long res = 0;
        for(int i = 0; i<n;i++){
            res = Math.max(res,nums[i]*(sum[right[i]+1]-sum[left[i]]));
        }
        
        return (int)(res % MOD);
    }
}