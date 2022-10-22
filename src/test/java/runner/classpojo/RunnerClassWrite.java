package runner.classpojo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.write.DataWrite;
import com.pojo.write.MainJsonPojoWrite;
import com.pojo.write.SupportWrite;

public class RunnerClassWrite {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		
		DataWrite person1 = new DataWrite(7, "michael.lawson@reqres.in", "Michael", "Lawson","https://reqres.in/img/faces/7-image.jpg");
		DataWrite person2 = new DataWrite(8, "lindsay.ferguson@reqres.in", "Lindsay", "Ferguson","https://reqres.in/img/faces/8-image.jpg");
		DataWrite person3 = new DataWrite(9, "tobias.funke@reqres.in", "Tobias", "Funke","https://reqres.in/img/faces/9-image.jpg");
		DataWrite person4 = new DataWrite(10, "byron.fields@reqres.in", "Byron", "Fields","https://reqres.in/img/faces/10-image.jpg");
		DataWrite person5 = new DataWrite(11, "george.edwards@reqres.in", "George", "Edwards","https://reqres.in/img/faces/11-image.jpg");
		DataWrite person6 = new DataWrite(12, "rachel.howell@reqres.in", "Rachel", "Howell","https://reqres.in/img/faces/12-image.jpg");
		List<DataWrite> l =new ArrayList<DataWrite>();
		l.add(person1);
		l.add(person2);
		l.add(person3);
		l.add(person4);
		l.add(person5);
		l.add(person6);
		SupportWrite sWrite = new SupportWrite("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");
		
		MainJsonPojoWrite mj = new MainJsonPojoWrite(2, 6, 12, 2,l,sWrite);
		File file = new File("C:\\Users\\DELL\\eclipse-workspace\\APIProject\\target\\write.json");
		mapper.writeValue(file, mj);
		
	}

}
