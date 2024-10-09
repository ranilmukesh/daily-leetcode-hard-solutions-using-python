class Solution {
    public int minAddToMakeValid(String s) {
        int noOfParanthesis = 0;
        boolean closingOccured = false;
        int sum = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')
            { 
                if(closingOccured && noOfParanthesis<0)
                {
                    sum += Math.abs(noOfParanthesis);
                    noOfParanthesis = 1;
                    closingOccured = false;
                }
                else
                {
                    noOfParanthesis++;
                }
            }
            else
            {
                noOfParanthesis--;
                closingOccured = true;
            }
        }
        sum += Math.abs(noOfParanthesis);
        return sum;
    }
}
