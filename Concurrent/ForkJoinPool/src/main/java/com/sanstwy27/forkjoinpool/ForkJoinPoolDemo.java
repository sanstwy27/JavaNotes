package com.sanstwy27.forkjoinpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * -- Fork/Join --
 *
 * ForkJoinPool
 * ForkJoinTask
 * RecursiveTask
 *
 */
public class ForkJoinPoolDemo {

    static class ForkJoinTask extends RecursiveTask<Integer> {
        private static final int MIN_VALUE = 10;

        private int result;
        private int begin;
        private int end;

        public ForkJoinTask(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - begin <= MIN_VALUE) {
                for (int i = begin; i <= end; ++i) {
                    result += i;
                }
            } else {
                int middle = (begin + end) >> 1;

                ForkJoinTask forkJoinTask1 = new ForkJoinTask(begin, middle);
                ForkJoinTask forkJoinTask2 = new ForkJoinTask(middle + 1, end);
                forkJoinTask1.fork();
                forkJoinTask2.fork();

                result = forkJoinTask1.join() + forkJoinTask2.join();
            }
            return result;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask forkJoinTask = new ForkJoinTask(0,100);
        forkJoinPool.submit(forkJoinTask);

        System.out.println(forkJoinTask.get());

        forkJoinPool.shutdown();
    }
}
