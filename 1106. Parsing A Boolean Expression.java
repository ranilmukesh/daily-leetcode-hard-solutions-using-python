class Solution {
    private static interface BooleanBinaryOperator {
        boolean applyAsBoolean(boolean left, boolean right);
    };
    private static BooleanBinaryOperator conjunction = Boolean::logicalAnd;
    private static BooleanBinaryOperator disjunction = Boolean::logicalOr;
    private String s;
    private int pos=0;
    public boolean parseBoolExpr(String expression) {
        this.s = expression;
        pos=0;
        return expression();
    }
    private boolean expression(){
        boolean res=false; 
        switch (s.charAt(pos++)){
            case 't':
                return true;
            case 'f':
                return false;
            case '!':
               pos++; //( idhukuu
               res = !expression();
               pos++; //) 
               return res;
            case '&':
                pos++; // (
                res= expressionList(conjunction);
                pos++; //) 
                return res;
            case '|':
                pos++; // (
                res= expressionList(disjunction);
                pos++; //) 
                return res;
            default:
                throw new RuntimeException("found "+s.charAt(pos-1));
        }
    }    
    private boolean expressionList(BooleanBinaryOperator oper){
        boolean res= expression();
        while (s.charAt(pos++)==',')
            res = oper.applyAsBoolean(res,expression()); 
        pos--;
        return res;
    }
}
