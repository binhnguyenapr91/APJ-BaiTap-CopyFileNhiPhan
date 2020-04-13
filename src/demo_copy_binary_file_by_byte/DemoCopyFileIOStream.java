package demo_copy_binary_file_by_byte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DemoCopyFileIOStream {

	private static void copyFile(String sourcePath, String destinationPath) {
		InputStream fis = null;
		OutputStream fos = null;
		
		try {
			fis = new FileInputStream(sourcePath);
			fos = new FileOutputStream(destinationPath);
			

			long start = System.currentTimeMillis();
			
//			int bytes = 0;
//			
//			while((bytes = fis.read())!=-1) {
//				fos.write(bytes);
//			}
			byte[] bytes = new byte[1024];
			int length;
			while((length = fis.read(bytes))>0) {
				fos.write(bytes, 0, length);
			}
			long end = System.currentTimeMillis();
			System.out.println("Copy done in:" + (end - start) + " ms");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void readFile(String sourcePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(sourcePath);
			int bytes = 0;
			while((bytes = fis.read())!=-1) {
				System.out.print((char)bytes);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		copyFile("file\\bigboy.zip","file\\copyOfBigboy.zip");
		
		
	}

}
