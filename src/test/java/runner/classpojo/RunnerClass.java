package runner.classpojo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.read.Data;
import com.pojo.read.MainJsonPojo;
import com.pojo.read.Support;

public class RunnerClass {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		File file = new File(
				"C:\\Users\\DELL\\eclipse-workspace\\APIProject\\src\\test\\resources\\ObjectMapper\\TaskObjectmapper.json");

		ObjectMapper objectMapper = new ObjectMapper();
		MainJsonPojo objMap = objectMapper.readValue(file, MainJsonPojo.class);
		int page = objMap.getPage();
		int per_page = objMap.getPer_page();
		int total = objMap.getTotal();
		int total_pages = objMap.getTotal_pages();
		System.out.println(page + "\n" + per_page + "\n" + total + "\n" + total_pages + "\n");

		ArrayList<Data> data = objMap.getData();
		for (int i = 0; i < data.size(); i++) {
			Data data2 = data.get(i);
			int id = data2.getId();
			String email = data2.getEmail();
			String first_name = data2.getFirst_name();
			String last_name = data2.getLast_name();
			String avatar = data2.getAvatar();
			System.out.println(id + "\n" + email + "\n" + first_name + "\n" + last_name + "\n" + avatar);
			System.out.println();
		}
		Support support = objMap.getSupport();
		String url = support.getUrl();
		String text = support.getText();
		System.out.println(url + "\n" + text);
	}

}
