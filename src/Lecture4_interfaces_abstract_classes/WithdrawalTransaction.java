package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkDepositAmount(int amt) {
        if (amt < 0) {
            return false;
        } else {
            return true;
        }
    }

    // Method to reverse the transaction
    public boolean reverse() {
        return true;
    } // return true if reversal was successful

    // Method to print a transaction receipt or details
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Transaction Date: " + getDate().getTime());
        System.out.println("Transaction Amount: " + getAmount());
    }

    /*
    Oportunity for assignment: implementing different form of withdrawal
     */

//    Implement method overriding in the Derived Classes:
//            – Modify the implementations of  DepositTransaction  and  WithdrawalTransaction classes to override the definition of the  apply()  method inherited from
//    the  BaseTransaction  class.
//            – Ensure to implement specifications for all methods defined in the  BaseTransaction
//    class

    @Override
    public void apply(BankAccount ba) {
        double curr_balance = ba.getBalance();
        if (curr_balance > getAmount()) {
            double new_balance = curr_balance - getAmount();
            ba.setBalance(new_balance);
        }
    }

    /*
    Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
     */
}

