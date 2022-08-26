package com.example.scheduledtasktest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication
@EnableScheduling
public class ScheduledTaskTestApplication {

	//private static final String SCHEDULED_TASKS = "scheduledTasks";

//	@Autowired
//	private ScheduledTask scheduledTasks;

	@Value("${my.rate}")
	private int rate = 1000;

	@Scheduled(fixedRateString = "${my.rate}")
	public void scheduled() {
		//log.info("The time is now {}", dateFormat.format(new Date()));
		System.out.println("  scheduled");
		//postProcessor.postProcessBeforeDestruction(this, "qqq");
		//scheduler.shutdown();
	}

	@Scheduled(fixedRate = 2000, initialDelay = 2000)
	public void scheduled2() {
		//log.info("The time is now {}", dateFormat.format(new Date()));
		System.out.println("    scheduled2");
		//postProcessor.postProcessBeforeDestruction(this, "qqq");
		//scheduler.shutdown();
	}

	public static void main(String[] args) {
		//Task t1 = new Task(() -> {});

//		ScheduledMethodRunnable;
//		WebProperties.Resources<> ;

		System.out.println("START");

//		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//
//		ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(()-> {
//			System.out.println("  schedule");
//		}, 1, TimeUnit.SECONDS);
//
//		ScheduledFuture scheduledFuture2 = scheduledExecutorService.schedule(()-> {
//			System.out.println("  schedule 2");
//		}, 2, TimeUnit.SECONDS);
//
//		//System.out.println(scheduledFuture);
//		//System.out.println(scheduledFuture2);
//
//		Set<ScheduledFuture> set = new HashSet<>();
//		set.add(scheduledFuture);
//		set.add(scheduledFuture2);
//
//		set.forEach(el -> {
//			System.out.println(el);
//		});
//
//		Thread.sleep(3000);
//		scheduledExecutorService.shutdown();

		SpringApplication.run(ScheduledTaskTestApplication.class, args);
	}

}


@Configuration
class conf {
	@Bean
	public ThreadPoolTaskScheduler taskScheduler() {
		return new ThreadPoolTaskScheduler();
	}
}

