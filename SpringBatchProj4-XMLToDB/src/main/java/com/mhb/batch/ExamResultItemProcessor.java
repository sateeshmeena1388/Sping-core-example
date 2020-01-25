package com.mhb.batch;

import org.springframework.batch.item.ItemProcessor;

import com.mhb.model.ExamResult;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult result) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Processing result: "+result);
		//only return results which are more then 90%
		if(result.getPercentage()<95){
		return null;
		}
		return result;
	}

}
