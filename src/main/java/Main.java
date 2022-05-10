import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {

        String text = readFile("input.txt");
        Pattern pattern = Pattern.compile("(?:\\+|\\d)[\\d\\-\\(\\) ]{9,}\\d");

        Matcher matcher = pattern.matcher(text);
        List phones = new ArrayList();
        while (matcher.find()) {
            int start=matcher.start();
            int end=matcher.end();
            phones.add(text.substring(start,end));
            System.out.println("Найдено совпадение " + text.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");
        }
        Collections.sort(phones);
        System.out.println(phones);
        writeHtml(phones, "output.txt");
    }

    public static String readFile(String filePath) {
        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String text = "";
            while(bufferedReader.ready()) {
                text = text.concat(bufferedReader.readLine());
            }
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeHtml(List list, String filePath) {
        try (FileWriter writer = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(String.valueOf(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
