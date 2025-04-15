package com.br.exemplo.threads.exemplo_threads.fundamentos;

public class UncaughtExceptionEx {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// Código que será executado em uma nova thread
				throw new RuntimeException("Exceção intencional...");
			}
		});
		
		thread.setName("Thread com comportamento inesperado");

		// Definindo o tratador de exceções não capturadas para a thread
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Um erro crítico ocorreu na thread " + t.getName() + ". O erro foi: " + e.getMessage());
			}
		});
		
		thread.start();
	}
}
