package com.gym.util;

import lombok.Data;

/**
 * @author tharindu
 *
 * Jun 11, 2019
 */
@Data
public class CommonResponce {
	private String key;
	private String message;
	/**
	 * @param key
	 * @param message
	 */
	public CommonResponce(String key, String message) {
		super();
		this.key = key;
		this.message = message;
	}
	
	
}
