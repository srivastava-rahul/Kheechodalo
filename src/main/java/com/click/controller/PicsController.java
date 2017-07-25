package com.click.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.click.entity.PicUploadData;
import com.click.entity.PictureUpload;
import com.click.service.PicsService;

@Controller
public class PicsController {

	private static final Logger LOG = Logger.getLogger(PicsController.class);
	
	@Autowired
	PicsService picsService;

	@RequestMapping(value = "/savePic", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<PictureUpload>> uploadprDocuments(@RequestParam("file") MultipartFile file, @RequestParam("desc") String desc) {
		LOG.info(" Inside uploadprDocuments controller save pic called");
		String fileName = null;
		HttpHeaders headers = new HttpHeaders();
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				LOG.debug("file name :" + fileName);
				byte[] bytes = file.getBytes();
				PictureUpload pic = new PictureUpload();
				pic.setPicName(fileName);
				pic.setUploadDate(new Date());
				pic.setContentType(file.getContentType());
				pic.setPicSize(bytes.length > 0 ? bytes.length / 1024 : 0);
				pic.setDescription(desc);
				PicUploadData data = new PicUploadData();
				data.setFileData(bytes);
				pic.setPicUploadData(data);
				picsService.savePic(pic);
				LOG.debug("uploaded");
				return new ResponseEntity<List<PictureUpload>>(null, headers, HttpStatus.OK);
			} catch (Exception e) {
				LOG.error(e.getMessage(),e);
				e.printStackTrace();
				return new ResponseEntity<List<PictureUpload>>(null, headers, HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<List<PictureUpload>>(null, headers, HttpStatus.BAD_REQUEST);
		}
	}
}
