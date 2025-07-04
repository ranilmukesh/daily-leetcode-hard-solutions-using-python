class Solution {
    public char kthCharacter(long k, int[] operations) {
        int idx=operations.length-1;
        int ctn=0;
        while(idx>=0){
            int temp=(int)Math.ceil(Math.log(k)/Math.log(2));
            if(temp==idx+1){
                if(operations[idx]==1) ctn++;
                k=k-(long)Math.pow(2,temp-1);
            }
            idx--;
        }
        ctn=ctn%26;
        return (char)('a'+ctn);
    }
}
