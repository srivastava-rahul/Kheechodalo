/**
 * 
 */
package com.click.controller;

import java.io.File;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.UserDao;
import com.click.entity.User;
import com.click.entity.UserRole;
import com.click.utils.Global;

/**
 * @author Vipul
 */

@Service
@Transactional
@Scope("singleton")
public class Startup {

	private static final Logger LOG = Logger.getLogger(Startup.class);

	@Autowired
	UserDao userDao;

	@PostConstruct
	public void Init() {
		LOG.info(" Initailization Fase Started ");
       try{
		LOG.info("                                                 ");
		LOG.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		LOG.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		LOG.info("    INITIALIZING APPLICATION MASTER DATA.....  ");
		LOG.info("    PERFORMING DATA SYNC IF REQUIRED.....        ");
		LOG.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		LOG.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		LOG.info("                                                 ");
		try {
			File file = new File(Global.FILE_PATH);
			if (!file.exists()) {
				if (!file.mkdirs()) {
					LOG.fatal("***************************************************************************");
					LOG.fatal("THE TEMP DIRECTORY REQUIRED FOR APPLICATION COULD NOT BE CREATED OR DOES NOT EXIST.");
					LOG.fatal("EXPECTED TEMP DIRECTORY : " + Global.FILE_PATH);
					LOG.fatal("***************************************************************************");
				}
			}
		} catch (Exception e) {
			LOG.error(e);
			LOG.fatal("***************************************************************************");
			LOG.fatal("THE TEMP DIRECTORY REQUIRED FOR APPLICATION COULD NOT BE CREATED OR DOES NOT EXIST.");
			LOG.fatal("EXPECTED TEMP DIRECTORY : " + Global.FILE_PATH);
			LOG.fatal("***************************************************************************");
		}

		checkDefaultUserSetup(true); // create default Admin
		
       }catch (Exception e) {
    	   LOG.info("Error Occured In Init "+e.getMessage(),e);
    	   
       }
	}
	
	@PreDestroy
	public void destroy(){
		LOG.info(" Pre Destroyed ");
	}

	@Transactional(readOnly = false)
	private void checkDefaultUserSetup(boolean admin) {
		BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
		String password = enc.encode("admin@1");
		if (admin) {
			User adminDetail = userDao.findByUser("admin@kd.com".toUpperCase());
			try{
			if (adminDetail == null) {
				LOG.info("Create Default Admin ");
				UserRole role = new UserRole();
				role.setId("222");
				adminDetail = new User();
				adminDetail.setEmailId("admin@kd.com".toUpperCase());
				adminDetail.setPassword(password);
				adminDetail.setStatus(true);
				adminDetail.setCreatedDate(new Date());
				adminDetail.setAdmin(true);
				adminDetail.setFirstName("Main");
				adminDetail.setLastName("Admin");
				adminDetail.setDeleted(false);
				adminDetail.setUserRole(role);
				userDao.saveDefaultAdmin(adminDetail);
			}else{
				LOG.info(" Default Admin Already Created ");
			}
			}catch(Exception e){
				LOG.info(" Exception In user Creation :"+e.getMessage() , e);
			}
		}
	}
}
