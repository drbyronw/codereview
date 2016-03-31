package org.msstate.cse.changecalculator.diff;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/*DiffParser Summary:  Method getChangedFile receives the content of a file as a string
and compares it to..
*/

public class DiffParser {
	
	public static List<String> getChangedFiles(String diffContent) {  //AJAY-NOTE: Change return from list<string> set<string>
		if (diffContent != null && !diffContent.isEmpty()) {
			List<String> changedFileList = new ArrayList<String>();
			InputStream in = new ByteArrayInputStream(diffContent.getBytes());
			Reader unbufferedReader = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(unbufferedReader);
			String currentLine;
			try {
				while ((currentLine = reader.readLine()) != null) {
					if (currentLine.startsWith("Index:")) {
						String[] splitStr = currentLine.split("Index:");
						if (splitStr.length == 2 && splitStr[1] != null
								&& !splitStr[1].isEmpty()) {
							changedFileList.add(splitStr[1].trim());
						}
					}
				}
			} catch (IOException e) {  //bad style to have e for one exception and ex for another
				e.printStackTrace();
			} finally {
				try {
					if (reader != null)  //reader is never null, unnecessary "if"
						reader.close();
					if (unbufferedReader != null)  //unbufferedReader is never null, unnecessary "if"
						unbufferedReader.close();
				} catch (IOException ex) {  //bad style to have e for one exception and ex for another
					ex.printStackTrace();
				}
			}
			return changedFileList;
		}
		return null;
	}

}
