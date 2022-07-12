package com.axiom;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.quartz.CronExpression;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ClientEmailJob implements Job{

	void delay(int by) {
		try {
			Thread.sleep(by);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("------------------------------------------------------------- Attempting to Execute Client Task ...");
		Map<String, String> cronTimer = ClientData.executeCronMap;  // Take All Client Data from Db
		delay(60);
		boolean isNotExecute = true;
		for(Entry<String, String> entry : cronTimer.entrySet()) {   // Iterating over every Client Data.
			CronExpression exp = null;
			try {
				exp = new CronExpression(entry.getValue());
			} catch(ParseException p){
				System.out.println(p.getMessage());
				continue;
			}
			Date now = new Date();
			if(exp.isSatisfiedBy(now)) {
				isNotExecute = false;
				System.out.println("For Client "+entry.getKey()+" "+entry.getValue());
				System.out.println("[][][][]][[[][][][][][][] Executing Job for Client "+entry.getKey());
			}  
		}
		
		if(isNotExecute) {
			System.out.println("No Client Job Executed.");
		}
		
	}
}

//Date date = exp.getNextValidTimeAfter(new Date());
//System.out.println(entry.getKey()+" Compare Date=>"+date.compareTo(now));

//System.out.println("ID="+Thread.currentThread().getId());
//System.out.println("Count="+Thread.activeCount());
