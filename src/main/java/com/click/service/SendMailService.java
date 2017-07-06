/**
 * 
 */
package com.click.service;

import java.util.Map;

/**
 * @author parveen
 */
public interface SendMailService {
	/**
	 * @param mailTo
	 * @param subject
	 * @param map
	 * @param template
	 */
	public void sendEmailTemplate(String[] mailTo, String subject, Map<String, Object> map, String template);

}
