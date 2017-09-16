package de.pixelgerecht.kata.gameoflife;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PatternsTest {
    private final String name;
    private final Grid actual;
    private final Grid expected;

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {
                                "block",
                                new Patterns().block(),
                                Grid.of(new boolean[][]{
                                        {false, false, false, false},
                                        {false, true, true, false},
                                        {false, true, true, false},
                                        {false, false, false, false},
                                })
                        },
                        {
                                "boat",
                                new Patterns().boat(),
                                Grid.of(new boolean[][]{
                                        {false, false, false, false, false},
                                        {false, true, true, false, false},
                                        {false, true, false, true, false},
                                        {false, false, true, false, false},
                                        {false, false, false, false, false},
                                })
                        },
                        {
                                "tub",
                                new Patterns().tub(),
                                Grid.of(new boolean[][]{
                                        {false, false, false, false, false},
                                        {false, false, true, false, false},
                                        {false, true, false, true, false},
                                        {false, false, true, false, false},
                                        {false, false, false, false, false},
                                })
                        },
                        {
                                "Blinker (period 1)",
                                new Patterns().blinker1(),
                                Grid.of(new boolean[][]{
                                        {false, false, false, false, false},
                                        {false, false, false, false, false},
                                        {false, true, true, true, false},
                                        {false, false, false, false, false},
                                        {false, false, false, false, false},
                                })
                        },
                        {
                                "Blinker (period 2)",
                                new Patterns().blinker2(),
                                Grid.of(new boolean[][]{
                                        {false, false, false, false, false},
                                        {false, false, true, false, false},
                                        {false, false, true, false, false},
                                        {false, false, true, false, false},
                                        {false, false, false, false, false},
                                })
                        },
                        {
                                "Toad (period 1)",
                                new Patterns().toad1(),
                                Grid.of(new boolean[][]{
                                        {false, false, false, false, false, false},
                                        {false, false, false, false, false, false},
                                        {false, false, true, true, true, false},
                                        {false, true, true, true, false, false},
                                        {false, false, false, false, false, false},
                                        {false, false, false, false, false, false},
                                })
                        },
                        {
                                "Toad (period 2)",
                                new Patterns().toad2(),
                                Grid.of(new boolean[][]{
                                        {false, false, false, false, false, false},
                                        {false, false, false, true, false, false},
                                        {false, true, false, false, true, false},
                                        {false, true, false, false, true, false},
                                        {false, false, true, false, false, false},
                                        {false, false, false, false, false, false},
                                })
                        },
                        {
                                "Beacon (period 1)",
                                new Patterns().beacon1(),
                                Grid.of(new boolean[][]{
                                        {false, false, false, false, false, false},
                                        {false, true, true, false, false, false},
                                        {false, true, false, false, false, false},
                                        {false, false, false, false, true, false},
                                        {false, false, false, true, true, false},
                                        {false, false, false, false, false, false},
                                })
                        },
                        {
                                "Beacon (period 2)",
                                new Patterns().beacon2(),
                                Grid.of(new boolean[][]{
                                        {false, false, false, false, false, false},
                                        {false, true, true, false, false, false},
                                        {false, true, true, false, false, false},
                                        {false, false, false, true, true, false},
                                        {false, false, false, true, true, false},
                                        {false, false, false, false, false, false},
                                })
                        },

                }
        );
    }

    public PatternsTest(String name, Grid actual, Grid expected) {
        this.name = name;
        this.actual = actual;
        this.expected = expected;
    }

    @Test
    public void createsPattern() throws Exception {
        assertThat("Unexpected result creating " + name, actual, equalTo(expected));
    }
}
