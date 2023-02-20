class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for(int row=0; row<m; row++){
            if(m-row >= 3){
                for(int col=1; col<n; col++){
                    if(n-col >= 2){
                        int temp = (grid[row][col-1] + grid[row][col] + grid[row][col+1]) + 
                            (grid[row+1][col]) + 
                            (grid[row+2][col-1] + grid[row+2][col] + grid[row+2][col+1]);
                        
                        ans = Math.max(temp, ans);
                    } else{
                        break;
                    }
                }
            } else{
                break;
            }
        }

        return ans;
    }
}