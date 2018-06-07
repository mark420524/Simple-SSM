package com.faceghost.app.utils;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EhCacheUtilTest {
	static AbstractApplicationContext context = null;
	
	private static void before() {
		context =  new ClassPathXmlApplicationContext("spring_context.xml");
	}
	
	private static void after() {
		context.close();
	}
	
	
	private static void test() {
		EhCacheUtil cacheUtil = context.getBean(EhCacheUtil.class);
		System.err.println(cacheUtil);
		Cache cache = cacheUtil.getDefault();
		cache.put("test","我是缓存");
		ValueWrapper vw =  cache.get("test");
		System.err.println(vw.get());
		
	}
	
	public static void main(String[] args) {
		before();
		test();
		after();
	}
}
