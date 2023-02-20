class Solution {
    int MOD = 1000000007;
    Map<String, Integer> dp = new HashMap<>();

    public int numberOfWays(int startPos, int endPos, int k) {
        if(Math.abs(endPos-startPos) % 2 != k % 2) return 0;
        return dfs(startPos, endPos, k);
    }

    private int dfs(int startPos, int endPos, int k){
        // base case
        if(startPos==endPos && k==0){
            return 1;
        }
        if(k==0) return 0;

        String key = startPos + "->" + k;
        if(dp.containsKey(key)) return dp.get(key);

        // move backwards
        int res = dfs(startPos-1, endPos, k-1);
        // move forwards
        res += dfs(startPos+1, endPos, k-1);
        res %= MOD;

        dp.put(key, res);
        return res;
    }
}