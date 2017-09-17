package de.pixelgerecht.kata.gameoflife.runner;

import de.pixelgerecht.kata.gameoflife.Generation;
import de.pixelgerecht.kata.gameoflife.Grid;
import de.pixelgerecht.kata.gameoflife.Patterns;
import org.junit.After;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class GameOfLifeThreadTest {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final GenerationRenderer renderer = mock(GenerationRenderer.class);
    private final GameOfLifeThread golThread = new GameOfLifeThread(executor, 0, renderer);

    @Test
    public void initiallyNotRunning() throws Exception {
        assertThat(golThread.isRunning(), equalTo(false));
    }

    @Test
    public void canBeStarted() throws Exception {
        golThread.runWith(new Patterns().blinker1());

        assertThat(golThread.isRunning(), equalTo(true));
    }

    @Test
    public void canBeShutdown() throws Exception {
        golThread.runWith(new Patterns().blinker1());

        golThread.shutdown();

        assertThat(golThread.isRunning(), equalTo(false));
    }

    @Test
    public void updatesRenderer() throws Exception {
        ArgumentCaptor<Generation> arguments = ArgumentCaptor.forClass(Generation.class);

        Patterns patterns = new Patterns();

        Grid blinker1 = patterns.blinker1();
        Grid blinker2 = patterns.blinker2();

        golThread.runWith(blinker1);

        Thread.sleep(10); // Should be more than enough for other thread to run twice

        verify(renderer, atLeast(2)).setGeneration(arguments.capture());

        Generation firstCall = arguments.getAllValues().get(0);
        Generation secondCall = arguments.getAllValues().get(1);

        assertThat(firstCall.getGrid(), equalTo(blinker1));
        assertThat(secondCall.getGrid(), equalTo(blinker2));
    }

    @After
    public void tearDown() throws Exception {
        golThread.shutdown();

        if (!executor.isShutdown()) {
            executor.shutdown();
        }
    }
}
