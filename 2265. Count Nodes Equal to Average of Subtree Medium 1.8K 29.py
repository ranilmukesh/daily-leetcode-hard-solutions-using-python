class Solution:
    def helper(self,root,tot):
        # if root==None:
        #     return [0,0]
        if root.left==None and root.right==None:
            tot.append(root.val)
            return [root.val,1]
        cnt=root.val
        parent=root.val
        ele_involved=1
        
        if root.left:
            temp1=self.helper(root.left,tot)
            cnt+=temp1[0]
            ele_involved+=temp1[1]
    
        if root.right:
            temp2=self.helper(root.right,tot)
            ele_involved+=temp2[1]
            cnt+=temp2[0]
        if cnt//ele_involved==parent:
            tot.append(parent)
        return [cnt,ele_involved]
                
    def averageOfSubtree(self, root: Optional[TreeNode]) -> int:
        tot=[]
        self.helper(root,tot)
        print(tot)
        return len(tot)
