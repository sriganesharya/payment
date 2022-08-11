package com.dbs.spring.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dbs.spring.service.interfaces.ReceiverValidationInterface;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReceiverValidationService implements ReceiverValidationInterface{

	//@Override
	public boolean searchReceiver(String receiverName) {
		// TODO Auto-generated method stub
		
		//reading the file
		File file = new File("./src/main/resources/sdnlist.txt");
		try (BufferedReader br=new BufferedReader(new FileReader(file))){
			String st;
			while((st=br.readLine())!=null)
			{
				//searching through the file by splitting into strings
				List<String> lineData=Arrays.asList(st.split("[-+\\/.,; \"()@]"));
				//using Set for time complexity efficiency
				Set<String> searchSet = new HashSet<>(lineData);
				if(searchSet.contains(receiverName)) return true;
				System.out.println(lineData);
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Error occurred", new FileNotFoundException("file can't be retreived"));
			
		}
		
		return false;
	}

	
//	  public static void main(String[] args) { ReceiverValidationService obj=new
//	  ReceiverValidationService(); System.out.println(
//	  obj.searchReceiver("Akash")); }

}
