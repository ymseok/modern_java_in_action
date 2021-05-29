package io.example;

import org.junit.jupiter.api.Test;

import static io.example.BehaviorParameterizationFactory.TYPE.MODERN;
import static io.example.BehaviorParameterizationFactory.TYPE.TRADITIONAL;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Arrays;

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

}
