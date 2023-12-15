def destCity(self, paths: List[List[str]]) -> str:
        start=set()
        destination=set()
        for city in paths:
            start.add(city[0])
            destination.add(city[1])
        return destination.difference(start).pop()
