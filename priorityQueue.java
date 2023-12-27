import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class priorityQueue {

  private static final int range = 10000000;

  public static void main(String[] args) {
    final class prioTuple {
    public int priority;
    public int value;

    public prioTuple(int p, int v) {
        this.priority = p;
        this.value = v;
      }
    }

    var testOut = new StringBuilder();
    var simplePrio = new PriorityQueue<prioTuple>(Comparator.comparingInt(prioTuple -> 0-prioTuple.priority));
    System.out.println("Priority Enqueued 1:1,2:1,3:1,4:5,5:9");
    simplePrio.add(new prioTuple(1, 1));
    simplePrio.add(new prioTuple(1, 2));
    simplePrio.add(new prioTuple(1, 3));
    simplePrio.add(new prioTuple(5, 4));
    simplePrio.add(new prioTuple(9, 5));
    while (!simplePrio.isEmpty()) {
      testOut.append(" ").append(simplePrio.poll().value);
    }
    System.out.println("Simple Priority Queue Dequeued: " + testOut);
    List<prioTuple> pairs = new ArrayList<prioTuple>();
    for (var i = 0; i < range; i++) {
      pairs.add(new prioTuple((int) (Math.random()*9)+1, (int) (Math.random() * range)));
    }
    var stopwatchStarts = Instant.now();
    for (var pair:pairs) {
      simplePrio.add(pair);
    }
    var stopwatchEnds = Instant.now();
    System.out.println("Simple Priority queue enqueue time: " + Duration.between(stopwatchStarts,stopwatchEnds));
    var count = 0;
    stopwatchStarts = Instant.now();
    while (!simplePrio.isEmpty()) {
      simplePrio.poll();
      count++;
    }
    stopwatchEnds =Instant.now();
    System.out.println("Simple priority queue dequeued items: " + count);
    System.out.println("Simple priority queue dequeue time: " + Duration.between(stopwatchStarts,stopwatchEnds));
    System.out.println("-----");
  }
}