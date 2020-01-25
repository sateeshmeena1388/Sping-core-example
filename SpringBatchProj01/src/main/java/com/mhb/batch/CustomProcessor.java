package com.mhb.batch;

import org.springframework.batch.item.ItemProcessor;

public class CustomProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String bookNameWithoutAuthor) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ItemProcessor:process(-)");
		String bookNameWithAuthor="Book Name - "+bookNameWithoutAuthor+" | Author Name - ";
		if("Core Java".equalsIgnoreCase(bookNameWithoutAuthor)){
			bookNameWithAuthor +="Sriniwas";
		}
		else if("Advance Java".equalsIgnoreCase(bookNameWithoutAuthor.trim()))
		{
			bookNameWithAuthor +="Ravi";
		}
		else if("Design Patterns".equalsIgnoreCase(bookNameWithoutAuthor.trim()))
		{
			bookNameWithAuthor +="raja";
		}
		else if("Spring FrameWork".equalsIgnoreCase(bookNameWithoutAuthor.trim()))
		{
			bookNameWithAuthor +="Natraj";
		}
		else if("Hibernate Framework".equalsIgnoreCase(bookNameWithoutAuthor.trim()))
		{
			bookNameWithAuthor +="Shekhar";
		}
		
		return bookNameWithAuthor;
	}

}
