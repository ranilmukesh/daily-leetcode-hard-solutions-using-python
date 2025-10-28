class Solution {
    public int countValidSelections(int[] nums) {
        int leftSum=0;
        int rightSum=0;
        int validChoice=0;

        for(int i : nums){
            rightSum +=i;
        }
        for(int i:nums){
            if(i==0 ){
                if(leftSum==rightSum)
                    validChoice +=2;
                if(Math.abs(leftSum-rightSum)==1){
                    validChoice++;
                }
            }
            else{
                leftSum+=i;
                rightSum-=i;
            }
        }
        return validChoice;
    }
}
