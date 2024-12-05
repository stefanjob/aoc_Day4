import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
 
public class main {
    private static String xmas = "XMAS";
    private static String samx = "SAMX";
 
    public static void part1()
    {
        System.out.println("AoC Day 4 Part 1");
   
        HashMap<Integer, char[]> mapWithChars = new HashMap<>();
        HashMap<Integer, String> mapWithStrings = new HashMap<>();
        HashMap<Integer, String> verticalStrings = null;
 
        boolean full = true;
        Scanner scanner = null;
 
        try {
            if (full) {
                scanner = new Scanner(new File("input_full.txt"));
            } else {
                scanner = new Scanner(new File("input_test.txt"));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
        int lineCounter = 0;
 
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            mapWithChars.put(lineCounter, line.toCharArray());
            mapWithStrings.put(lineCounter, line);
           
            if (verticalStrings == null) {
                verticalStrings = new HashMap<>(line.length());
            }
 
            int col = 0;
            for (char c : line.toCharArray()) {
                String k = "";
                if (lineCounter > 0) {
                   k = verticalStrings.get(col);
                }
                k = k + String.valueOf(c);
                verticalStrings.put(col, k);
                col++;
            }
 
            lineCounter++;
        }
 
        int lastIndex = 0;
        int count = 0;
 
        // find number of XMAS horizontal
        for (String s : mapWithStrings.values() ) {
            while(lastIndex != -1){
 
                lastIndex = s.indexOf(xmas,lastIndex);
           
                if(lastIndex != -1){
                    count ++;
                    lastIndex += xmas.length();
                }
            }
            lastIndex = 0;
        }
        System.out.println("Horizontal forward: " + count);
 
        // find number of SAMX horizontal
        for (String s : mapWithStrings.values() ) {
            while(lastIndex != -1){
 
                lastIndex = s.indexOf(samx,lastIndex);
           
                if(lastIndex != -1){
                    count ++;
                    lastIndex += samx.length();
                }
            }
            lastIndex = 0;
        }
        System.out.println("Horizontal backward: " + count);
 
        // find number of XMAS vertical
        for (String s : verticalStrings.values() ) {
            while(lastIndex != -1){
 
                lastIndex = s.indexOf(xmas,lastIndex);
           
                if(lastIndex != -1){
                    count ++;
                    lastIndex += xmas.length();
                }
            }
            lastIndex = 0;
        }
        System.out.println("Vertical forward: " + count);
 
        // find number of SAMX vertical
        for (String s : verticalStrings.values() ) {
            while(lastIndex != -1){
 
                lastIndex = s.indexOf(samx,lastIndex);
           
                if(lastIndex != -1){
                    count ++;
                    lastIndex += samx.length();
                }
            }
            lastIndex = 0;
        }
        System.out.println("Vertical backward: " + count);
 
        // find number of SAMX diagonal right
        for (int i=0; i<mapWithChars.size(); i++ ) {
            int col = 0;
            char[] chars = mapWithChars.get(i);
            for (char c : chars) {
                if (c == 'S') {
                    try {
                                char tmp[] = mapWithChars.get(i+1);
                        if ( mapWithChars.get(i+1)[col+1] == 'A') {
                            if ( mapWithChars.get(i+2)[col+2] == 'M') {
                                if ( mapWithChars.get(i+3)[col+3] == 'X') {
                                    count++;
                                }
                            }
                        }
                    }
                    catch (Exception e) {
                        //System.out.println("Went to far...");
                    }
                }
                col++;
            }
        }
        System.out.println("Diagonal backward right: " + count);
 
        // find number of XMAS diagonal right
        for (int i=0; i<mapWithChars.size(); i++ ) {
            int col = 0;
            char[] chars = mapWithChars.get(i);
            for (char c : chars) {
                if (c == 'X') {
                    try {
                        if ( mapWithChars.get(i+1)[col+1] == 'M') {
                            if ( mapWithChars.get(i+2)[col+2] == 'A') {
                                if ( mapWithChars.get(i+3)[col+3] == 'S') {
                                    count++;
                                }
                            }
                        }
                    }
                    catch (Exception e) {
                        //System.out.println("Went to far...");
                    }
                }
                col++;
            }
        }
        System.out.println("Diagonal forward right: " + count);
 
        // find number of SAMX diagonal left
        for (int i=0; i<mapWithChars.size(); i++ ) {
            int col = 0;
            char[] chars = mapWithChars.get(i);
            for (char c : chars) {
                if (c == 'S') {
                    try {
                        if ( mapWithChars.get(i+1)[col-1] == 'A') {
                            if ( mapWithChars.get(i+2)[col-2] == 'M') {
                                if ( mapWithChars.get(i+3)[col-3] == 'X') {
                                    count++;
                                }
                            }
                        }
                    }
                    catch (Exception e) {
                        //System.out.println("Went to far...");
                    }
                }
                col++;
            }
        }
        System.out.println("Diagonal backward left: " + count);
 
        // find number of XMAS diagonal left
        for (int i=0; i<mapWithChars.size(); i++ ) {
            int col = 0;
            char[] chars = mapWithChars.get(i);
            for (char c : chars) {
                if (c == 'X') {
                                try {
                        if ( mapWithChars.get(i+1)[col-1] == 'M') {
                            if ( mapWithChars.get(i+2)[col-2] == 'A') {
                                if ( mapWithChars.get(i+3)[col-3] == 'S') {
                                    count++;
                                }
                            }
                        }
                    }
                                catch (Exception e) {
                                                //System.out.println("Went to far...");
                                }
                }
                col++;
            }
        }
        System.out.println("Diagonal forward left: " + count);
    }
 
    public static void part2()
    {
        System.out.println("AoC Day 4 Part 2");

        HashMap<Integer, char[]> mapWithChars = new HashMap<>();
        HashMap<Integer, ArrayList<Character>> mapVertChars = new HashMap<>();

        boolean full = false;
        Scanner scanner = null;
 
        try {
            if (full) {
                scanner = new Scanner(new File("input_full.txt"));
            } else {
                scanner = new Scanner(new File("input_test.txt"));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
        int lineCounter = 0;
 
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            mapWithChars.put(lineCounter, line.toCharArray());
            
            int col = 0;
            for (char c : line.toCharArray()) {
                ArrayList<Character> existingChars = new ArrayList<Character>();
                if (lineCounter > 0) {
                    existingChars = mapVertChars.get(col);
                }
                existingChars.add(c);
                mapVertChars.put(col, existingChars);
                col++;
            }
       
            lineCounter++;
        }

        int counter = 0;

        // going top down 
        for (int j=0; j<mapWithChars.size(); j++) {
            char[] chars = mapWithChars.get(j);
            for (int i = 0; i < chars.length; i++) {
                try {
                    if (chars[i] == 'M' && chars[i+2] == 'S') {
                            char[] nextRow = mapWithChars.get(j+1);
                            if (nextRow[i+1] == 'A') {
                                char[] nextNextRow = mapWithChars.get(j+2);
                                if (nextNextRow[i] == 'M' && nextNextRow[i+2] == 'S') {
                                    counter++;
                            }
                        }
                    }
                }
                catch (Exception e) {
                    // out of bounds...
                }
            }
        }
        // going from left to right 
        for (int j=mapWithChars.size()-1; j>-1; j--) {
            char[] chars = mapWithChars.get(j);
            for (int i = 0; i < chars.length; i++) {
                try {
                    if (chars[i] == 'M' && chars[i+2] == 'S') {
                            char[] nextRow = mapWithChars.get(j-1);
                            if (nextRow[i+1] == 'A') {
                                char[] nextNextRow = mapWithChars.get(j-2);
                                if (nextNextRow[i] == 'M' && nextNextRow[i+2] == 'S') {
                                    counter++;
                            }
                        }
                    }
                }
                catch (Exception e) {
                    // out of bounds...
                }
            }
        }
        // going from right to left
        for (int j=mapVertChars.size()-1; j>-1; j--) {
            ArrayList<Character> chars = mapVertChars.get(j);
            for (int i = chars.size()-1; i >-1; i--) {
                try {
                    if (chars.get(i) == 'M' && chars.get(i-2) == 'S') {
                            ArrayList<Character> nextRow = mapVertChars.get(j-1);
                            if (nextRow.get(i+1) == 'A') {
                                ArrayList<Character> nextNextRow = mapVertChars.get(j-2);
                                if (nextNextRow.get(i) == 'M' && nextNextRow.get(i-2) == 'S') {
                                    counter++;
                            }
                        }
                    }
                }
                catch (Exception e) {
                    // out of bounds...
                }
            }
        }
        
        // going from left to right
        for (int j=0; j<mapVertChars.size(); j++) {
            ArrayList<Character> chars = mapVertChars.get(j);
            for (int i = 0; i < chars.size(); i++) {
                try {
                    if (chars.get(i) == 'M' && chars.get(i+2) == 'M') {
                            ArrayList<Character> nextRow = mapVertChars.get(j+1);
                            if (nextRow.get(i+1) == 'A') {
                                ArrayList<Character> nextNextRow = mapVertChars.get(j+2);
                                if (nextNextRow.get(i) == 'S' && nextNextRow.get(i+2) == 'S') {
                                    counter++;
                            }
                        }
                    }
                }
                catch (Exception e) {
                    // out of bounds...
                }
            }
        }
        
        System.out.println("Occurrence of pattern: " + counter);
    }
    public static void main(String[] args) {
       part2();  
    }
}