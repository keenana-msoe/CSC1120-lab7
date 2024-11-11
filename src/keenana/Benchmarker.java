/*
 * Course: CSC 1120
 * Term: Spring 2024
 * Assignment: Lab 7
 * Name: Andrew Keenan
 * Created: 2-28-14
 */
package keenana;

/**
 * Benchmarker contians th eman method for the program which takes in the args from the command
 * kine and then feeds them to the List Benchmarker class and method.
 */
public class Benchmarker {
    public static void main(String[] args) {
        ListBenchmark lb = new ListBenchmark();
        final int argslength = 5;
        if (args.length != argslength){
            System.out.println(lb.getHelp());
        }
        String list = args[0];
        String op = args[1];
        String minSize = args[2];
        String multi = args[3];
        String times = args[4];
        int minSize1 = Integer.parseInt(minSize);
        int multi1 = Integer.parseInt(multi);
        int times1 = Integer.parseInt(times);
        long[] data = new ListBenchmark().runBenchmark(list, op, minSize1, multi1, times1);
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (long l : data){
            s.append(String.format("%,d ns : ", l));
        }
        s.append("]");
        System.out.println(s);

    }
}
