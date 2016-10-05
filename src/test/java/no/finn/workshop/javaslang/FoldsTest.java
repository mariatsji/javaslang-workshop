package no.finn.workshop.javaslang;

import javaslang.collection.List;
import org.junit.Test;

import static no.finn.workshop.javaslang.LambdaAssert.assertEquality;

public class FoldsTest {

    @Test
    public void should_sum_a_list_using_fold() {
        Double res = Folds.sumAListUsingFold(List.of(0.2d, 0.1d, -0.3d, 0.75d));
        assertEquality(0.75d, res, Double::equals, "summing a list of doubles should produce correct sum");
    }

    @Test
    public void should_reverse_a_list_using_foldRight() {
        List<Integer> reverse = Folds.reverseRight(List.of(4, 5, 6));
        assertEquality(List.of(6, 5, 4), reverse, List::equals, "reverse should reverse a list using foldRight");
    }

    @Test
    public void should_reverse_a_list_using_foldLeft() {
        List<Integer> reverse = Folds.reverseLeft(List.of(4, 5, 6));
        assertEquality(List.of(6, 5, 4), reverse, List::equals, "reverse should reverse a list using foldLeft");
    }

}