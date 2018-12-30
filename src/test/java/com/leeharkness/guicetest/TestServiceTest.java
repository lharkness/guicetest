package com.leeharkness.guicetest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static com.leeharkness.guicetest.DataAccessLayer.LARGE_MESSAGE;
import static com.leeharkness.guicetest.DataAccessLayer.SMALL_MESSAGE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class TestServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private DataAccessLayer mockDataAccessLayer;

    @InjectMocks
    private TestService target;

    private static final int SMALL_WORK_UNIT = 1;
    private static final int WORK_UNIT_THRESHOLD = TestService.THRESHOLD;
    private static final int LARGE_WORK_UNIT = TestService.THRESHOLD + 1;

    @Before
    public void setup() {
        when(mockDataAccessLayer.getLargeMessage()).thenReturn(LARGE_MESSAGE);
        when(mockDataAccessLayer.getSmallMessage()).thenReturn(SMALL_MESSAGE);
    }

    @Test
    public void testThatSmallWorkUnitGetsSmallMessage() {
        String result = target.doWork(SMALL_WORK_UNIT);

        assertThat(result, is(SMALL_MESSAGE));
    }

    @Test
    public void testThatLargeWorkUnitGetsLargeMessage() {
        String result = target.doWork(LARGE_WORK_UNIT);

        assertThat(result, is(LARGE_MESSAGE));
    }

    @Test
    public void testThatThresholdWorkUnitGetsLargeMessage() {
        String result = target.doWork(WORK_UNIT_THRESHOLD);

        assertThat(result, is(LARGE_MESSAGE));
    }
}
