package yiMuSanFenDi;

import java.io.*;
import java.util.*;

public class CommentDelete {
	
	private String filename = null;
	private List<String> article = null;
	private int index = 0;
	
	public CommentDelete(String file) {
		this.filename = file;
		article = new ArrayList<String> ();
		try{
			getLines();
			for(String str : article)
				System.out.println(str);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private void getLines() throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		//String result = null;
		try{
	        String line = reader.readLine();

	        while (line != null) {
		        article.add(line);
	            line = reader.readLine();
	        }
	    } catch(Exception e) {
	    	System.out.println(e);
	    } finally {
	    	try{
	    		reader.close();
	    	} catch(Exception e) {
	    		System.out.println("close file failed");
	    	}
	    }
	}
	
	public String getLine() {
		if(index == article.size())	return null;
		return article.get(index++);
	}
	
	public void readWithoutComments() {
		int count = 0;
		String line = null;
		while((line = getLine()) != null) {
			StringBuffer sb = new StringBuffer ();
			char[] arr = line.toCharArray();
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == '/') {
					if(i < arr.length-1 && arr[i+1] == '*') {
						count ++;
						i += 1;
						continue;
					}
				} else if(arr[i] == '*') {
					if(i < arr.length-1 && arr[i+1] == '/') {
						count --;
						i += 1;
						continue;
					}
				}
				if(count == 0)	sb.append(arr[i]);
			}
			System.out.println(sb.toString());
		}
	}
	
	public List<String> getArticle() {
		return this.article;
	}
	
	public static void main(String[] args) {
		CommentDelete commentDelete = new CommentDelete("/Users/Chen/Desktop/deleteCommentTest.txt");
		commentDelete.readWithoutComments();
	}
}
