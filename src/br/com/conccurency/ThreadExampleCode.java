package br.com.conccurency;

public class ThreadExampleCode {

	public static void main(String[] args) {
		System.out.println("begin");
		(new ReadInventoryThread()).start();
		(new Thread(new PrintData())).start();
		(new ReadInventoryThread()).start();
		System.out.println("end");
	}
}