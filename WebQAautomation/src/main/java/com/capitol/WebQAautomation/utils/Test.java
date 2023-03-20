package com.capitol.WebQAautomation.utils;

import java.util.HashMap;
import java.util.Map;

public class Test {
private static Map<String, Object> scenariocontext= new HashMap<>();

private Test() {
	
}
public static Map<String, Object> getvalue(){
	
	return scenariocontext;
	
}
}
