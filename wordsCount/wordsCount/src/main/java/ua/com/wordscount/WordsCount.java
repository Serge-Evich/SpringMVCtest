package ua.com.wordscount;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class WordsCount {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	String getIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/getWordsCount", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Integer> getWordsCount(@RequestBody Text text) {
		System.out.println(text.getText());
		Map<String, Integer> wordsMap = new HashMap<>();
		String[] words = text.getText().replaceFirst("\\s+", "").split("\\s+"); 
		System.out.println(text.getText());
		for (String word : words) {
			Integer count = wordsMap.get(word);
			if (count == null) {
				count = new Integer(1);
				wordsMap.put(word, count);
			} else {
				wordsMap.put(word, new Integer(count + 1));
			}
		}
		Iterator<Map.Entry<String, Integer>> it = wordsMap.entrySet().iterator();
		while (it.hasNext()) {
			if (it.next().getValue().equals(1)) it.remove();
		}
		return wordsMap;
	}
}
