package com.zhou.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AjaxController
{
	private static Logger logger = LogManager.getLogger(AjaxController.class);
	
	
	/**
	 * 
	 * @fun-name studentInfoSave
	 * @return-type Map<String,Object>
	 * @author Mr_zhou
	 * @date 2018年8月12日 上午1:17:32
	 * @param request  可以用来得到项目某个文件夹的绝对地址
	 * @param file	用户上传的文件
	 * @param name	普通文字RequestParam
	 * @param pass	
	 * @return	
	 * @throws IOException
	 * TODO	Ajax传文件demo,返回json数据
	 */
	@ResponseBody
	@RequestMapping(value = "/saveStudentInfo", method= RequestMethod.POST)
	public Map<String,String> studentInfoSave(HttpServletRequest request,@RequestParam("file") 
	MultipartFile file,@RequestParam("name") String name,@RequestParam("pass") String pass) throws IOException {
		Map<String,String> msg=new  HashMap<String,String>();
		//拿到文件名。注意这里编码
		String filename = URLEncoder.encode(file.getOriginalFilename(), "utf-8");
		//得到文件后缀
	    String suffix=filename.substring(filename.lastIndexOf("."));
	    //类型判断
	    if(!suffix.equals(".png")&&!suffix.equals(".jpg")&&!suffix.equals(".jpeg")) 
	    {msg.put("msg","请上传图片!支持.png.jpg.jpeg");return msg;}
		/**拿到文件大小 友情提示
		 * 1MB=1048576B
		 * 2MB=2097152
		 * 3MB=3145728
		 * 4MB=4194304
		 * 5MB=5242880
		 */
		int fileSize=(int)file.getSize();
		//传入空文件提示
		if(file.isEmpty()){msg.put("msg","请选择文件");return msg;}		
		//文件大于-5MB-的提示
		else if(fileSize>5242880){msg.put("msg","文件过大，请上传小于5MB的文件");return msg;}
		
		request.getServletContext().getRealPath("/img"); 
		
		//拿到文件输入流
	    InputStream inputStream = file.getInputStream();
	    //随机数作为文件名，这里并没有使用
	    String randStr=UUID.randomUUID().toString();
	    //保存文件的方法
	    saveFileFromInputStream(inputStream,"D:/abc",filename,fileSize);
	    //返回的json
		msg.put("msg","ok--"+name+"--"+pass);
		/**************测试*****************/
		return msg;
	}
	/**
	 * 
	 * @fun-name SaveFileFromInputStream
	 * @return-type void
	 * @author Mr_zhou
	 * @date 2018年8月12日 上午12:56:51
	 * @param stream  文件流
	 * @param path	 文件保存地址
	 * @param filename	文件名字
	 * @param fileSize	文件大小(单位字节B)
	 * @throws IOException
	 * TODO	保存前端传入的文件
	 */
	public void saveFileFromInputStream(InputStream stream,String path,String filename,int fileSize) throws IOException
    {      
        FileOutputStream fs=new FileOutputStream( path + "/"+ filename);
        byte[] buffer =new byte[fileSize];
        int byteread = -1; 
        for (;(byteread=stream.read(buffer))!=-1;)
        {
           fs.write(buffer,0,byteread);
           fs.flush();
        } 
        fs.close();
        stream.close();      
    }     

}
