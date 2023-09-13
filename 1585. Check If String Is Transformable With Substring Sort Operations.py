class Solution:
    def isTransformable(self, s: str, t: str) -> bool :
        # make a mapping of deque lists called indexes 
        indexes = collections.defaultdict(collections.deque)
        # enumerate s 
        for index, character in enumerate(s) :
            # indexes at the int cast of character has this index added to it  
            indexes[int(character)].append(index)

        # get unique values in t 
        unique_t_values = set([int(t_i) for t_i in t])
        # for t_v in unique t values 
        for t_v in unique_t_values : 
            # if not in indexes 
            if t_v not in indexes :
                # return False as we are missing pieces  
                return False 
        
        # loop over t in order given  
        for character in t : 
            # get the characters integer designation 
            character_designation = int(character)
            # update may cause new misses which may prevent future searches 
            if character_designation not in indexes : 
                return False 
            # for index in range up to character designation 
            for lesser_character in range(character_designation) : 
                # if indexes at lesser character and indexes at lesser character lists 0th item is before indexes at character designations lists 0th item 
                if indexes[lesser_character] and indexes[lesser_character][0] < indexes[character_designation][0] : 
                    # our lists are not transformable, False 
                    # this is because for any select string mapping of character designations that are greater than their sub indexes 
                    # it must be such that the index priors sub mapping does not interfere with the index current mapping. 
                    # this is detailed in the problem statement where they note that values must be in ascending order 
                    return False 
            # after consideration using this most recent index, remove it 
            indexes[character_designation].popleft()
            # if length is now zero, remove it 
            if len(indexes[character_designation]) == 0 : 
                indexes.pop(character_designation)
        
        # if all characters able to sort, return it 
        return True 
