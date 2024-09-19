import java.util.*;
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {


        ArrayList<Integer> list = new ArrayList<>();

        if(!expression.contains("-") && !expression.contains("+") && !expression.contains("*")){
            list.add(Integer.parseInt(expression));
            return list;
        }

        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);


            if(ch == '-' || ch == '+' || ch == '*'){

                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftRec = diffWaysToCompute(left);
                List<Integer> rightRec = diffWaysToCompute(right);

                for(int j = 0; j < leftRec.size(); j++){

                    int leftchar = leftRec.get(j);


                    for(int k = 0; k < rightRec.size(); k++){

                        int rightchar = rightRec.get(k);

                        if(ch == '-'){ 

                            list.add(leftchar - rightchar);
                        }

                        if(ch == '+'){

                            list.add(leftchar + rightchar);
                        }

                        if(ch == '*'){
                            list.add(leftchar * rightchar);
                        }
                        

                    }
                }
            }
        }

        return list;


    }
}
