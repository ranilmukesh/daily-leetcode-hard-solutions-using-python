class Solution {
    public int maximum69Number (int num) {
        if(num<10){
            //if(num==6){
                return 9;
        }
        if(num<100){
            if(num<70){
                return 90+(num%10);
            }
            return 99;
        }
        if(num<1000){
            if(num<700){
                return 900+(num%100);
            }
            if(num%100<70){
                return 990+(num%10);
            }
            return 999;
        }
        else{
            if(num<7000){
                int x = num%1000;
                return 9000+x;
            }
            else if(num%1000<700){
                int x = num%100;
                return 9900+x;
            }
            else if(num%100<70){
                int x = num%10;
                return 9990+x;
            }
            else{
                return 9999;
            }
        }
    }
}
