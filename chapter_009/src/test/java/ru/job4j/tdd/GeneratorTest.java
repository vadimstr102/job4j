package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GeneratorTest {

    @Test
    @Ignore
    public void produceWhenNormal() {
        Generator generator = new SimpleGenerator();
        Map<String, String> args = Map.of("${name}", "Ivan Ivanov", "${subject}", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String result = generator.produce(template, args);
        assertEquals(result, "I am a Ivan Ivanov, Who are you?");
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void produceWhenUnknownArgument() {
        Generator generator = new SimpleGenerator();
        Map<String, String> args = Map.of("${last_name}", "Ivan Ivanov", "${subject}", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String result = generator.produce(template, args);
        assertEquals(result, "I am a Ivan Ivanov, Who are you?");
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void produceWhenRedundantArgument() {
        Generator generator = new SimpleGenerator();
        Map<String, String> args = Map.of("${name}", "Ivan", "${last_name}", "Ivanov", "${subject}", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String result = generator.produce(template, args);
        assertEquals(result, "I am a Ivan, Who are you?");
    }
}
