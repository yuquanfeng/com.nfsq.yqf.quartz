package com.nfsq.yqf.springbootquartz.statictimmertask.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qfyu
 * Date:2018/12/12
 * Time:14:37
 **/
@Component
@Slf4j
public class FirstJob {
    public void execute(){
        log.info("FirstJob"+new SimpleDateFormat("yyyy-MM-dd ：HH-mm-ss").format(new Date()));
    }
}
