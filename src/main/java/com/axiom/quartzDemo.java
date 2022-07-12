package com.axiom;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class quartzDemo {
	
	public static void main(String[] args) {
		JobDetail job1 = JobBuilder.newJob(ClientEmailJob.class).withIdentity("ClientJob", "group1").build();
		 
        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("ClientJobTrigger", "group1").forJob(job1)
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever()).build(); 
        
        try {
        Scheduler scheduler1 = new StdSchedulerFactory().getScheduler(); 
        
        scheduler1.start(); 
        scheduler1.scheduleJob(job1, trigger1); 
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
}


/*
JobDetail job1 = JobBuilder.newJob(Hello.class).withIdentity("helloJob", "group1").build();
 
Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("HelloTrigger", "group1").forJob(job1)
        .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(30)).build(); 

try {
Scheduler scheduler1 = new StdSchedulerFactory().getScheduler(); 
scheduler1.start(); 
scheduler1.scheduleJob(job1, trigger1); 
} catch(Exception e) {
	e.printStackTrace();
}
try {
	JobDetail job = JobBuilder.newJob(SimpleJob.class)
			  .withIdentity("myJob", "group1")
			  .usingJobData("jobSays", "Hello World!")
			  .usingJobData("myFloatValue", 3.141f)
			  .build();
	
	Trigger trigger = TriggerBuilder.newTrigger()
			  .withIdentity("myTrigger", "group1")
			  .startNow()
			  .withSchedule(SimpleScheduleBuilder.simpleSchedule()
					    .withIntervalInSeconds(10)
					    .withRepeatCount(10))
			  .build();
	
	Scheduler scheduler1 = new StdSchedulerFactory().getScheduler(); 
    scheduler1.start(); 
    scheduler1.scheduleJob(job, trigger); 
} catch (Exception e) {
	e.printStackTrace();
}*/
