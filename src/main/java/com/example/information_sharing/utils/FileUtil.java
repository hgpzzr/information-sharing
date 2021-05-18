package com.example.information_sharing.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/5/18 14:22
 */
@Slf4j
public class FileUtil {
	public static boolean upload(MultipartFile file, String filePath, String fileName){
		File file1 = new File(filePath);
		if(!file1.exists()){
			file1.mkdirs();
		}
		if (file.isEmpty()) {
			log.info("文件为空");
			return false;
		}

//        String fileName = file.getOriginalFilename();
		File dest = new File(filePath + fileName);
		try {
			file.transferTo(dest);
			log.info("上传成功");
			return true;
		} catch (IOException e) {
			log.error(e.toString(), e);
		}
		return false;
	}

	/**
	 * 生成随机的文件名称
	 * @param file
	 * @return
	 */
	public static String generateFileName(MultipartFile file){
		//获得文件名
		String originalFilename = file.getOriginalFilename();
		//获得后缀
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		//新生成文件名 不带后缀
		String f = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());

		//新生成文件名 带后缀
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(f).append(suffix);

		return stringBuilder.toString();
	}

	/**
	 * 删除文件
	 * @param filePath
	 * @return
	 */
	public static boolean deleteFile(String filePath){
		File file = new File(filePath);
		if(file.exists()){
			file.delete();
			log.info("删除成功");
			return true;
		}else {
			log.info("删除失败，文件不存在");
			return false;
		}
	}
}
