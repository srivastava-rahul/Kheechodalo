package com.click.controller;

import org.apache.commons.codec.binary.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.click.entity.PicUploadData;
import com.click.entity.PictureUpload;
import com.click.serviceImpl.PicsService;
import com.click.utils.SecurityLibrary;

@Controller
@RequestMapping(value = "/user")
public class UploadPicController {

	@Autowired
	PicsService picsService;

	@RequestMapping(value = "/uploadPic", method = RequestMethod.GET)
	protected String getAboutUs(Model model) throws Exception {
		System.out.println("In user uploadPic controller");
		return "uploadPic";
	}

	@RequestMapping(value = "/savePic", method = RequestMethod.POST)
	public String savePic(@RequestParam("picImg") MultipartFile uploadPic, @RequestParam(required = false) String desc, Model model) {
		System.out.println("save pic called");
		String fileName = null;
		if (!uploadPic.isEmpty()) {
			try {
				fileName = uploadPic.getOriginalFilename();
				System.out.println("file name :" + fileName);
				byte[] bytes = uploadPic.getBytes();
				PictureUpload pic = new PictureUpload();
				pic.setPicName(fileName);
				pic.setUploadDate(new Date());
				pic.setContentType(uploadPic.getContentType());
				pic.setPicSize(bytes.length > 0 ? bytes.length / 1024 : 0);
				pic.setDescription(desc);
				PicUploadData data = new PicUploadData();
				data.setFileData(bytes);
				pic.setPicUploadData(data);
				pic.setUser(SecurityLibrary.getLoggedInUser());
				picsService.savePic(pic);
				System.out.println("uploaded");
				try {
					if(data.getFileData() !=null){
					byte[] encodeBase64 = Base64.encodeBase64(data.getFileData());
					String base64Encoded = new String(encodeBase64, "UTF-8");
					model.addAttribute("picImg", base64Encoded);
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error while encoded ");
				}
				return "uploadPic";
			} catch (Exception e) {
				System.out.println("Error :" + e.getMessage());
				e.printStackTrace();
				return "uploadPic";
			}
		} else {
			return "uploadPic";
		}
	}
}
