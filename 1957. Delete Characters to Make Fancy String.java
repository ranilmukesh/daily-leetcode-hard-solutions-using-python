class Solution {
    public String makeFancyString(String s) {
        if(s.length() <= 2) {
            return s;
        }
        char currentChar = s.charAt(0);
        int count = 0;
        StringBuilder newString = new StringBuilder();
        for (char character: s.toCharArray()) {
            if (character == currentChar) {
                count++;
                if (count >= 3) {
                    continue;
                } else {
                    newString.append(character);
                }
            } else {
                currentChar = character;
                count = 1;
                newString.append(character);
            }
        }

        return newString.toString();
    }
}
