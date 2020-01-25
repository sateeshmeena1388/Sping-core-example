package com.mhb.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class CustomWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> bookNameWithAuthorList) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ItemWriter:write()");
		System.out.println(bookNameWithAuthorList);
	}

}
