package com.nfsq.yqf.springbootquartz.statictimmertask.quartzconfig;

import com.nfsq.yqf.springbootquartz.statictimmertask.job.FirstJob;
import com.nfsq.yqf.springbootquartz.statictimmertask.job.SecondJob;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by qfyu
 * Date:2018/12/12
 * Time:14:40
 * 此配置类是静态定时任务的配置类
 **/
@Configuration
public class JobConfig {

    @Bean("jobDetail1")
    public MethodInvokingJobDetailFactoryBean getJobDetail1(FirstJob firstJob){
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setTargetObject(firstJob);
        jobDetail.setTargetMethod("execute");
        return jobDetail;
    }
    @Bean("jobDetail2")
    public MethodInvokingJobDetailFactoryBean getJobDetail2(SecondJob secondJob){
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setTargetObject(secondJob);
        jobDetail.setTargetMethod("execute");
        return jobDetail;
    }

    @Bean("tigger1")
    public CronTriggerFactoryBean getTriggeer1(@Qualifier("jobDetail1") MethodInvokingJobDetailFactoryBean jobDetail1){
        CronTriggerFactoryBean trigger1 = new CronTriggerFactoryBean();
        trigger1.setJobDetail(jobDetail1.getObject());
        trigger1.setCronExpression("0/5 * * * * ? ");
        return trigger1;
    }
    @Bean("tigger2")
    public CronTriggerFactoryBean getTrigger(@Qualifier("jobDetail2") MethodInvokingJobDetailFactoryBean jobDetail2){
        CronTriggerFactoryBean trigger2 = new CronTriggerFactoryBean();
        trigger2.setJobDetail(jobDetail2.getObject());
        trigger2.setCronExpression("0/5 * * * * ? ");
        return trigger2;
    }
    @Bean
    public SchedulerFactoryBean getSchedul(Trigger[] triggers){
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setTriggers(triggers);
        return scheduler;
    }
}
