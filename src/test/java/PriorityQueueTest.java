import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {
    public static Stream<Arguments> getParameters() {
        return Stream.of(
                arguments(new int[]{3,8,6,4},new int[] {4,5,7,9}),
                arguments(new int[]{2,5,3,1},new int[] {1,2,3,5}),
                arguments(new int[]{7,4,6,5},new int[] {4,5,6,7}),
                arguments(new int[]{8,0,3,6},new int[] {0,3,6,8}),
                arguments(new int[]{4,2,8,5},new int[] {2,4,5,8})
        );
    }


    @ParameterizedTest
    @MethodSource("getParameters")
    public void parameterizedTest(int[] input, int[] expected) {
        PriorityQueue pqInput = new PriorityQueue();
        for (int e : input) {
            pqInput.offer(e);
        }
        for (int e : expected) {
            assertEquals(e, pqInput.poll());
        }

    }


    @Test
    public void InitialCapacityTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1, null);
        });
    }

    @Test
    public void OfferTest(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            new PriorityQueue().offer(null);
        });
    }

    @Test
    public void ForEachRemainingTest(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            new PriorityQueue().forEach(null);
        });
    }
}
