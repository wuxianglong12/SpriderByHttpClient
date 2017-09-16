package com.ustc.sse;

import com.ustc.sse.Crawler.NewsModel;
import com.ustc.sse.Crawler.PaserNew;
import com.ustc.sse.Crawler.StoreNews;

import java.util.concurrent.*;

public class Spider {
    //页面总数
    static final int pageNum = 2363;
    public static void main(String[] args) {

        BlockingQueue<NewsModel> resultQueue = new LinkedBlockingQueue();
        BlockingQueue<String> urlQueue = new LinkedBlockingQueue();
        for(int i = 1;i <= pageNum ;i++){
            urlQueue.add("http://info.meadin.com/Index_"+i+".shtml");
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i<= 20; i++){
            exec.execute(new PaserNew(urlQueue,resultQueue));
        }
        for (int i= 0; i<=10;i++){
            exec.execute(new StoreNews(resultQueue));
        }


    }

}
