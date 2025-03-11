class Solution {
    public int numberOfSubstrings(String s) {
        
        char a[]=s.toCharArray();
        int l=0,r=0,count=0,len=a.length,mcount=0;
        int hash[]=new int[3];
        
        while(r<len){
             if(hash[(int)a[r]-97]==0) count++;
             hash[(int)a[r]-97]++;

             while(count==3){
                mcount+=len-r;
                hash[(int)a[l]-97]--;
                
                if(hash[(int)a[l]-97]==0) count--;
                l++;
             }

             r++;


        }

        return mcount;
    }
}
