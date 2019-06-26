package br.com.conccurency.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZooManager {
	private Map<String, Object> foodData = new ConcurrentHashMap<String, Object>();

	public synchronized void put(String key, String value) {
		foodData.put(key, value);
	}

	public synchronized Object get(String key) {
		return foodData.get(key);
	}
}
