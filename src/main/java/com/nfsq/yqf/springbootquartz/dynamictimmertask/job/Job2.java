package com.nfsq.yqf.springbootquartz.dynamictimmertask.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by qfyu
 * Date:2018/12/12
 * Time:15:33
 **/
@Slf4j
public class Job2 implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("job2");
    }
}
