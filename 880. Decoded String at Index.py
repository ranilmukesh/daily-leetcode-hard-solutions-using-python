class Solution:
    def decodeAtIndex(self, s: str, k: int) -> str:
        decoded_length = 0  # Initialize the length of the decoded string
        i = 0  # Initialize an index for iterating through the input string

        # Calculate the length of the decoded string until it's greater than or equal to k
        while decoded_length < k:
            if s[i].isdigit():
                # If the current character is a digit, multiply the length by the digit's value
                decoded_length *= int(s[i])
            else:
                # If it's not a digit, increment the length by 1
                decoded_length += 1
            i += 1  # Move to the next character in the input string

        # Backtrack to find the character at index k in the original string
        for j in range(i - 1, -1, -1):
            if s[j].isdigit():
                # If the current character is a digit, divide the length by the digit's value
                decoded_length //= int(s[j])
                k %= decoded_length  # Update k to its relative position in the current substring
            else:
                if k == 0 or k == decoded_length:
                    # If k is 0 or equal to the current length, return the current character
                    return s[j]

                decoded_length -= 1  # Decrement the length for non-digit characters

        return ""  # Default return, should never reach here given problem constraints
