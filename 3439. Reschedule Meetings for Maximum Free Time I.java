class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] freeSpace = new int[n+1];
        int prevEnd =0;
        int j = 0;
        for(int i  = 0 ; i < n ; i++){
            freeSpace[j++] = startTime[i] - prevEnd;
            prevEnd = endTime[i];
        }
        freeSpace[j] = eventTime - prevEnd;
        // System.out.println(Arrays.toString(freeSpace));
        int count = 0;
        int left = 0;
        int right = k;
        for(int i  = left ; i < n+1 && i <= right ; i++){
            count+= freeSpace[i];
        }
        // System.out.println("first count = "+ count);
        int maxSpace = count;
        while(right < n){
            int newCount = count - freeSpace[left++] + freeSpace[++right];
            // System.out.println(newCount);
            maxSpace = Math.max(maxSpace , newCount);
            count = newCount;
        }
        return maxSpace;
    }
}
