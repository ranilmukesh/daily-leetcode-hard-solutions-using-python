class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        vowels = set('aeiouAEIOU')

        length = len(s)
        mid_point = length // 2

        first_half = s[:mid_point]
        second_half = s[mid_point:]

        count_vowels_first = sum(1 for char in first_half if char in vowels)
        count_vowels_second = sum(1 for char in second_half if char in vowels)

        return count_vowels_first == count_vowels_second
