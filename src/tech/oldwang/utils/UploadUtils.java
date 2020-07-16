package tech.oldwang.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * utils for file upload
 * 
 */
public class UploadUtils {

	/**
	 * generate unique file name:
	 */
	public static String getUUIDFileName(String fileName){
		// get the postfix of the image file xx.jpg   --->   .jpg
		int idx = fileName.lastIndexOf(".");
		String extention = fileName.substring(idx);
		String uuidFileName = UUID.randomUUID().toString().replace("-", "")+extention;
		return uuidFileName;
	}
	
	public static Map uploadFile(HttpServletRequest request) throws IOException {
		Map<String,String> map = new HashMap<String,String>();
		// 1. create a DiskFileItemFactory
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// 2. create a parse instance
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		// 3. parse the request, return a List including FileItem
		String url = null;
		String uuidFileName= null;
		try {
			List<FileItem> list = servletFileUpload.parseRequest(request);
			for (FileItem fileItem : list) {
				if(fileItem.isFormField()){
					// Then not process the file upload
					// receive the form parameter:
					String name = fileItem.getFieldName(); // get the name of the parameter
					String value = fileItem.getString("UTF-8");// get the value of the parameter
					// put into the map
					map.put(name, value);
				}else{
					// File upload
					// Get the file's name
					String fileName = fileItem.getName();
					System.out.println("filename="+fileName);
					if(fileName !=null && !"".equals(fileName)){
						// get the unique name:
						uuidFileName = UploadUtils.getUUIDFileName(fileName);
						// get the data to upload
						InputStream is = fileItem.getInputStream();
						// get the path to save
						String path = request.getServletContext().getRealPath("/upload");
						// connect the input stream and the output stream
						url = path+"\\"+uuidFileName;
						OutputStream os = new FileOutputStream(url);
						int len = 0;
						byte[] b = new byte[1024];
						while((len = is.read(b))!=-1){
							os.write(b, 0, len);
						}
						is.close();
						os.close();
						
						map.put("path","/upload/"+uuidFileName);
						map.put("filename", fileName);
					}
					System.out.println(map);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		System.out.println(getUUIDFileName("1.jpg"));
	}
}
