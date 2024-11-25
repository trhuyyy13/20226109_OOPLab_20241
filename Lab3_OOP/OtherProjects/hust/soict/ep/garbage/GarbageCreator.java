public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "/Users/macbook/Library/CloudStorage/OneDrive-HanoiUniversityofScienceandTechnology/TÀI LIỆU HỌC TẬP/IT3103 Lập trình hướng đối tượng/OOP_Lab_20241/Lab3_OOP/OtherProjects/hust/soict/ep/garbage/test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        String outputString = "";
        for(byte b : inputBytes) {
            outputString += (char)b;
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}