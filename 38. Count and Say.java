class Solution {
    public String countAndSay(int n) {
    if(n==0) return "";
    if(n==1) return "1";
    if(n==2) return "11";    
    String dummy = "11";
    for(int i = 3;i<=n;i++)
    {
    dummy = currIterationString(dummy); 
    }   
    return dummy;
    }
    public String currIterationString(String s) // 3322251
    {
    StringBuilder a = new StringBuilder();
    int start = 0;
    while(start < s.length())
    {
    int end =  start +1;
    while(end < s.length() && s.charAt(start) == s.charAt(end) )
     end ++ ;    
    a.append(end - start).append(s.charAt(start));
    start = end ;
    }
    return a.toString(); }
    
}
