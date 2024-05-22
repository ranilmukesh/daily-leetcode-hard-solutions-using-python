class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr=new ArrayList<Integer>();
        List<List<Integer>> ans=new ArrayList<>();

        rec(nums,0,curr,ans);
        return ans;

    }
    public void rec(int [] nums, int i,List<Integer> curr,List<List<Integer>> ans )
    {
        if(i==nums.length)
        {
            ans.add(new ArrayList<Integer>(curr));
            return;
        }

        curr.add(nums[i]);
        rec(nums,i+1,curr,ans);

        curr.remove(curr.size()-1);
        rec(nums,i+1,curr,ans);
    }
}
