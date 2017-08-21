/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.TestimonialDao;
import com.click.entity.UserTestimonial;
import com.click.entity.Winner;
import com.click.service.TestimonialService;
import com.click.utils.CollectionUtil;

/**
 * @author rahul
 */

@Component
@Transactional(readOnly = true)
public class TestimonialServiceImpl implements TestimonialService {

	private static final Logger LOG = Logger.getLogger(TestimonialServiceImpl.class);
	
    @Autowired
    TestimonialDao testimonialDao;
	
	
	@Override
	@Transactional(readOnly = false)
	public void savetestimonial(UserTestimonial testimonialdata) {
		LOG.info("Inside savetestimonial() serviceImpl ");
		try{
		testimonialDao.savetestimonial(testimonialdata);
		}catch(Exception e){
            LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		
	}

	@Override
	public List<UserTestimonial> gettestimonial(int pageNo) {
		LOG.info("Inside gettestimonial(int pageNo) serviceImpl ");
		List<UserTestimonial> listoftestimonial=null;
		try{
		 listoftestimonial=testimonialDao.gettestimonial(pageNo);
			if (CollectionUtil.isNotEmpty(listoftestimonial)) {
				for (UserTestimonial testimonial : listoftestimonial) {
					try {
						if (testimonial.getFileData() != null) {
							byte[] encodeBase64 = Base64.encodeBase64(testimonial.getFileData());
							testimonial.setBase64Encoded(new String(encodeBase64, "UTF-8"));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		 }catch(Exception e){
			  LOG.error(e.getMessage(),e);
				e.printStackTrace(); 
		 }
		return listoftestimonial;
	}

	@Override
	@Transactional(readOnly = false)
	public void deletetestimonial(UserTestimonial testimonialdata) {
		LOG.info("Inside deletetestimonial() serviceImpl ");
		try{
		testimonialDao.deletetestimonial(testimonialdata);
		}catch(Exception e){
			 LOG.error(e.getMessage(),e);
				e.printStackTrace(); 
		}
		
	}

	@Override
	public List<UserTestimonial> gettestimonial() {
		LOG.info("Inside gettestimonial() serviceImpl ");
		List<UserTestimonial> listoftestimonial=null;
		try{
		 listoftestimonial=testimonialDao.gettestimonial();
			if (CollectionUtil.isNotEmpty(listoftestimonial)) {
				for (UserTestimonial testimonial : listoftestimonial) {
					try {
						if (testimonial.getFileData() != null) {
							byte[] encodeBase64 = Base64.encodeBase64(testimonial.getFileData());
							testimonial.setBase64Encoded(new String(encodeBase64, "UTF-8"));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		 }catch(Exception e){
			  LOG.error(e.getMessage(),e);
				e.printStackTrace(); 
		 }
		return listoftestimonial;
	}

}
