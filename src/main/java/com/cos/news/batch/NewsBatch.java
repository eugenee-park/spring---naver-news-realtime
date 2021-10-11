package com.cos.news.batch;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cos.news.domain.News;
import com.cos.news.domain.NewsRepository;
import com.cos.news.util.NaverCraw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NewsBatch {
	
	private final NewsRepository newsRepository;
	private final NaverCraw naverCraw;
	
	//매일 1시에 실행 
	@Scheduled(cron = "0 0 01 * * ?", zone = "Asia/Seoul")
	public void newsCrowAndSave() {
		List<News> newsList = naverCraw.collect();
		newsRepository.saveAll(newsList);
	}
	

}

