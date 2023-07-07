class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        t_slots = f_slots = k
        lo = 0
        for hi in range(len(answerKey)):
            if answerKey[hi] == 'T':
                t_slots -= 1
            else:
                f_slots -= 1
            if t_slots < 0 and f_slots < 0:
                if answerKey[lo] == 'T':
                    t_slots += 1
                else:
                    f_slots += 1
                lo += 1
        return hi - lo + 1
