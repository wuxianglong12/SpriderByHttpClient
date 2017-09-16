package com.ustc.sse.Crawler;

import java.util.concurrent.BlockingQueue;

public class StoreNews implements  Runnable {
    BlockingQueue<NewsModel> blockingQueue = null;
    NewsModel newsModel =null;
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
