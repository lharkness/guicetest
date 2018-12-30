package com.leeharkness.guicetest;

import com.google.common.annotations.VisibleForTesting;

import javax.inject.Inject;

/**
 * Represents our service
 */
public class TestService {

    private DataAccessLayer dataAccessLayer;
    @VisibleForTesting
    final static int THRESHOLD = 42;

    /**
     * Initialization ctor
     * @param dataAccessLayer the data access layer
     */
    @Inject
    public TestService(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    /**
     * Our service's raison d'etre
     * @param loadFactor the load factor requested
     * @return small message from data access layer if below our threshold, large if equal to or greater than
     */
    String doWork(int loadFactor) {
        if (loadFactor < THRESHOLD) {
            return dataAccessLayer.getSmallMessage();
        }
        else {
            return dataAccessLayer.getLargeMessage();
        }
    }
}
