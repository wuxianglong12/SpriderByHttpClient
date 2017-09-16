package com.ustc.sse.Crawler;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;


public class CrawlerData {
    static CloseableHttpClient client = HttpClients.createDefault();

    /**
     * 通过url得到页面的Document
     * @param url
     * @return
     */
    public static Document getContext(String url){
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = client.execute(httpGet);
            return Jsoup.parse(EntityUtils.toString(httpResponse.getEntity(),"gb2312"),url);
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws  IOException {

    }

    /**
     *
     * 解析网页实现页面信息抽取
     * @param url
     */
    public void paser(String url, BlockingQueue<NewsModel> queue) throws InterruptedException {
        Document doc = getContext(url);
        Elements elements = doc.select(".listview").select(".list");
        NewsModel newsModel = new NewsModel();
        for (Element e : elements) {
            //获取标题
            if(e.select("h3").select("a")!=null){
                newsModel.setTitle(e.select("h3").select("a").first().text());
            }

            //获取简要信息
            if(e.select(".info").first()!=null){

                newsModel.setInfo(e.select(".info").first().text());
            }
            //获取发布时间
            if(e.select(".clear.date").select(".fr.arial")!=null){
                newsModel.setTime(e.select(".clear.date").select(".fr.arial").text());
            }
            //获取主题
            if(e.select(".clear.date").select("a").first()!= null){
                newsModel.setTopical(e.select(".clear.date").select("a").first().text());
            }

            queue.put(newsModel);
        }

    }
}
