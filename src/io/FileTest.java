package io;

import java.io.File;
import java.io.IOException;

public class FileTest {
	private File file;	
	
	public String createFile(String name) {
		String parentPath = new PathTest().getClassPath(FileTest.class);
		parentPath = parentPath.substring(parentPath.indexOf(':') + 1);
		file = new File(parentPath.substring(parentPath.indexOf(':') + 1), "testFile");
		if (file.exists()) {
			file.delete();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parentPath + name;
	}
	
	public void readAndWrite() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				file.setWritable(true);
				System.out.println(file.canWrite());
			}
		}).start();
	}
	
	public static void main(String[] args) {
		FileTest fileTest = new FileTest();
		System.out.println(fileTest.createFile("testFile"));
		fileTest.readAndWrite();
	}
}
