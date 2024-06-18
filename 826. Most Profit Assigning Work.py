class Solution {
    public int findMax(int []difficulty){
        int max=0;
        for(int i=0;i<difficulty.length;i++){
            max=Math.max(max,difficulty[i]);
        }
        return max;
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int max=findMax(difficulty);
        int n=difficulty.length;
        int []jobs=new int[max+1];
        for(int i=0;i<n;i++){
            jobs[difficulty[i]]=Math.max(jobs[difficulty[i]],profit[i]);
        }
        for(int i=1;i<jobs.length;i++){
            jobs[i]=Math.max(jobs[i-1],jobs[i]);
        }
        int maxValue=0;
        for(int i=0;i<worker.length;i++){
            if(worker[i]>max){
                maxValue+=jobs[max];
            }else{
                maxValue+=jobs[worker[i]];
            }
        }
        return maxValue; 
    }
}
