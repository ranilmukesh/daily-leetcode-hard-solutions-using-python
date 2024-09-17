class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1=s1.split(" ");
        String[] arr2=s2.split(" ");
        int len=0;
        HashMap<String,Integer> mp=new HashMap<>();
        int c=0;
        for(int i=0;i<arr1.length;i++)
        {

            if(!mp.containsKey(arr1[i]))
            {
                mp.put(arr1[i],1);
            }
            else
            {
                mp.put(arr1[i],mp.get(arr1[i])+1);
            }

        }
        for(int i=0;i<arr2.length;i++)
        {
            if(!mp.containsKey(arr2[i]))
            {
                mp.put(arr2[i],1);
            }
            else
            {
                mp.put(arr2[i],mp.get(arr2[i])+1);
            }

        }
        for(Map.Entry<String,Integer> h:mp.entrySet())
        {
            int v=h.getValue();
            {
                if(v==1)
                {
                    len++;
                }
            }
        }
        String[] arr=new String[len];
        for (Map.Entry<String,Integer> hm : mp.entrySet()) {
            String key =hm.getKey();
            int value = hm.getValue();
            if(value==1)
            {
                arr[c++]=key;
            }

            
        }
        return arr;
        
    }
}
