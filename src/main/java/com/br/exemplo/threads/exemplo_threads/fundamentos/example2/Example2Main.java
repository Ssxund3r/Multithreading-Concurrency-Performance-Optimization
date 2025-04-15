package com.br.exemplo.threads.exemplo_threads.fundamentos.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Example2Main {
	public static final int SENHA_MAXIMA = 9999;

	public static void main(String[] args) {
		Random random = new Random();
		
		Cofre cofre = new Cofre(random.nextInt(SENHA_MAXIMA));
		
		List<Thread> threads = new ArrayList<>();
		
		threads.add(new HackerCrescenteThread(cofre));
		threads.add(new HackerDecrescenteThread(cofre));
		threads.add(new PoliciaThread());
		
		for(Thread thread : threads) {
			thread.start();
		}
	}

	private static class Cofre {
		public int senha;

		public Cofre(int senha) {
			this.senha = senha;
		}

		public boolean senhaCorreta(int tentativa) throws InterruptedException {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
			}
			return this.senha == tentativa;
		}
	}

	private static abstract class HackerThread extends Thread {
		protected Cofre cofre;

		public HackerThread(Cofre cofre) {
			this.cofre = cofre;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(MAX_PRIORITY);
		}

		@Override
		public void start() {
			System.out.println("Iniciando a thread: " + this.getName());
			super.start();
		}
	}

	public static class HackerCrescenteThread extends HackerThread {

		public HackerCrescenteThread(Cofre cofre) {
			super(cofre);
		}

		@Override
		public void run() {
			for (int tentativa = 0; tentativa < SENHA_MAXIMA; tentativa++) {
				try {
					if (cofre.senhaCorreta(tentativa)) {
						System.out.println(this.getName() + " adivinhou a senha: " + tentativa);
						System.exit(0);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class HackerDecrescenteThread extends HackerThread {

		public HackerDecrescenteThread(Cofre cofre) {
			super(cofre);
		}

		public void run() {
			for (int tentativa = SENHA_MAXIMA; tentativa >= 0; tentativa--) {
				try {
					if (cofre.senhaCorreta(tentativa)) {
						System.out.println(this.getName() + " adivinhou a senha: " + tentativa);
						System.exit(0);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class PoliciaThread extends Thread {
		@Override
		public void run() {
			for (int i = 10; i > 0; i--) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
				System.out.println(i);
			}
			System.out.println("Fim de jogo para os hackers!");
			System.exit(0);
		}
	}
}
