package com.axiom;

import java.util.HashMap;
import java.util.Map;

public class ClientData {
	static Map<String, String> executeCronMap;
	static {
		executeCronMap = new HashMap<String, String>();
		executeCronMap.put("EYBT", "30 */2 * * * ? *");
		executeCronMap.put("GS", "30 */3 * * * ? *");
		executeCronMap.put("HTC", "0 */5 * * * ? *");
		executeCronMap.put("WellsFargo", "0 */3 * * * ? *");
		executeCronMap.put("Morgan Stanley", "0 */3 * * * ? *");
		executeCronMap.put("Novartis", "0 */3 * * * ? *");
	}
}
