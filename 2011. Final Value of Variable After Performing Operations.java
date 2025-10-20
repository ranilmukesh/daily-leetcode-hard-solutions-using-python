class Solution
{
    public int finalValueAfterOperations(String[] operations)
    {
        int i,l=operations.length,X=0;
        for(i=0;i<l;i++)
        {
            if(operations[i].contains("++"))
            X++;
            else
            X--;
        }
        return X;
    }
}
