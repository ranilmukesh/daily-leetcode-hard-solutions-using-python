class Solution {
    public int[] closestPrimes(int left, int right) {
        int start=-1;
        int end=-1;
        int num=-1;
        int diff=Integer.MAX_VALUE;
        for(int i=left;i<=right;i++){
            if(i%2==0&&i!=2)
            continue;
            if(isprime(i)){
                if(num==-1){
                    num=i;
                }
                else{
                    if(i-num<diff){
                        diff=i-num;
                        start=num;
                        end=i;
                        if(diff==1||diff==2)
                            return new int[]{start,end};   
                    }
                    num=i;

                }
            }
        }
        return new int[]{start,end};
    }
    public static boolean isprime(int num){
        if(num==1)
        return false;
        if(num==2)
        return true;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)
            return false;
        }
        return true;
    }
}
