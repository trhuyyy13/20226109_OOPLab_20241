import java.util.Scanner;

public class Ex61_option {
    public static void main(String[] args) {
        System.out.println("Option:");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. I don't know");
        Scanner scanner = new Scanner(System.in);
        int option=scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Ban chon Yes.");
                break;
            case 2:
                System.out.println("Ban chon No.");
                break;
            case 3:
                System.out.println("Ban chon khong biet");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
        scanner.close();
    }
}

