def make_gen(nestedList: [NestedInteger]):
    for elem in nestedList:
        if elem.isInteger():
            yield elem.getInteger()
        else:
            for sub_elem in make_gen(elem.getList()):
                yield sub_elem

class NestedIterator:
    def __init__(self, nestedList: [NestedInteger]):
        self.gen = make_gen(nestedList)
        try:
            self.cur = next(self.gen)
        except:
            self.cur = None
    
    def next(self) -> int:
        result = self.cur
        try:
            self.cur = next(self.gen)
        except:
            self.cur = None
        return result
    
    def hasNext(self) -> bool:
        return self.cur is not None
