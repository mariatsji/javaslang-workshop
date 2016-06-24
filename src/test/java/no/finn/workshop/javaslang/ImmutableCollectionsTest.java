package no.finn.workshop.javaslang;

import java.util.Arrays;

import javaslang.Function1;
import javaslang.collection.List;
import javaslang.collection.Traversable;
import org.junit.Test;

public class ImmutableCollectionsTest {


    @Test
    public void should_create_javaslang_list_from_list() {
        List<Integer> transformed = ImmutableCollections.transform(Arrays.asList(1, 2, 3, 4));
        assertThat(transformed, list -> list != null, "transform should return a javaslang List");
        assertThat(transformed, Traversable::nonEmpty, "transform should return a non-empty javaslang List");
        assertThat(transformed, list -> list.equals(List.of(1, 2, 3, 4)), "transform should return a javaslang List containing 1,2,3,4");
    }

    static <X> void assertThat(X x, Function1<X, Boolean> assertion, String errorMsg) {
        assert assertion.apply(x) : errorMsg;
    }
}
