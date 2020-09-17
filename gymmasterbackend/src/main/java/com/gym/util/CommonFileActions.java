package com.gym.util;

import java.io.File;

/**
 * @author tharindu
 *
 * Jun 5, 2019
 */
public class CommonFileActions {
	
	public static void createDirectory(String name) {
		File file = new File(name);
        if (!file.exists()) {
            if (file.mkdirs()) {
            	System.out.println("Directory is created!");
            } else {
            	System.out.println("Failed to create directory!");
            }
        }else	System.out.println("Directory is alrady created!");
	}
}
