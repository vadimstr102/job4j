package ru.job4j.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

public class BenchMark {

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 3)
    public void doNothing() {

    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 3)
    public void createObjects() {
        for (int i = 0; i < 100; i++) {
            new Object();
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 3)
    public void createObjectsToVars() {
        for (int i = 0; i < 100; i++) {
            Object object = new Object();
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 3)
    public Object createAndReturnOneObject() {
        return new Object();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 3)
    public Object[] createAndReturnObjects() {
        Object[] objects = new Object[100];
        for (int i = 0; i < 100; i++) {
            objects[i] = new Object();
        }
        return objects;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 3)
    public void createObjectsToBlackHole(Blackhole blackhole) {
        for (int i = 0; i < 100; i++) {
            blackhole.consume(new Object());
        }
    }
}
