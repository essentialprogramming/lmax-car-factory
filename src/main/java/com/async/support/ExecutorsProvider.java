package com.async.support;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorsProvider class provides static access to application shared ExecutorServices to be used by asynchronous
 * methods (tasks implemented using CompletableFutures that run asynchronously).
 */
@ApplicationScoped
public class ExecutorsProvider {

	private static final int APP_EXECUTOR_POOL_SIZE = 5;
	private ExecutorService executorService;

	@PostConstruct
	public void initFixedThreadPool() {
		executorService = Executors.newFixedThreadPool(APP_EXECUTOR_POOL_SIZE);
	}


	public void initCachedThreadPool() {
		executorService = Executors.newCachedThreadPool();
	}

	public ExecutorService getExecutorService() {
		return executorService;
	}
}
