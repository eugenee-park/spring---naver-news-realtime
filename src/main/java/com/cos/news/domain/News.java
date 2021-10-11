package com.cos.news.domain;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "naver_realtime")
public class News {
	private String _id;
	private String title;		//제목
	private String company;		//신문사	
	private String CreatedAt;	//발행일
	
	//private LocalDateTime CreatedAt;	날짜(여기 날짜는 신문 발행일 -> 매일 1시에 craw -> string)
	
}
