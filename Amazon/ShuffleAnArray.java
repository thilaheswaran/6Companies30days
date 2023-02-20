class Solution {
    private int[] arr;
    private int[] original;

    private Random rand = new Random();

    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            asList.add(arr[i]);
        }
        return asList;
    }

    public Solution(int[] nums) {
        this.arr = nums;
        original = nums.clone();    
    }
    
    public int[] reset() {
        arr = original.clone();
        return arr;
    }
    
    public int[] shuffle() {
        List<Integer> aux = getArrayCopy();

        for (int i = 0; i < arr.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            arr[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */