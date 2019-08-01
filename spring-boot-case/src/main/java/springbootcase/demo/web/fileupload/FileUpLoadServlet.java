package springbootcase.demo.web.fileupload;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileUpLoadServlet{
	@RequestMapping("/file")
	public Map<String, String> fileupload(MultipartFile file) throws IllegalStateException, IOException{
		System.out.println(file.getOriginalFilename());
		String pathname = "e:/"+file.getOriginalFilename();
		file.transferTo(new File(pathname));
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("ok", "成功");
		return msg;
	}
}
