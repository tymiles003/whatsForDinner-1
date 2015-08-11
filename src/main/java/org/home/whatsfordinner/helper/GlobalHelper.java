package org.home.whatsfordinner.helper;

import java.util.LinkedList;
import java.util.List;

public final class GlobalHelper {

    private GlobalHelper() {}

    /**
     * Get the relative complement of 2 lists
     * {1,2,3} \ {2,3,4} = {1}
     * @param a
     * @param b
     * @return the relative complement of a and b
     */
    public static <T extends Object> List<T> getRelativeComplement(final List<T> a, final List<T> b) {
        List<T> result = new LinkedList<>(a);
        result.removeAll(b);
        return result;
    }

}
