package com.elses.test;

import java.util.HashMap;
import java.util.Map;

public class SomeTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		System.out.println(map.get("A") +" "+ map.containsKey("A"));
		
	}
}
