package io.example;

import io.example.domain.Apple;
import io.example.domain.Currency;
import io.example.domain.Transaction;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface BehaviorParameterization {

    File[] getHiddenFiles(String path);

    List<Apple> filterGreenApples(List<Apple> inventory);

    Map<Currency, List<Transaction>> transactionByCurrency(List<Transaction> transations);
}
