package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    // --- Q1: Addition Tests ---
    
    @Test
    public void testAddition_ValidInput() {
        Assert.assertEquals(5.0, MathQuestionService.q1Addition("2", "3"), 0.001);
    }

    @Test
    public void testAddition_Number1Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("", "3"));
    }

    @Test
    public void testAddition_Number2Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("3", ""));
    }

    @Test
    public void testAddition_BothEmpty() {
        Assert.assertNull(MathQuestionService.q1Addition("", ""));
    }

    @Test
    public void testAddition_InvalidCharacters() {
        Assert.assertNull(MathQuestionService.q1Addition("abc", "2"));
    }

    // --- Q2: Subtraction Tests ---

    @Test
    public void testSubtraction_ValidInput() {
        Assert.assertEquals(1.0, MathQuestionService.q2Subtraction("5", "4"), 0.001);
    }

    @Test
    public void testSubtraction_Number1Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", "2"));
    }

    @Test
    public void testSubtraction_Number2Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("6", ""));
    }

    @Test
    public void testSubtraction_BothEmpty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", ""));
    }

    @Test
    public void testSubtraction_InvalidCharacters() {
        Assert.assertNull(MathQuestionService.q2Subtraction("two", "3"));
    }

    // --- Q3: Multiplication Tests ---

    @Test
    public void testMultiplication_ValidInput() {
        Assert.assertEquals(12.0, MathQuestionService.q3Multiplication("3", "4"), 0.001);
    }

    @Test
    public void testMultiplication_Number1Empty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("", "4"));
    }

    @Test
    public void testMultiplication_Number2Empty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("5", ""));
    }

    @Test
    public void testMultiplication_BothEmpty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("", ""));
    }

    @Test
    public void testMultiplication_InvalidCharacters() {
        Assert.assertNull(MathQuestionService.q3Multiplication("x", "7"));
    }
    @Test
    public void testAddition_WithNegativeNumbers() {
        Assert.assertEquals(-1.0, MathQuestionService.q1Addition("-3", "2"), 0.001);
    }

    @Test
    public void testMultiplication_WithZero() {
        Assert.assertEquals(0.0, MathQuestionService.q3Multiplication("0", "5"), 0.001);
    }

}
