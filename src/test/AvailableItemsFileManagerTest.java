package test;

import lib.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class AvailableItemsFileManagerTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void testBid() throws Exception{
		AvailableItemsFileManager.bid("someUs3r", "basketball", "newBidder", "15.00");
		// some code
		String str = readFile("testAvailableItems.txt");
		
		boolean condition = (str == "basketball          someUs3r        newBidder       005 009.00\r\n" + 
				"sneakers            exampleUsername someBidder      020 005.00\r\n" + 
				"");
		assert(condition);
		//System.out.println(str);
		//assert(someConditional);
	}
	
	String readFile(String filePath) throws IOException {
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String str = "";
		String st;
		while ((st = br.readLine()) != null) {
			str = str + st + "\n";
		}
		br.close();
		
		return str;
	}
}
