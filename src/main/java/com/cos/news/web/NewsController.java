package com.cos.news.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.news.domain.News;
import com.cos.news.domain.NewsRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class NewsController {
	private final NewsRepository newsRepository;
	
	@CrossOrigin
	@GetMapping(value = "/news", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<News> findAll() {
		return newsRepository.mFindAll()
				.subscribeOn(Schedulers.boundedElastic());
	
	}
	@PostMapping("/news")
	public Mono<News> save(@RequestBody News news) {
		return newsRepository.save(news);
	}
	
}
