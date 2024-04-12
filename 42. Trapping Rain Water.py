class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        total = 0
        for i in range(len(height)):
            while stack and height[i] > height[stack[-1]]:
                top = stack.pop()
                if not stack:
                    break
                left = stack[-1]
                width = i - left - 1
                height_ = min(height[i], height[left]) - height[top]
                total += width * height_
            stack.append(i)
        return total
