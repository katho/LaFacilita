package com.lafacilita;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco Javier Corona Sánchez
 */
public class FileManager {

    public static boolean fileExists(String urlFile) {
        File file = new File(urlFile);
        return (file.exists() && !file.isDirectory());
    }

    public static void createFile(String urlFile) {
        // Archivo con solo Nombre
        File file = new File(urlFile);
        try {
            if (file.createNewFile()) {
                System.out.println(urlFile + " has been created");
            } else {
                System.out.println(urlFile + " already exists");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readFile(String urlFile) {
        try {
            
            if(fileExists(urlFile)) {
                BufferedReader bfrd = new BufferedReader(new FileReader(urlFile));
            
                String line = "";
            
                while((line = bfrd.readLine()) != null) {
                    System.out.println(line);
                }
                bfrd.close();
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Not found file");
        } catch (IOException ex) {
            System.out.println("Something wrong wit the file");
        } finally {
        }
    
    }

    public static void writeFile(String urlFile, String line) /*throws IOException*/ {
        try {
            //PrintWriter printWriter = new PrintWriter( new BufferedWriter( new FileWriter(urlFile, true)));
        	PrintWriter printWriter = new PrintWriter( new BufferedWriter( new FileWriter(urlFile)));
            if((new File(urlFile)).length() > 0) {
                printWriter.append("\n" + line);
            } else {
                printWriter.append(line);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Not found file");
        } catch (IOException ex) {
            System.out.println("Something wrong wit the file");
        } finally {
        }
    }
    
    public static void writeFile(String urlFile, String[] lines) {
        String content = new String();
        for (int idx = 0; idx < lines.length; idx++) {
            content += (idx > 0) ? "\n" + lines[idx] : lines[idx];
        }
        // Add all content
        writeFile(urlFile, content);
    }

}