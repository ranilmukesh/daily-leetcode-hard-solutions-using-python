class SeatManager:

    def __init__(self, n: int):
        self.heap = [i for i in range(1,n+1)]
        heapq.heapify(self.heap)

    def reserve(self) -> int:
        return heapq.heappop(self.heap)

    def unreserve(self, seatNumber: int) -> None:
        heapq.heappush(self.heap , seatNumber)
