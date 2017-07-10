package io;

public class PathTest {
	public String getProjectPath() {
		return System.getProperty("user.dir");
	}
	
	public String getClassPath(Class cls) {
		return cls.getResource("").toString();
	}
	
	public static void main(String[] args) {
		PathTest pathTest = new PathTest();
		System.out.println(pathTest.getProjectPath());
		System.out.println(pathTest.getClassPath(PathTest.class));
	}
}
