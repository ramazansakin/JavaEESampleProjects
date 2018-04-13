package com.obss.ramazansakin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Formatter {

	public static void main(String[] args) throws IOException {

		FileWriter out = null;
		out = new FileWriter("C:/Users/Rmzn/Desktop/out.txt");

		try {
			File file = new File("C:/Users/Rmzn/Desktop/in.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				out.write("\"" + line + " \" +\n" );
			}
			
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}
}
