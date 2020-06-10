package inputscrubber;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ScrubberTest {

    @Test
    void testChar() {
        Scanner kb = new Scanner(System.in);
        String in1 = "A";
        assertEquals('a', Scrubber.charScrubber(in1, kb));

    }

    @Test
    void testCapsBoolean() {
        Scanner kb = new Scanner(System.in);
        String in2 = "TRUE";
        assertTrue(Scrubber.boolScrubber(in2, kb));
    }

    @Test
    void testNoCapsBoolean() {
        Scanner kb = new Scanner(System.in);
        String in2 = "false";
        assertFalse(Scrubber.boolScrubber(in2, kb));
    }

    @Test
    void testSmallCharBoolean() {
        Scanner kb = new Scanner(System.in);
        String in2 = "t";
        assertTrue(Scrubber.boolScrubber(in2, kb));
    }

    @Test
    void testCapsCharBoolean() {
        Scanner kb = new Scanner(System.in);
        String in2 = "T";
        assertTrue(Scrubber.boolScrubber(in2, kb));
    }


    @Test
    void shortAnswerTwoWordScrubber() {
        Scanner kb = new Scanner(System.in);
        String in2 = "george washington";
        assertArrayEquals(new String[]{"george", "washington"}, Scrubber.shortScrubber(in2, kb));
    }

    @Test
    void shortAnswerOneWordScrubber() {
        Scanner kb = new Scanner(System.in);
        String in2 = "columbus";
        assertArrayEquals(new String[]{"columbus"}, Scrubber.shortScrubber(in2, kb));
    }

    @Test
    void intScrubber() {
        Scanner kb = new Scanner(System.in);
        String in10 = "1492"; //to test normal string composed of integers
        assertEquals(1492, Scrubber.intScrubber(in10, kb));
    }
}