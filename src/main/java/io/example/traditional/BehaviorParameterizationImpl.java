package io.example.traditional;

import io.example.BehaviorParameterization;
import io.example.domain.Apple;
import io.example.domain.Color;
import io.example.domain.Currency;
import io.example.domain.Transaction;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BehaviorParameterizationImpl implements BehaviorParameterization {

    public File[] getHiddenFiles(String path){

        File[] hiddenFiles = new File(".").listFiles(new FileFilter(){
            public boolean accept(File file){
                return file.isHidden();
            }
        });
        return hiddenFiles;
    }

    @Override
    public List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory){
            // 해당 구간을 boolean 식을 가지는 Predicate Interface를 이용해서 정의할 수도 있음
            if(Color.GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    @Override
    public Map<Currency, List<Transaction>> transactionByCurrency(List<Transaction> transations) {

        Map<Currency, List<Transaction>> transactionByCurrencies = new HashMap<>();
        for(Transaction transaction : transations){
            if(transaction.getPrice() > 0){
                Currency currency = transaction.getCurrency();
                List<Transaction> transactionForCurrency = transactionByCurrencies.get(currency);
                if(transactionForCurrency == null){
                    transactionForCurrency = new ArrayList<>();
                    transactionByCurrencies.put(currency, transactionForCurrency);
                }
                transactionForCurrency.add(transaction);
            }
        }
        return transactionByCurrencies;
    }


}
