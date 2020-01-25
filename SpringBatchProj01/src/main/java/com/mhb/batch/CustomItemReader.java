package com.mhb.batch;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class CustomItemReader implements ItemReader<String> {

	private List<String> bookNameList;
	public List<String> getBookNameList() {
		return bookNameList;
	}

	public void setBookNameList(List<String> bookNameList) {
		this.bookNameList = bookNameList;
	}

	private int bookCount=0;

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		System.out.println("ItemReader::read()");
		if(bookCount<bookNameList.size()){
			return bookNameList.get(bookCount++);
		}
		else{
		return null;
		}
	}
}
