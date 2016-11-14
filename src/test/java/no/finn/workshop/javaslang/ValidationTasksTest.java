package no.finn.workshop.javaslang;

import javaslang.collection.List;
import javaslang.control.Validation;
import no.finn.workshop.javaslang.things.Ad;
import org.junit.Test;

import static no.finn.workshop.javaslang.LambdaAssert.assertTrue;

public class ValidationTasksTest {

    @Test
    public void should_validate_valid_parameters_to_ad() {
        Validation<List<String>, Ad> ads = ValidationTasks.validateAd(1234L, "yo dude", 4321L);
        assertTrue(ads, Validation::isValid, "Expected valid validation object from adID 1234, text 'yo dude' and userID 4321");
    }

    @Test
    public void should_invalidate_invalid_parameters_to_ad() {
        Validation<List<String>, Ad> ads = ValidationTasks.validateAd(0L, "", -2L);
        assertTrue(ads, Validation::isInvalid, "Expected invalid validation object from adID 0, text (blank) and userID -5");
        assertTrue(ads, v -> v.getError().length() == 3, "Expected 4 errors to accumulate from adID null, text (blank) and userID -5, but was " + ads.getError().length());
    }

}