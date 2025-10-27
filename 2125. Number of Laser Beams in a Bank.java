class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        
        curr=bank[0].count("1")
        beams=0
        for row in bank[1:]:
            devices=row.count("1")
            if not devices:
                continue
            beams+=devices*curr
            curr=devices
        return beams
