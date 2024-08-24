class Solution {
    public String nearestPalindromic(String n) {
        int size = n.length(); 
        int mid = size/2;

        long firstHalf = Long.parseLong(n.substring(0, size % 2 == 0 ? mid : mid + 1));
       
        List<Long> possibleResults = new ArrayList<>();
        possibleResults.add(halfToPalindrome(firstHalf, size % 2 == 0));
        possibleResults.add(halfToPalindrome(firstHalf + 1, size % 2 == 0));
        possibleResults.add(halfToPalindrome(firstHalf - 1, size % 2 == 0));
        possibleResults.add((long) Math.pow(10, size - 1) - 1);  // Edge case like 999...
        possibleResults.add((long) Math.pow(10, size) + 1);      // Edge case like 100...001

         long diff = Long.MAX_VALUE;
        long result = 0;
        long original = Long.parseLong(n);
        for(long num:possibleResults)
        {
            if(num==original)
            continue;
            if(Math.abs(num-original)<diff)
            {
                diff = Math.abs(num-original);
                result = num;
            }
            else if(Math.abs(num-original)==diff)
            {
                result = Math.min(result,num);
            }
        }
        return String.valueOf(result);
    }
    long halfToPalindrome(long firstHalf,boolean bool)
    {
        long result = firstHalf;
        if(!bool)
        {
            firstHalf = firstHalf/10;
        }
         while(firstHalf>0)
         {
            int digit = (int)(firstHalf%10);
            result = result*10+digit;
            firstHalf = firstHalf/10;
         }
         return result;
    }
}
