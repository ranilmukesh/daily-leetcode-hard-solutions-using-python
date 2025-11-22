class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int k=-2;
        int j=0;
        while(k<3){
            map.put(j,k);
            j++;
            k++;
        }
        int sum =0;
        int max = 100;
        for(int l=0;l<nums.length;l++){
            int num = nums[l];
            max = 100;
            for(Integer i: map.keySet()){
                int add = num + map.get(i);
                if(add % 3 == 0){
                    max = Math.min(max,Math.abs(map.get(i)));
                }
            }
            sum +=max;
        }
        return sum;
    }
}
