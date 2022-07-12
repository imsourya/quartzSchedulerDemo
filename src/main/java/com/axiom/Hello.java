package com.axiom;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Hello implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job says: Hello to Everyone");
    }
}
