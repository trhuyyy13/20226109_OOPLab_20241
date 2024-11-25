package hust.soict.ep.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "/Users/macbook/Library/CloudStorage/OneDrive-HanoiUniversityofScienceandTechnology/TÀI LIỆU HỌC TẬP/IT3103 Lập trình hướng đối tượng/OOP_Lab_20241/Lab3_OOP/OtherProjects/hust/soict/ep/garbage/test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder("");
        for(byte b : inputBytes) {
            outputStringBuilder.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}