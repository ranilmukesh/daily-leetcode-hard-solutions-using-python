
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

        dl = {
            '2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
            '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'
        }

        result = ['']

        for digit in digits:
            letters = dl[digit]
            temp_result = []
            
            for combination in result:
                for letter in letters:
                    temp_result.append(combination + letter)
            
            result = temp_result

        return result
