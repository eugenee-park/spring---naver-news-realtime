package com.cos.news.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cos.news.batch.DataNum;
import com.cos.news.domain.News;

@Component
public class NaverCraw {
	
	int aidNum = 1;
	
	public List<News> collect() {
		RestTemplate rt = new RestTemplate();
		List<News> newsList = new ArrayList<>();
		
		for (int i = 1; i < 10; i ++) {
			String aid = String.format("%010d", aidNum);
			String url = "https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=103&oid=437&aid="+aid;
			String html = rt.getForObject(url, String.class);
			
			Document doc = Jsoup.parse(html);
			
			Element titleElement = doc.selectFirst("#articleTitle");
			Element timeElement = doc.selectFirst(".t11");
			String title = titleElement.text();
			String time = timeElement.text();
			
	
			//System.out.println(html);
			
			News news = News.builder()
					.title(title)
					.time(time)
					.build();
			
			newsList.add(news);
			
			aidNum ++;
		}
		return newsList;
	}
		
	

}
