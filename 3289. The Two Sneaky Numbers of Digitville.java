class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] sneaky = new int[2];
        int[] freq = new int[100];
        int k = 0;

        for(int i : nums) {
            if(freq[i] == 0)
                freq[i]++;
            else {
                sneaky[k] = i;
                k++;
                if(k == 2)
                    return sneaky;
            }
        }
        return sneaky;
    }
}
