package io.example;

import io.example.domain.Apple;
import io.example.domain.Color;
import org.junit.jupiter.api.Test;

import static io.example.BehaviorParameterizationFactory.TYPE.MODERN;
import static io.example.BehaviorParameterizationFactory.TYPE.TRADITIONAL;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Doc : https://junit.org/junit5/docs/current/user-guide/
 */
public class BehaviorParameterizationTest {

    BehaviorParameterizationFactory.TYPE TEST_TYPE = MODERN;

    @Test
    public void testGetHiddenFiles(){

        BehaviorParameterization bp = BehaviorParameterizationFactory.newBehaviorParameterization(TEST_TYPE);
        File[] hiddenFiles = bp.getHiddenFiles("~");

        Arrays.stream(hiddenFiles).forEach(p -> System.out.println(p.getPath()));
        assertTrue(hiddenFiles.length > 0);
    }

    @Test
    public void testGetGreenApples(){

        BehaviorParameterization bp = BehaviorParameterizationFactory.newBehaviorParameterization(TEST_TYPE);

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(Color.GREEN, 100));
        inventory.add(new Apple(Color.RED, 30));
        inventory.add(new Apple(Color.GREEN, 30));

        List<Apple> result = bp.filterGreenApples(inventory);

        result.forEach(p -> System.out.println(p));
        assertTrue(result.size() > 0);
    }
}
