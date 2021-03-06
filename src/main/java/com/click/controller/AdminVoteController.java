package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.PictureUpload;
import com.click.service.PicsService;

@Controller
@RequestMapping(value = "/admin")
public class AdminVoteController {
	
	private static final Logger LOG = Logger.getLogger(AdminVoteController.class);

    @Autowired
	PicsService picsrv;

	
	/**
	 * Get Vote information by Admin
	 * @param model
	 * @return to vote page
	 * @throws Exception throw exception if pic doesnot exist
	 */
	@RequestMapping(value = "/admingetvoteinfo")
	protected String getvoteinfo(Model model) throws Exception {
		LOG.info("Fetching the voteinfo from getvoteinfo() controller");
		return "vote";
	}

	/**
	 * Save vote information by admin
	 * @param picid
	 * @param picvote
	 * @param model
	 * @return to vote page
	 * @throws Exception throw if pic id does not exist
	 */
	@RequestMapping(value = "/adminsavevote", method = RequestMethod.POST)
	public String saveVotebyAdmin(@RequestParam String picid,@RequestParam String picvote, Model model)
			throws Exception {
		LOG.info("Admin adding prize from saveVotebyAdmin() controller");
		try {
			long vote = Long.parseLong(picvote);
			PictureUpload picvoteupdate=new PictureUpload();
			picvoteupdate.setId(picid);
			picvoteupdate.setPicVote(vote);
			picsrv.updateVoteCountbyadmin(picvoteupdate);
			 model.addAttribute("success", " Data Entered Successfully .");		
			return "vote";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While Sending Data .");
			return "vote";
		}
	}
}
