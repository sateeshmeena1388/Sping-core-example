package com.mhb.batch;

import org.springframework.batch.item.ItemProcessor;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult>{

	@Override
	public ExamResult process(ExamResult result) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Processing result :"+result);
		
		/*
		 * 
		 * Only return results which are more than 80%
		 * 
		 * 
		 * */
		if(result.getPercentage()<80)
		{
			System.out.println("result" +result.getPercentage());
			return null;
		}
		System.out.println("result" +result.getPercentage());
		return result;
		
	}

}
