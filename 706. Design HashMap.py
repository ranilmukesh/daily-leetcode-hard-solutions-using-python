class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.buckets = [None] * self.size

    def put(self, key: int, value: int) -> None:
        hash_value = key % self.size
        if self.buckets[hash_value] is None:
            self.buckets[hash_value] = []
        for pair in self.buckets[hash_value]:
            if pair[0] == key:
                pair[1] = value
                return
        self.buckets[hash_value].append([key, value])

    def get(self, key: int) -> int:
        hash_value = key % self.size
        if self.buckets[hash_value] is not None:
            for pair in self.buckets[hash_value]:
                if pair[0] == key:
                    return pair[1]
        return -1

    def remove(self, key: int) -> None:
        hash_value = key % self.size
        if self.buckets[hash_value] is not None:
            for i, pair in enumerate(self.buckets[hash_value]):
                if pair[0] == key:
                    del self.buckets[hash_value][i]
                    return
