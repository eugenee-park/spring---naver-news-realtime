package com.cos.news.batch;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class TimeStampTest {
	@Test
	public void test1() {
	   LocalDateTime t = LocalDateTime.now().minusDays(1).plusHours(9);
	   System.out.println(t);
	   Timestamp ts = Timestamp.valueOf(t);
	   System.out.println(ts);
	}

}
