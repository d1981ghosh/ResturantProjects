package com.tech.assign.restaurant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
@Service
public class FileReaderService {

	public FileReaderService() {

	}
	/**
	 * This method will read the input data and populate the map which holds all the input data
	 * After reading line values are inserted into Map by insertion order to maintain 
	 * the order of eating items. 
	 * @throws FileNotFoundException 
	 */
	public Map<String,String> readFromFile() {
		Map<String, String> map = new LinkedHashMap<String,String>();;
		try {
			String filePath = "E:\\Software\\New folder\\eclipse\\LunsWorkSpace\\ResturantProjs\\src\\main\\java\\com\\tech\\input.txt";
			String delimiter = ",";

			try(Stream<String> lines = Files.lines(FileSystems.getDefault().getPath(filePath))){
				lines.filter(line -> line.contains(delimiter)).forEach(
						line -> map.putIfAbsent(line.split(delimiter)[0], line.split(delimiter)[1])
						);
			}

		//	System.out.println(map);    

		} catch (IOException e) {
			System.err.println("IOException while reading input data.. " + e.getStackTrace());
			}
		return map;
	}
	
}
