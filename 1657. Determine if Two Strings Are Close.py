class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        if(len(word1)!=len(word2)):return False
        c=0
        dic1={}
        dic2={}
        for i in word1:
            if i not in word2:
                return False
            elif i not in dic1:
                dic1[i]=1
            else:
                dic1[i]+=1
        for i in word2:
            if i not in word1:
                return False
            elif i not in dic2:
                dic2[i]=1
            else:
                dic2[i]+=1
        dic1=dict(sorted(dic1.items(), key=lambda item: item[1]))
        dic2=dict(sorted(dic2.items(), key=lambda item: item[1]))
        l1=list(dic1.values())
        l2=list(dic2.values())
        if(l1!=l2):
            print(l1,l2)
            return False
        return True
