package aaa;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class AaaController {
	@PostMapping("asJson")
	public String inputProc(@RequestBody String data1, String data2) {
		JSONObject obj = new JSONObject();
		obj.addProperty("data1", data1);
		obj.addProperty("data2", data2);
		return new Gson().toJson(obj);
	}
}
