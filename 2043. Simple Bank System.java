class Bank {

    long[] balance;

    public Bank(long[] balance) {
        this.balance=balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1-1 > balance.length || account2-1> balance.length)
        {
            return false;
        }
        if(balance[account1-1]>=money)
        {
            balance[account1-1]=balance[account1-1]-money;
            balance[account2-1]=balance[account2-1]+money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(account-1 > balance.length)
        {
            return false;
        }
     balance[account-1]+=money; 
     return true;  
    }
    
    public boolean withdraw(int account, long money) {
        if(account-1 > balance.length)
        {
            return false;
        }
        if(balance[account-1]>=money)
        {
            balance[account-1]-=money;
            return true;
        }
        return false;
    }
}
