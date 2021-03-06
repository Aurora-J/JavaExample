package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;


public class ImageToAscii {
	
	 BufferedImage img;
	 
//	 char[] pieces = {'@', '%', '#', '&', '8', 'B', 'G', 'O', '<', '+', '~', '^', '*', '\"', '\'', '`', '-', ',', '.', ' '};
	 char[] pieces = {'@', '%', '#', 'B', 'G', 'O', 't', '^', '*', '\"', '\'','`', '-', ',', '.', ' '};
	
	 int yBlocks;
	 int xBlocks;
	 int pxPerBlock;
	
	 int[][] map;
	 
	public ImageToAscii(File f) throws IOException{
		this(f, 3);
	}
	
	public ImageToAscii(File f, int pixelsPerBlock) throws IOException{
		
		img = ImageIO.read(f);
		pxPerBlock = pixelsPerBlock;
		
		yBlocks = img.getHeight() / pxPerBlock;
		xBlocks = img.getWidth() / pxPerBlock;
		
		map = new int[yBlocks][xBlocks];
		
		for(int y=0; y<yBlocks; y++){
			for(int x=0; x < xBlocks; x++){
				int i = getGreyscaleOfArea(x*pxPerBlock, y*pxPerBlock);
				map[y][x] = i/16;
			}
		}
	}
	
	private int getGreyscaleOfArea(int x, int y){
			
		int counter = 0, sum = 0;
		
		for(int i=y; i < y + pxPerBlock; i++){
			for(int j=x; j < x + pxPerBlock; j++){
				sum += getGreyscale(Integer.toHexString(img.getRGB(j, i)));
				counter++;
			}
		}
		
		return sum/counter;
	}
	
	private  int getGreyscale(String hex){
		int r = Integer.valueOf(hex.substring(2, 4), 16);
		int g = Integer.valueOf(hex.substring(4, 6), 16);
		int b = Integer.valueOf(hex.substring(6, 8), 16);
		
		return (r+g+b)/3;
	}
	
	public void printMap(){
		for(int i =0; i < yBlocks; i++){
			for(int j=0; j < xBlocks; j++){
				System.out.print( pieces[map[i][j]] );
			}
			System.out.print( "\n" );
		}
	}
	
	public void printToFile(FileWriter writer) throws IOException{
		for(int i =0; i < yBlocks; i++){
			for(int j=0; j < xBlocks; j++){
				writer.write( "" + pieces[map[i][j]] );
			}
			writer.write( "\n" );
		}
	}
	
	public static void main(String[] args) throws Exception{
		String[] strs = "HiWiFi_5G|d0:ee:07:15:4f:1a|2|5|3".split("\\|");
		System.out.println(Arrays.toString(strs));
//		new ImageToAscii(new File("/Users/aurora/guniang.jpeg"), 1).printMap();
//		if(args.length > 0)
//			new ImageToAscii(new File(args[0]), 1).printMap();
//		else
//			new ImageToAscii(new File("monster.jpeg"), 1).printMap();
		
	}

}