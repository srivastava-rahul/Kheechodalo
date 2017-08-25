package com.click.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.click.service.PicsService;
import com.click.service.WinnerService;

@EnableScheduling
@Component
public class Schedular {
	
	@Autowired
	PicsService picsService;
	
	@Autowired
	WinnerService winnerService;
	
	
	/*private void sendHeartBeat() throws Exception{
		System.out.println("hi rahul");
	}
	
	@Scheduled(fixedRate = 60000)
	//@Scheduled(cron="0 * * * * *",zone = "IST")
	public void runForAdminHeartBeat()throws Exception{	
		
			sendHeartBeat();
	 }*/
	
	
	@Scheduled(cron="0 55 23 * * *",zone = "IST")
	public void deleteAllPicsData()throws Exception{		
			//send heart beat for health check 
		copyWinnerPic();
		
			deleteAllPics();
	 }
	
	private void deleteAllPics() throws Exception{
		System.out.println("Deleting all pics ");
		picsService.deleteAllPics();
	}
	
	private void copyWinnerPic() throws Exception{
		System.out.println("Copying winner pic");
		winnerService.copyWinnerPic();
	}
	
}
