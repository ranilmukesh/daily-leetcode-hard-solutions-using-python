class Solution {

    public int[] queryResults(int limit, int[][] queries) {

          int [] ans = new int[queries.length];
          HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
          HashMap<Integer,Integer> m= new HashMap<Integer,Integer>();

          for(int i=0;i<queries.length;i++){
            if(map.containsKey(queries[i][0]) == false){
               map.put(queries[i][0],queries[i][1]);
               m.put(queries[i][1],m.getOrDefault(queries[i][1],0)+1);
            }
            else{
                int q = map.get(queries[i][0]);
                map.put(queries[i][0],queries[i][1]);
                m.put(q,m.getOrDefault(q,0)-1);
                if(m.getOrDefault(q,0) == 0) m.remove(q);
                m.put(queries[i][1],m.getOrDefault(queries[i][1],0)+1);
            }
            ans[i] = m.size();
          }

          return ans;
    }
}
