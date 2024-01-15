class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        loss_count = {}
        
        for winner, loser in matches:
            if winner not in loss_count:
                loss_count[winner] = 0

            if loser in loss_count:
                loss_count[loser] += 1
            else:
                loss_count[loser] = 1
                
        zero_loss = []
        one_loss = []
        
        for player, losses in loss_count.items():
            if losses == 0:
                zero_loss.append(player)
            elif losses == 1:
                one_loss.append(player)
                
        return [sorted(zero_loss), sorted(one_loss)]
