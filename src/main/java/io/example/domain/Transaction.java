package io.example.domain;

public class Transaction {
    private int price;
    private Currency currency;

    public Transaction(Currency currency,int price){
        this.price = price;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getPrice(){
        return price;
    }
}
