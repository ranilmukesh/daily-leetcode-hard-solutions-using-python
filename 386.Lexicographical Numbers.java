class Solution {
    void helper(List<Integer> list,int n,int org){
        if(n> org)return;
        if(n !=0)list.add(n);
        int i=(n==0)?1:0;
        while(i<=9 && n*10+i<=org){
            helper(list,n*10+i,org);
            i++;
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        helper(list,0,n);
        return list;
    }
}
