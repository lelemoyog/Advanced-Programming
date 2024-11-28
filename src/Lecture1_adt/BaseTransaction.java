package Lecture1_adt;

//Creating a concrete class that implements an interface.
//You will create a class called  BaseTransaction  that implements the  TransactionInterface . The class should have the same fields implemented in the abstract  BaseTransaction
//class. Be careful to implement all the abstract methods defined in the interface.
//Implement the following methods:
//        –   getAmount():    double  - // Method to get the transaction amount
//        –   getDate():    Calendar  - // Method to get the transaction date
//        –   getTransactionID():    String  - // Method to get a unique identifier
//        for the transaction
//Implement common Transaction methods:
//        –   printTransactionDetails():    void  – A method to print out details
//of the transaction.
//–   apply(BankAccount  ba):    void  – A method that applies this transac-
//tion on a Bank account object passed as a parameter. Ensure the implementation of this  apply()  method in the  BaseTransaction  class differs
//substantially from the implementations in both the  DepositTransaction
//        and the  WithdrawalTransaction  classes.
//Implement method overriding in the Derived Classes:
//        – Modify the implementations of  DepositTransaction  and  WithdrawalTransaction classes to override the definition of the  apply()  method inherited from
//the  BaseTransaction  class.
//        – Ensure to implement specifications for all methods defined in the  BaseTransaction
//class

import Lecture4_interfaces_abstract_classes.BankAccount;
import Lecture4_interfaces_abstract_classes.TransactionInterface;

import java.util.Calendar;

public class BaseTransaction implements TransactionInterface {
    private final int amount;
    private final Calendar date;
    private final String transactionID;

    public BaseTransaction(int amount, Calendar date, String transactionID) {
        this.amount = amount;
        this.date = date;
        this.transactionID = transactionID;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Transaction Date: " + date.getTime());
        System.out.println("Transaction Amount: " + amount);
    }

    @Override
    public void apply(BankAccount ba) {
        System.out.println("Applying transaction to bank account");
    }
}
