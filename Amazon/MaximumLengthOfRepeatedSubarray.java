class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int max =0;
        int matrix [][] = new int[nums1.length +1][nums2.length+1];
    
        // if we get equal values (nums1[i] == nums[j]) then check i-1 and j-1 and add matrix[i-1][j-1] value to current i and j
        // matrix index and finally traverse once again through the matrix and get the largest number and 
        // return it.
        for(int i=0;i<matrix.length ;i++ )
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(i==0)
                matrix[0][j]=0;
                
                if(j==0)
                matrix[i][0]=0;
                
                if(i>=1 && j>=1 && nums1[i-1] == nums2[j-1])
                {
                    matrix[i][j]= matrix[i-1][j-1] +1;
                }
                
            }
        }
        // checking for max value in the matrix 
        for(int [] arr :matrix)
        {
            for(int nums : arr)
               max = Math.max(max,nums);
        }
        
        return max;
    }
}