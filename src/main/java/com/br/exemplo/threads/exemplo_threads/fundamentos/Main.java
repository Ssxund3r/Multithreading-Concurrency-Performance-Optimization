package com.br.exemplo.threads.exemplo_threads.fundamentos;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// Código que será executado em uma nova thread
				System.out.println("Agora estamos na thread: " + Thread.currentThread().getName());
				System.out.println("A prioridade da thread atual é: " + Thread.currentThread().getPriority());
			}
		});
		
		thread.setName("Nova Thread de Trabalho");
		thread.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("Estamos na thread: " + Thread.currentThread().getName() + " antes de iniciar a nova thread...");
		thread.start();
		System.out.println("Estamos na thread: " + Thread.currentThread().getName() + " após iniciar a nova thread...");
	}
}
