import heapq


class FoodRatings:

    def _init_(self, foods, cuisines, ratings):
        self.foods = {food: -rating for food, rating in zip(foods, ratings)}
        self.ranked_by_cuisine = defaultdict(list)
        for i in range(len(foods)):
            heapq.heappush(self.ranked_by_cuisine[cuisines[i]], (-ratings[i], foods[i]))
        self.cuisines = {food: cuisine for food, cuisine in zip(foods, cuisines)}
        
    def changeRating(self, food, newRating) -> None:
        self.foods[food] = -newRating
        heapq.heappush(self.ranked_by_cuisine[self.cuisines[food]], (-newRating, food))

    def highestRated(self, cuisine) -> str:
        while self.ranked_by_cuisine[cuisine]:
            rank, food = self.ranked_by_cuisine[cuisine][0]
            if rank == self.foods[food]: return food
            heapq.heappop(self.ranked_by_cuisine[cuisine])
