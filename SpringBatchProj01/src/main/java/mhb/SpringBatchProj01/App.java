package mhb.SpringBatchProj01;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		JobLauncher launcher=null;
		Job job=null;
		JobExecution execution=null;
		//create IOC Container
		ctx=new ClassPathXmlApplicationContext("com/mhb/cfg/applicationContext.xml");
		//get JOBLauncher
		launcher=ctx.getBean("jobLauncher",JobLauncher.class);
		//get JOB 
		job=ctx.getBean("booksJob",Job.class);
		try{
		//Run the JOB using JOB Luancher
		execution=launcher.run(job, new JobParameters());
		System.out.println("JOb Execution status::"+execution.getStatus());
		System.out.println("JOb start time::"+execution.getStartTime());
		System.out.println("JOb end time::"+execution.getEndTime());
		System.out.println("JOB Exit status::"+execution.getExitStatus());
		}
		catch(JobExecutionException e){
			e.printStackTrace();
		}
		
		//close IOC
		((AbstractApplicationContext) ctx).close();

	}//main
}
