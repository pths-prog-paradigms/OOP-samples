package org.ldemetrios.oop.structure;

import kotlin.collections.CollectionsKt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        List<Long> list = LongStream.iterate(0, (i) -> i + 1).takeWhile((i) -> i < 100).mapToObj(Long::valueOf).collect(Collectors.toList());
System.out.println(        CollectionsKt.takeWhile(
                CollectionsKt.map(
                        CollectionsKt.filter(list, (it) -> it % 6 == 0),
                        (it) -> it * it
                ),
                (it) -> it < 1000
        ));
    }
}
