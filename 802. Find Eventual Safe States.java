class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v=graph.length;
        // adj 
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<v;i++)
        {
           adj.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int j : graph[i]) {
                adj.get(i).add(j);
            }
        }
       
        int[] visit=new int[v];
        int[] pathVisit=new int[v];

        // check 
        int[] check =new int[v];
        // ans
        List<Integer> ans=new ArrayList<>();
        
        // connection components
        for(int i=0;i<v;i++)
        {
            if(visit[i]!=1)
            {
                dfs(i,visit,pathVisit,check,adj);
            }
        }
        for(int i=0;i<v;i++)
        {
            if(check[i]==1)
            {
                ans.add(i);
            }
        }
        return ans;
    }

    public static boolean dfs(int node,int[] visit,int[] pathVisit,int[] check,ArrayList<ArrayList<Integer>> adj)
    {
        visit[node]=1;
        pathVisit[node]=1;
        check[node]=0;
        // go for the neighbour
        for(int ele: adj.get(node))
        {
            if(visit[ele]!=1)
            {
                
               if(dfs(ele,visit,pathVisit,check,adj)==true)
                {
                    // if the node get a cycle
                    // it cant be the safe node
                
                    return true;
                }
            }
            else if(pathVisit[ele]==1)
            {
                // visited path cycle is obtain
                return true;
            }
        }
        // if all negibours is done means all go to terminal node
        // node neigbours are going to the cycle or lead to cylce
        pathVisit[node]=0;
        check[node]=1;
        return false;
    }
}
