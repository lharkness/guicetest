package com.leeharkness.guicetest;

import com.google.common.annotations.VisibleForTesting;

/**
 * Our window into the data access layer
 */
class DataAccessLayer {
    @VisibleForTesting
    static final String SMALL_MESSAGE = "Small Message";
    @VisibleForTesting
    static final String LARGE_MESSAGE = "Large Message";

    /**
     * retrieves a small message
     * @return the small message
     */
    String getSmallMessage() {
        return SMALL_MESSAGE;
    }

    /**
     * retrieves a large message
     * @return the large message
     */
    String getLargeMessage() {
        return LARGE_MESSAGE;
    }
}
