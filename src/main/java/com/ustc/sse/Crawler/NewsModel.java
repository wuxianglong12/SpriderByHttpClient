package com.ustc.sse.Crawler;


/**
 *
 * @author wangrun
 * @time 2017.9.16
 */
public class NewsModel {
    String title="";
    String info = "";
    String time = "";
    String topical= "";

    public synchronized String getTitle() {
        return title;
    }

    public synchronized void setTitle(String title) {
        this.title = title;
    }

    public synchronized String getInfo() {
        return info;
    }

    public synchronized void setInfo(String info) {
        this.info = info;
    }

    public synchronized String getTime() {
        return time;
    }

    public synchronized void setTime(String time) {
        this.time = time;
    }

    public synchronized String getTopical() {
        return topical;
    }

    public synchronized void setTopical(String topical) {
        this.topical = topical;
    }
}
