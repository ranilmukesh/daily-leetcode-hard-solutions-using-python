class LRUCache:

    def __init__(self, capacity: int):
        self.capa = capacity
        self.dic = {}

    def get(self, key: int) -> int:
        if key in self.dic:
            # reuse cache and reorder
            temp = self.dic[key]
            del self.dic[key]
            self.dic[key] = temp
            return temp
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        
        if key in self.dic:
            # update the value in existing key
            del self.dic[key]
            self.dic[key] = value
        else:
            # add the new value to dic
            if len(self.dic) == self.capa:
                for firstKey in self.dic.keys(): # dic.keys() is O(1) in python 3. However, dic.keys() is O(n) in python2. So it's fine in our cause 
                    del self.dic[firstKey]
                    break
            self.dic[key] = value
        
