package Bank;

import Exceptions.HaveNotEnoughMoneyException;

public class BankTransaction {


    public void transaction(double amount,BankAccount bankAccount){
        try{
            if(bankAccount.getBalance()>=amount){
                bankAccount.setBalance(bankAccount.getBalance()-amount);
            }else{
                throw new HaveNotEnoughMoneyException();
            }
        }catch (HaveNotEnoughMoneyException e){
            e.getMessage();
        }
    }
    public void buytransaction(double amount,BankAccount bankAccount){
        try{
            if(bankAccount.getBalance()>=amount){
                bankAccount.setBalance(bankAccount.getBalance()+amount);
            }else{
                throw new HaveNotEnoughMoneyException();
            }
        }catch (HaveNotEnoughMoneyException e){
            e.getMessage();
        }
    }
}