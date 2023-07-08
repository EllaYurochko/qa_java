package com.exemple;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    @Mock
    private Feline feline;

    @Before
    public void setMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name = "{index}: {0}-{1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{{1, 1}, {2, 2}});
    }

    @Parameterized.Parameter(0)
    public int number;

    @Parameterized.Parameter(1)
    public int result;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(number);
        Assert.assertEquals(result, lion.getKittens());
    }
}

