class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:

        def get_word(curr_str):
            str_list = list()
            n = len(curr_str)
            for each_char in curr_str:
                if each_char == '#':
                    if len(str_list)>0:
                        _ = str_list.pop()
                    else:
                        pass
                else:
                    str_list.append(each_char)
            
            return "".join(str_list)

        word_s = get_word(s)
        word_t = get_word(t)

        return word_s == word_t
