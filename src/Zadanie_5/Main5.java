package Zadanie_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main5 {
	
	public static void main(String[] args) {
		try {
			findWords();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void findWords() throws IOException {
		String[] array = {"i","ostra", "oraz", "albo", "lub", "dlaczego", "ponieważ", "bo", "czy", "nie", "coś", "ale", "więc"};
		Connection connect = Jsoup.connect("http://gallop.pl/");
		
		Path path = Paths.get("popular_words1.txt");
		//pobieranie dla wybanych serwisów internetowych
		
		try {
			Document document = connect.get();
			Elements links = document.select("h2");
			for (Element elem : links) {
				//System.out.println(elem.text());
				
				FileWriter fw = new FileWriter("popular_words1.txt");
				fw.append(links.text());
				fw.close();
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//skanuje plik i dodaje kolejne słowa dłuże od 3
		Scanner scan = new Scanner (path);
		String newFile="";
		while (scan.hasNext()) {
			String newWord = scan.next().toLowerCase();
			if (newWord.length() > 3 && !Arrays.asList(array).contains(newWord)) {
				newFile += newWord + " " +"\n";
			}
		}
		System.out.println(newFile);
		
		Path path2 = Paths.get("filtered_popular_words.txt");
		
		FileWriter fw2 = new FileWriter("filtered_popular_words.txt");
		fw2.append(newFile);
		fw2.close();
		scan.close();
		
		 //Creating wordCountMap which holds words as keys and their occurrences as values
        
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
        BufferedReader reader = null;
    
        try {
            //Creating BufferedReader object
            reader = new BufferedReader(new FileReader("filtered_popular_words.txt"));
            //Reading the first line into currentLine
            String currentLine = reader.readLine();
            while (currentLine != null){    
                //splitting the currentLine into words
                String[] words = currentLine.split("\n");
                //Iterating each word
                for (String word : words) {
                    //if word is already present in wordCountMap, updating its count
                    if(wordCountMap.containsKey(word)){    
                        wordCountMap.put(word, wordCountMap.get(word)+1);
                    }
                    //otherwise inserting the word as key and 1 as its value
                    else {
                        wordCountMap.put(word, 1);
                    }
                }
                //Reading next line into currentLine  
                currentLine = reader.readLine();
            }
            //Getting the most repeated word and its occurrence
            String mostRepeatedWord = null;
            int count = 0;
            Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
            for (Entry<String, Integer> entry : entrySet){
            	if(entry.getValue() > count) {
                    mostRepeatedWord = entry.getKey();
                    count = entry.getValue();
                }
            }
             
            System.out.println("The most repeated word in input file is : "+mostRepeatedWord);
             
            System.out.println("Number Of Occurrences : "+count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                reader.close();           
            } catch (IOException e)  {
                e.printStackTrace();
            }
        }
    
	}    
	
}
