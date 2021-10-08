package com.cos.news.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "naver_realtime")
public class News {
	private String _id;
	private String title;

}
