package com.ustc.sse.Crawler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.BlockingQueue;

/**
 * @author wangrun
 * @time 2017.9.16
 */

public class PaserNew implements Runnable{
    private BlockingQueue<String> urlQueue = null;
    private BlockingQueue<NewsModel> resultQueue = null;
    public PaserNew(BlockingQueue<String> urlQueue, BlockingQueue<NewsModel> resultQueue) {
        this.urlQueue = urlQueue;
        this.resultQueue = resultQueue;
    }
    public void run() {
        CrawlerData crawlerData = new CrawlerData();
        while(!Thread.interrupted()){
            try {
                String url = urlQueue.take();
                crawlerData.paser(url,resultQueue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
