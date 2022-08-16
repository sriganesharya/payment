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

import com.dbs.spring.model.ValidateReceiver;
import com.dbs.spring.service.interfaces.ReceiverValidationInterface;

import antlr.NameSpace;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReceiverValidationService implements ReceiverValidationInterface{
	
	ValidateReceiver validateReceiver = new ValidateReceiver();
	

	//@Override
	public boolean searchReceiver(String receiverName) {
		// TODO Auto-generated method stub
		
		validateReceiver.setNameFound(false);
		
		//reading the file
		File file = new File("./src/main/resources/sdnlist.txt");
		
		try (BufferedReader br=new BufferedReader(new FileReader(file))){
			String st;
			Set<String> searchSet = new HashSet<>();
			while((st=br.readLine())!=null)
			{
				//searching through the file by splitting into strings
				List<String> lineData=Arrays.asList(st.split("[-+\\/.,; \"()@]"));
				lineData = lower(lineData);
				searchSet.addAll(lineData);
			}
			List<String> nameArray = Arrays.asList(receiverName.split("[-+\\/.,; \"()@]"));
			nameArray = lower(nameArray);
			for(String word : nameArray) if(!searchSet.contains(word)) return false;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Error occurred", new FileNotFoundException("file can't be retreived"));
			
		}
		
		return true;
	}


	private List<String> lower(List<String> lineData) {
		// TODO Auto-generated method stub
		lineData.forEach(w -> w.toLowerCase());
		return lineData;
	}

	
//	  public static void main(String[] args) { ReceiverValidationService obj=new
//	  ReceiverValidationService(); System.out.println(
//	  obj.searchReceiver("MOJTAMAE SANATE HAFTOME TIR")); }

}
