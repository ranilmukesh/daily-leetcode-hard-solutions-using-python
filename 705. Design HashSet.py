class MyHashSet:

    def __init__(self):
        self.l={}

    def add(self, key: int) -> None:
        self.l[key]=1

    def remove(self, key: int) -> None:
        if key in self.l:
            del self.l[key]

    def contains(self, key: int) -> bool:
        return key in self.l
