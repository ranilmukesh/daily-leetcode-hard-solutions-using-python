class Solution:
  def isValid(self, code: str) -> bool:
    if code[0] != '<' or code[-1] != '>':
      return False
    containsTag = False  # Flag to check if code contains a tag
    stack = []  # Stack to keep track of tags

    def isValidCdata(s: str) -> bool:  # Check if a given string is valid CDATA
        return s.find('[CDATA[') == 0

    def isValidTagName(tagName: str, isEndTag: bool) -> bool:  # Check if a given tag name is valid
        nonlocal containsTag
        if not tagName or len(tagName) > 9:  # Check tag name length
            return False
        if any(not c.isupper() for c in tagName):  # Check if all characters in tag name are uppercase
            return False

        if isEndTag:  # Check if end tag is valid
            return stack and stack.pop() == tagName

        containsTag = True  # Set flag to True
        stack.append(tagName)  # Push tag to stack
        return True

    i = 0
    while i < len(code):
        if not stack and containsTag:  # If stack is empty but code contains a tag, return False
            return False
        if code[i] == '<':
            if stack and code[i + 1] == '!':  # Check if CDATA
                closeIndex = code.find(']]>', i + 2)
                if closeIndex == -1 or not isValidCdata(code[i + 2:closeIndex]):  # Check if CDATA is valid
                    return False
            elif code[i + 1] == '/':  # Check if end tag
                closeIndex = code.find('>', i + 2)
                if closeIndex == -1 or not isValidTagName(code[i + 2:closeIndex], True):  # Check if end tag is valid
                    return False
            else:  # Check if start tag
                closeIndex = code.find('>', i + 1)
                if closeIndex == -1 or not isValidTagName(code[i + 1:closeIndex], False):  # Check if start tag is valid
                    return False
            i = closeIndex  # Set index to end of tag
        i += 1

    return not stack and containsTag  # Check if stack is empty and code contains a tag
