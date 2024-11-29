package Lecture1_adt;

import Lecture4_interfaces_abstract_classes.BankAccount;
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
    public void apply(BankAccount ba) throws InsufficientFundsException {
        double curr_balance = ba.getBalance();
        if (curr_balance >= getAmount()) {
            double new_balance = curr_balance - getAmount();
          //  ba.setBalance(new_balance);
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
    }

    // Overloaded apply method with additional checks and exception handling
    public void apply(BankAccount ba, boolean checkBalance) {
        double curr_balance = ba.getBalance();
        try {
            if (curr_balance > 0 && curr_balance < getAmount()) {
                double amountNotWithdrawn = curr_balance - getAmount();
                ba.setBalance(amountNotWithdrawn);
                System.out.println("Partial withdrawal. Amount not withdrawn: " + amountNotWithdrawn);
            } else if (curr_balance >= getAmount()) {
                double new_balance = curr_balance - getAmount();
                ba.setBalance(new_balance);
            } else {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
            System.out.println("Current balance: " + ba.getBalance());
        }
    }

    /*
    Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
     */

//    Implement the  reverse():    boolean  method to reverse a  WithdrawalTransaction . This method ensures that the balance in the   BankAccount   object that the transaction was initially applied to is restored to it’s original amount.
//    –   The method should return a boolean value indicating whether the reversal was successful or not.

    public boolean reverse(BankAccount ba) {
        double curr_balance = ba.getBalance();
        //console log the curr_balance
        System.out.println("Current balance: " + curr_balance);
        double new_balance = curr_balance + getAmount();
        ba.setBalance(new_balance);
        return true;
    }
}

