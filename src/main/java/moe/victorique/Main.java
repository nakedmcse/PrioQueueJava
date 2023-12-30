package moe.victorique;

import com.google.common.base.Stopwatch;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Main {

  private static final int range = 10000000;

  public static void main(String[] args) {
    var testOut = new StringBuilder();
    var simplePrio = new PriorityQueue<Pair<Integer, Integer>>(range, (x, y) -> Integer.compare(y.getRight(), x.getRight()));
    System.out.println("Priority Enqueued 1:1,2:1,3:1,4:5,5:9");
    simplePrio.add(Pair.of(1, 1));
    simplePrio.add(Pair.of(2, 1));
    simplePrio.add(Pair.of(3, 1));
    simplePrio.add(Pair.of(4, 5));
    simplePrio.add(Pair.of(5, 9));
    while (!simplePrio.isEmpty()) {
      testOut.append(" ").append(simplePrio.poll());
    }
    System.out.println("Simple Priority Queue Dequeued: " + testOut);
    List<Pair<Integer, Integer>> pairs = IntStream.range(0, range)
        .mapToObj(i -> Pair.of((int) (Math.random() * range), (int) (Math.floor(Math.random() * 9) + 1)))
        .toList();
    var stopwatch = Stopwatch.createStarted();
    for (var pair : pairs) {
      simplePrio.add(pair);
    }
    stopwatch.stop();
    System.out.println("Simple Priority queue enqueue time: " + stopwatch);
    stopwatch.reset();
    var count = 0;
    stopwatch.start();
    while (!simplePrio.isEmpty()) {
      simplePrio.poll();
      count++;
    }
    stopwatch.stop();
    System.out.println("Simple priority queue dequeued items: " + count);
    System.out.println("Simple priority queue dequeue time: " + stopwatch);
    System.out.println("-----");
  }
}
