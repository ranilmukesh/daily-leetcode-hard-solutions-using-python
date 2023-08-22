class Solution:
    def convertToTitle(self, c: int) -> str:
      return self.convertToTitle((c-1)//26)+"ABCDEFGHIJKLMNOPQRSTUVWXYZ"[(c%26)-1] if c else ""
