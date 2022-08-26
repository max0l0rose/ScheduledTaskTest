package com.example.scheduledtasktest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Set;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyRunner implements CommandLineRunner {

	@Autowired
	private ScheduledAnnotationBeanPostProcessor scheduledAnnotationBeanPostProcessor;

	@Autowired
	private ThreadPoolTaskScheduler scheduler;

	@Override
	public void run(String... args) throws InterruptedException
	{
		System.out.println("====== run =======");

		Thread.sleep(4000);

		//List<Beach> beachList = beachRepository.findAll();

		Set<ScheduledTask> taskSet = scheduledAnnotationBeanPostProcessor.getScheduledTasks();

		ScheduledTask st2 = taskSet.stream().filter(t -> (ScheduledTaskTestApplication.class.getName() +  ".scheduled2").equals(t.toString()) == true).findAny().get();

		Iterator<ScheduledTask> it = taskSet.iterator();
		ScheduledTask st1 = it.next();
		//ScheduledTask st2 = it.next();
		System.out.println(st1);
		System.out.println(st2);
		st1.cancel();
		st2.cancel();

		scheduler.shutdown(); // w\o this no exit

		int a = 1;
		System.out.println("-- run exit --");
	}
}
