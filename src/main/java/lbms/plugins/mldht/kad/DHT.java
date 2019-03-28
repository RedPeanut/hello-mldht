package lbms.plugins.mldht.kad;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import lbms.plugins.mldht.kad.message.AnnounceRequest;
import lbms.plugins.mldht.kad.message.FindNodeRequest;
import lbms.plugins.mldht.kad.message.GetPeersRequest;
import lbms.plugins.mldht.kad.message.PingRequest;

public class DHT {
	
	private static ScheduledThreadPoolExecutor scheduler;
	private static ThreadGroup executorGroup;
	List<ScheduledFuture<?>> scheduledActions = new ArrayList<ScheduledFuture<?>>();
	
	private Node node;
	
	static {
		int threads = Runtime.getRuntime().availableProcessors();
		scheduler = new ScheduledThreadPoolExecutor(
				threads,
				new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						Thread t = new Thread(executorGroup, r, "");
						t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
							@Override
							public void uncaughtException(Thread t, Throwable e) {
							}
						});
						t.setDaemon(true);
						return null;
					}
				}
		);
		scheduler.setCorePoolSize(threads);
		scheduler.setMaximumPoolSize(threads * 2);
		scheduler.setKeepAliveTime(20, TimeUnit.SECONDS);
		scheduler.allowCoreThreadTimeOut(true);
	}
	
	/*
	public static void main(String args[]) {
		ThreadFactory tf = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(executorGroup, r, "");
				t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
					@Override
					public void uncaughtException(Thread t, Throwable e) {
					}
				});
				t.setDaemon(true);
				return null;
			}
		};
		
		tf.newThread(new Runnable() {
			@Override
			public void run() {
			}
		});
	}
	*/
	
	public void start() {
		
		// create RPCServerManager
		// create TaskManager
		
		// add thread that doBindChecks every 10sec after 10sec
		// add fix rate thread(TaskManager) every 1sec after 5sec
		
		// HERE: bootstrapping
		node = new Node();
		node.loadTable();
		
		started();
	}
	
	public void started() {
		
		
		
		bootstrap();
		
		// add update schedule every 1sec after 5sec
		// add db expire schedule every 5min after 1sec
		// add ping to a random node every 10sec after 1sec
		// add deep lookup schedule every 10min after 10min
	}
	
	public void bootstrap() {
		
		findNode(null);
		
	}
	
	private void ping(PingRequest r) {
		
	}
	
	private void findNode(FindNodeRequest r) {
		
	}
	
	private void announce(AnnounceRequest r) {
		
	}
	
	private void getPeers(GetPeersRequest r) {
		
	}
	
	public static ScheduledExecutorService getScheduler() {
		return scheduler;
	}
	
}
