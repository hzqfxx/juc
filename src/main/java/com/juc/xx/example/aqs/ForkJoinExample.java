package com.juc.xx.example.aqs;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Integer> {
    public static Integer threadId = 2;
    public int start;
    public int end;

    public ForkJoinExample(int start, int end) {
        this.start = start;
        this.end = end;
    }



    @Override
    protected Integer compute() {
        int sum = 0;

        //如果任务足够小就计算任务
        boolean flag = (end - start) <= threadId;
        if (flag) {
            for (int i = start; i <= end; i++) {
                sum += i;

            }
        } else {
            //如果任务大于阀值,拆分任务
            int middle = (start + end) / 2;
            ForkJoinExample leftTask = new ForkJoinExample(start, middle);
            ForkJoinExample fightTask = new ForkJoinExample(middle + 1, end);

            //执行子任务
            leftTask.fork();
            fightTask.fork();

            //合并子任务
            int leftResult = leftTask.join();
            int fightResult = leftTask.join();

            sum = leftResult + fightResult;
            System.out.println(sum);
        }
        return sum;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinExample task = new ForkJoinExample(1, 100);
        ForkJoinTask<Integer> result = pool.submit(task);
        System.out.println("result : "+  result.get());


    }
}
