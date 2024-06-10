class Solution {
    public int heightChecker(int[] heights) {
        
        int count = 0;
        
        int expected[] = new int[101];
        for(int height: heights){
            expected[height]++;
        }
        
        int expectedIndex = 1, index = 0;
        while(expectedIndex < 101){
            if(expected[expectedIndex] == 0){
                expectedIndex++;
                continue;
            } else{
                if(heights[index] != expectedIndex)
                    count++;
                expected[expectedIndex]--;
                index++;
                
            }
        }
        
        
        return count;
        
    }
}
