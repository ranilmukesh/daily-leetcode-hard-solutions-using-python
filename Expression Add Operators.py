# # iven a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

# # Note that operands in the returned expressions should not contain leading zeros.

# Example 1:

# Input: num = "123", target = 6
# Output: ["1*2*3","1+2+3"]
# Explanation: Both "1*2*3" and "1+2+3" evaluate to 6

class Solution:
    def addOperators(self, s: str, target: int) -> List[str]:
        # need to traverse through s
        # backtrack each case of  start index and then +,*,-
        # need empty array ofcourse
        # need curidx = i
        # need the str path to append to the arr if my --> cur_num == target
        # need the prevNum access for multiplication
        # 1 2 3 4 5 --> 1 + 2 + 3 + 4 * 5
        #               ^ ^ ^ ^ ^ ^ ^ == 10 but we wanna do 4*5 so ---
        # just do 1 + 2 + 3 + 4 + (- 4) + (4 * 5)
        # return ans
        
        res = []

        def dfs(i, path, cur_num, prevNum):
            if i == len(s):
                if cur_num == target:
                    res.append(path)
                return
            
            for j in range(i, len(s)):
                # starting with zero?
                if j > i and s[i] == '0':
                    break
                num = int(s[i:j+1])

                # if cur index is 0 then simple add that number
                if i == 0:
                    dfs(j + 1, path + str(num), cur_num + num, num)
                else:
                    dfs(j + 1, path + "+" + str(num), cur_num + num, num)
                    dfs(j + 1, path + "-" + str(num), cur_num - num, -num)
                    dfs(j + 1, path + "*" + str(num), cur_num - prevNum + prevNum * num, prevNum * num)
        
        dfs(0, "", 0, 0)
        return res
        
