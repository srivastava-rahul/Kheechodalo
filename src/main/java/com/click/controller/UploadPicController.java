package com.click.controller;

import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.click.entity.PicUploadData;
import com.click.entity.PictureUpload;
import com.click.service.PicsService;
import com.click.utils.SecurityLibrary;
import com.click.utils.StringUtils;

@Controller
@RequestMapping(value = "/user")
public class UploadPicController {

	public static final Logger LOG = Logger.getLogger(UploadPicController.class);

	@Autowired
	PicsService picsService;

	@RequestMapping(value = "/uploadPic", method = RequestMethod.GET)
	protected String getMyPic(Model model) throws Exception {
		LOG.info("In user uploadPic from getMyPic controller");
		long maxVoteCount = picsService.findPicMaxVoteCount();
		PictureUpload pictureUpload = picsService.findPicByUserId(SecurityLibrary.getLoggedInUserLoginEmailId());
		model.addAttribute("maxVoteCount", maxVoteCount);
		model.addAttribute("picData", pictureUpload);
		try {
			if (pictureUpload != null && pictureUpload.getPicUploadData() != null
					&& pictureUpload.getPicUploadData().getFileData() != null) {
				byte[] encodeBase64 = Base64.encodeBase64(pictureUpload.getPicUploadData().getFileData());
				String base64Encoded = new String(encodeBase64, "UTF-8");
				model.addAttribute("picImg", base64Encoded);
			}
		} catch (Exception e) {
            LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return "uploadPic";
	}

	@RequestMapping(value = "/savePic", method = RequestMethod.POST)
	public String savePic(@RequestParam("picImg") MultipartFile uploadPic, @RequestParam(required = false) String desc, @RequestParam(required = false) String picId,
			Model model,RedirectAttributes redir) {
		LOG.info("save pic Inside savePic controller pic Id : " + picId);
		String fileName = null;
		if (!uploadPic.isEmpty()) {
			try {
				if (StringUtils.checkString(picId).length() == 0) {
					fileName = uploadPic.getOriginalFilename();
					System.out.println("file name :" + fileName);
					byte[] bytes = uploadPic.getBytes();
					PictureUpload pic = new PictureUpload();
					pic.setPicName(fileName);
					pic.setEmailId(SecurityLibrary.getLoggedInUserLoginEmailId());
					pic.setUploadDate(new Date());
					pic.setContentType(uploadPic.getContentType());
					pic.setPicSize(bytes.length > 0 ? bytes.length / 1024 : 0);
					pic.setDescription(StringUtils.checkString(desc));
					PicUploadData data = new PicUploadData();
					data.setFileData(bytes);
					pic.setPicUploadData(data);
					pic.setUser(SecurityLibrary.getLoggedInUser());
					picsService.savePic(pic);
					System.out.println("uploaded");
				}else{
					fileName = uploadPic.getOriginalFilename();
					System.out.println("file name :" + fileName);
					byte[] bytes = uploadPic.getBytes();
					PictureUpload pictureUpload = picsService.findPicByUserId(SecurityLibrary.getLoggedInUserLoginEmailId());
					pictureUpload.setPicName(fileName);
					pictureUpload.setEmailId(SecurityLibrary.getLoggedInUserLoginEmailId());
					pictureUpload.setUploadDate(new Date());
					pictureUpload.setContentType(uploadPic.getContentType());
					pictureUpload.setPicSize(bytes.length > 0 ? bytes.length / 1024 : 0);
					pictureUpload.setDescription(StringUtils.checkString(desc));
					pictureUpload.setPicVote(0);
					pictureUpload.setFriendEmail(null);
					PicUploadData data = pictureUpload.getPicUploadData();
					data.setFileData(bytes);
					pictureUpload.setPicUploadData(data);
					picsService.savePic(pictureUpload);
				}
			} catch (Exception e) {
				System.out.println("Error :" + e.getMessage());
				e.printStackTrace();
				redir.addFlashAttribute("error", e.getMessage());
			}
		} else {
			LOG.info("file is null");
		}
		return "redirect:uploadPic";
	}
}