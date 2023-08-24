class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        res = []
        i = 0
        while i < len(words):
            j, total_len = i, 0
            while j < len(words) and total_len + len(words[j]) + j - i <= maxWidth:
                total_len += len(words[j])
                j += 1
            if j == len(words):
                res.append(" ".join(words[i:j]) + " " * (maxWidth - total_len - (j - i - 1)))
            else:
                spaces = maxWidth - total_len
                slots = j - i - 1
                if slots == 0:
                    res.append(words[i] + " " * spaces)
                else:
                    spaces_per_slot = spaces // slots
                    extra_spaces = spaces % slots
                    line = words[i]
                    for k in range(i + 1, j):
                        line += " " * (spaces_per_slot + (1 if extra_spaces > 0 else 0))
                        extra_spaces -= 1
                        line += words[k]
                    res.append(line)
            i = j
        return res
