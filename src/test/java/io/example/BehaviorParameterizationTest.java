package io.example;

import io.example.domain.Apple;
import io.example.domain.Color;
import io.example.domain.Currency;
import io.example.domain.Transaction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.example.BehaviorParameterizationFactory.TYPE.MODERN;
import static io.example.BehaviorParameterizationFactory.TYPE.TRADITIONAL;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Doc : https://junit.org/junit5/docs/current/user-guide/
 */
public class BehaviorParameterizationTest {

    BehaviorParameterizationFactory.TYPE TEST_TYPE = MODERN;
    BehaviorParameterization bp;

    @BeforeEach
    public void setBehaviorParameterization(){
        bp = BehaviorParameterizationFactory.newBehaviorParameterization(TEST_TYPE);
    }
    @Test
    public void testGetHiddenFiles(){

        File[] hiddenFiles = bp.getHiddenFiles("~");

        Arrays.stream(hiddenFiles).forEach(p -> System.out.println(p.getPath()));
        assertTrue(hiddenFiles.length > 0);
    }

    @Test
    public void testGetGreenApples(){

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(Color.GREEN, 100));
        inventory.add(new Apple(Color.RED, 30));
        inventory.add(new Apple(Color.GREEN, 30));

        List<Apple> result = bp.filterGreenApples(inventory);

        result.forEach(p -> System.out.println(p));
        assertTrue(result.size() > 0);
    }

    @Test
    public void testTransactionByCurrency(){

        List<Transaction> transations = new ArrayList<>();
        transations.add(new Transaction(Currency.KRW, 1000 ));
        transations.add(new Transaction(Currency.USD, 1800 ));
        transations.add(new Transaction(Currency.KRW, 10000 ));

        Map<Currency, List<Transaction>> result = bp.transactionByCurrency(transations);

        result.keySet().forEach(p -> System.out.format("%s = %d개\n", p.name(), result.get(p).size()));

        assertTrue(result.get(Currency.KRW).size() == 2);

    }
}
