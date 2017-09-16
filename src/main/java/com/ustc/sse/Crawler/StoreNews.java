package com.ustc.sse.Crawler;

import java.util.concurrent.BlockingQueue;

/**
 * @author wangrun
 * @time 2017.9.16
 */

public class StoreNews implements  Runnable {
    BlockingQueue<NewsModel> blockingQueue = null;//由paserNews线程写入的NewsModel
    NewsModel newsModel =null;

    /**
     *
     * 实现数据存储
     * @param Queue
     */
    public StoreNews (BlockingQueue Queue){
        blockingQueue = Queue;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                newsModel = blockingQueue.take();
                String title = newsModel.getTitle();
                String topical = newsModel.getTopical();
                String time = newsModel.getTime();
                String info = newsModel.getInfo();
                System.out.println("title:" + title + "  topical:" + topical + "  info:" + info + "  time:" + time);
                /**
                 *留作数据存储化
                 */

            }
        }
        catch (InterruptedException e ){
            e.printStackTrace();
        }
    }
}
