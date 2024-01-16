import random

class RandomizedSet:

    def __init__(self):
        self.store = set()
        self.randomArr = []

    def insert(self, val: int) -> bool:
        if val in self.store:
            return False
        self.randomArr.append(val)
        self.store.add(val)
        return True

    def remove(self, val: int) -> bool:
        if val in self.store:
            lastVal = self.randomArr[-1]
            lastIdx = self.store[lastVal]
            currIdx = self.store[val]

            self.randomArr[currIdx] = lastVal
            self.store[lastVal] = currIdx

            self.randomArr.pop()
            self.store.remove(val)

            return True
        return False

    def getRandom(self) -> int:
        return random.choice(self.randomArr)
