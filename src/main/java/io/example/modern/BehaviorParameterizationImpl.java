package io.example.modern;

import io.example.BehaviorParameterization;
import io.example.domain.Apple;
import io.example.domain.Color;
import io.example.domain.Currency;
import io.example.domain.Transaction;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class BehaviorParameterizationImpl implements BehaviorParameterization {

    public File[] getHiddenFiles(String path){

        path = path == null ? "." : path;

        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        return hiddenFiles;
    }

    @Override
    public List<Apple> filterGreenApples(List<Apple> inventory) {
        //return inventory.stream().filter(p -> Color.GREEN.equals(p.getColor())).collect(Collectors.toList());
        return inventory.stream().filter(Apple::isGreenApple).collect(Collectors.toList());
    }

    @Override
    public Map<Currency, List<Transaction>> transactionByCurrency(List<Transaction> transations) {

        Map<Currency, List<Transaction>> transactionByCurrencies = new HashMap<>();
        transactionByCurrencies = transations.stream().filter(p -> p.getPrice() > 0).collect(groupingBy(Transaction::getCurrency));

        return transactionByCurrencies;
    }

}
