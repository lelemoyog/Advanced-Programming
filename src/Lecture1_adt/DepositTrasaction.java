package Lecture1_adt;

import Lecture4_interfaces_abstract_classes.BankAccount;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DepositTrasaction extends BaseTransaction {
    public DepositTrasaction(double amount, @NotNull Calendar date){
        super(amount, date);
    }
    private boolean checkDepositAmount(int amt){
        if (amt < 0){
           return false;
        }
        else{
            return  true;
        }
    }

    // Method to print a transaction receipt or details
    public void printTransactionDetails(){
        System.out.println("Transaction ID: "+getTransactionID());
        System.out.println("Transaction Date: "+getDate().getTime());
        System.out.println("Transaction Amount: "+getAmount());
    }

//    Implement method overriding in the Derived Classes:
//            – Modify the implementations of  DepositTransaction  and  WithdrawalTransaction classes to override the definition of the  apply()  method inherited from
//    the  BaseTransaction  class.
//            – Ensure to implement specifications for all methods defined in the  BaseTransaction
//    class

    @Override
    public void apply(BankAccount ba){
        double curr_balance = ba.getBalance();
        double new_balance = curr_balance + getAmount();
        ba.setBalance(new_balance);
    }
}
