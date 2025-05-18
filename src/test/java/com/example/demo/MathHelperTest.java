package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.learning.MathHelper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class MathHelperTest {

    @Test
    void testArithmeticTotal() {
        int myFirstNumber = (10 + 11) + (2 * 10); // 41
        int mySecondNumber = 12;
        int myThirdNumber = 6;
        int total = myFirstNumber + mySecondNumber + myThirdNumber;
        assertEquals(59, total);
    }

    @Test
    void testSubtractionFromThousand() {
        int total = 59;
        int result = 1000 - total;
        assertEquals(941, result);
    }

    @Test
    void testMaxIntWithUnderscores() {
        int myMaxIntTest = 2_123_234_232;
        assertEquals(2123234232, myMaxIntTest);
    }

    @Test
    void testTypeCastingToShort() {
        byte myMinByteValue = -128;
        short myNewByteValue = (short) (myMinByteValue / 2); // Should be -64
        assertEquals(-64, myNewByteValue);
    }

    @Test
    void testGetBigNumberList() {
        List<Integer> result = MathHelper.getBigNumberList();

        assertEquals(4, result.size());       // Expecting 4 items
        assertEquals(8, result.get(0));        // First item is 8
        assertEquals(9, result.get(1));        // Second item is 9
        assertNull(result.get(2));             // Third item is null
        assertEquals(11, result.get(3));       // Fourth item is 11
    }

    	
    
    
    @Test
    void testWrapperArrayList() {
        List<Integer> bigNumber = new ArrayList<>();
        bigNumber.add(8);
        bigNumber.add(9);
        bigNumber.add(null);
        bigNumber.add(11);

        assertEquals(4, bigNumber.size());
        assertNull(bigNumber.get(2));
        assertEquals(11, bigNumber.get(3));
    }
}
