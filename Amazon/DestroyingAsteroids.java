class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for(int asteroid: asteroids){
            if(asteroid <= m){
                m += asteroid;
            } else{
                return false;
            }
        }

        return true;
    }
}