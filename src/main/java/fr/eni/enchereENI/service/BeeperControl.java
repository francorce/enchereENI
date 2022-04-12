package fr.eni.enchereENI.service;

import static java.util.concurrent.TimeUnit.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import fr.eni.enchereENI.bll.ArticleManager;

public class BeeperControl {
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	ArticleManager articleManager = new ArticleManager();
	public void beepForAnHour() {
		final Runnable beeper = new Runnable() {
			public void run() {	
				articleManager.remporterEnchere();
			}
		};
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
		scheduler.schedule(new Runnable() {
			public void run() {
				beeperHandle.cancel(true);
			}
		}, 60 * 60, SECONDS);
	}
}