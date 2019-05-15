package br.com.io;

import java.io.Serializable;

public class Animale implements Serializable {
	private static final long serialVersionUID = 2L;
	private transient String name;
	private transient int age = 10;
	private static char type = 'C';
	{
		this.age = 14;
	}

	public Animale() {
		this.name = "Unknown";
		this.age = 12;
		this.type = 'Q';
	}

	public Animale(String name, int age, char type) {
		this.name = name;
		this.age = age;
		this.type = type;
	}

	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
	}
}
