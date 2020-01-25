package mbh.SpringBatchProj2_DbToCSV;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SptingBatch
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
    	ApplicationContext ctx=null;
    	JobLauncher jobLauncher=null;
    	JobExecution jobExecution=null;
    	Job job=null;
    	ctx=new ClassPathXmlApplicationContext("com/mhb/cfgs/spring-batch-beans.xml");
    	jobLauncher=(JobLauncher) ctx.getBean("jobLauncher");
    	job=(Job) ctx.getBean("examResultJob");
       try{
    	   jobExecution=jobLauncher.run(job, new JobParameters());
    	   System.out.println("Job Exit status:"+jobExecution.getStatus());
       }
       catch(JobExecutionException jobExecutionException){
    	   System.out.println("Job ExamResult failed");
    	   jobExecutionException.printStackTrace();
       }
    }
}
