package com.kindred.selectors;

import java.util.HashMap;

public class Selectors {

	private HashMap<String, String> selectorsMap = new HashMap<String, String>();

	public HashMap<String, String> loadSelectors() {
		selectorsMap.put("", "");
		return selectorsMap;
	}

	public String getSelector(String key) {
		loadSelectors();
		return selectorsMap.get(key);
	}

}
