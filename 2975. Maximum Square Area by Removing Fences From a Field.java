class Solution {
    final long mod = 1000000007L;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        if(Math.max(m, n)<2000000)return solveBool(m, n, hFences, vFences);
        int[] h = new int[hFences.length+2];
        int[] v = new int[vFences.length+2];

        Set<Integer> diffs = new HashSet<>();

        h[0]=1;v[0]=1;
        h[h.length-1]=m;v[v.length-1]=n;

        System.arraycopy(hFences, 0, h, 1, hFences.length);
        System.arraycopy(vFences, 0, v, 1, vFences.length);

        Arrays.sort(h);
        Arrays.sort(v);
        
        for(int i = 0; i < h.length; i++){
            for(int j = i+1; j < h.length; j++){
                diffs.add(h[j]-h[i]);
            }
        }

        long max = -1;
        for(int i = 0; i < v.length; i++){
            for(int j = v.length-1; j > i; j--){
                int idx = v[j]-v[i];
                if(diffs.contains(idx))max = Math.max(idx, max);
                if(idx<=max)break;
            }
        }
        if(max==-1)return -1;
        long maybe = max*max;
        return (int)((maybe)%mod);
    }

    public int solveBool(int m, int n, int[] hFences, int[] vFences) {
        int[] h = new int[hFences.length+2];
        int[] v = new int[vFences.length+2];
        boolean[] hv = new boolean[Math.max(m, n)+1];

        h[0]=1;v[0]=1;
        h[h.length-1]=m;v[v.length-1]=n;

        System.arraycopy(hFences, 0, h, 1, hFences.length);
        System.arraycopy(vFences, 0, v, 1, vFences.length);

        Arrays.sort(h);
        Arrays.sort(v);
        
        for(int i = 0; i < h.length; i++){
            for(int j = i+1; j < h.length; j++){
                hv[h[j]-h[i]]=true;
            }
        }

        long max = -1;
        for(int i = 0; i < v.length; i++){
            for(int j = i+1; j < v.length; j++){
                int idx = v[j]-v[i];
                if(hv[idx])max = Math.max(idx, max);
            }
        }
        if(max==-1)return -1;
        return (int)((max*max)%mod);
    }
}
