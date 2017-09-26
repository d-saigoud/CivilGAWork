package com.sai;

import java.io.File;

public class FilesRenaming {

	public static void main(String[] args) {
		
		//String inputDir = "C:\\Users\\sai goud\\Desktop\\Resumes\\Java_J2ee_FullStack_Developer";
		
		String inputDir = args[0];
		
		//String destinationDir = "C:\\Users\\sai goud\\Desktop\\Resumes\\Java_J2ee_FullStack_Developer\\Copy";
		String destinationDir = args[1];
		
		File dir = new File(inputDir);
		
		int totalFilesRenamed = 0;
		
		for(File file: dir.listFiles()) {
			
			if(file.isFile()) {
				
				String filenameWithoutExtension = file.getName().substring(0, file.getName().indexOf("."));
				
				//System.out.println(filenameWithoutExtension);
				//System.out.println(filenameWithoutExtension.length());
				
				
				if(filenameWithoutExtension.length() == 5) {
					
					//System.out.println(filenameWithoutExtension);
					String fileExtension = file.getName().substring(file.getName().indexOf("."));
					String newFileName = destinationDir + "\\" + filenameWithoutExtension.substring(0, 4) + "0" + filenameWithoutExtension.substring(4) + fileExtension;
					//System.out.println(newFileName);
					File newFile = new File(newFileName);
					
					
					
					if(file.renameTo(newFile)) {
					
						//System.out.println(file.getName() + " Renamed");
						totalFilesRenamed++;
					}
					else {
						//System.out.println("Could not rename");
					}
					
				}
				else {
					//System.out.println("Skipped below file : ");
				}
				
				
			}
			
		}
		
		System.out.println("Total Files Renamed : " + totalFilesRenamed);
		
	}
	
}
