package classification;

import net.sourceforge.tess4j.*;
import java.io.*;

public class ocr {

    public void fileSelected(File folder) {

        if (folder != null) {
            System.out.println("The path of the folder is: " + folder.getAbsolutePath());
            
            // Create an instance of the Tesseract class
            Tesseract tesseract = new Tesseract();
            
            // Iterate through all the files in the folder
            for (File file : folder.listFiles()) {
                try {
                    // Extract text from the file
                    String text = tesseract.doOCR(file);
                    System.out.println("Text in file " + file.getName() + ": " + text);
                    // split the text by spaces
                    String[] words = text.split("\\s+");
                    //loop through the words
                    for(String word: words) {
                        //check if the word is in the list of words
                        if(word.equalsIgnoreCase("aadhar card") || word.equalsIgnoreCase("passport") || word.equalsIgnoreCase("light bill")){
                            // create a folder with the name of the word if it doesn't exist
                            File destination = new File(folder.getAbsolutePath()+"/"+word);
                            if(!destination.exists()) {
                                destination.mkdir();
                            }
                            // move the file to the folder
                            file.renameTo(new File(destination.getAbsolutePath()+"/"+file.getName()));
                        }
                    }
                } catch (TesseractException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No folder was selected");
        }
    }
}
