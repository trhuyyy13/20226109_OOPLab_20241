import java.util.Scanner;

public class Ex6_hpt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập hệ số cho hệ phương trình bậc nhất hai ẩn:");
        System.out.print("Nhập a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Nhập a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Nhập b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Nhập a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Nhập a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Nhập b2: ");
        double b2 = scanner.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double Dx = b1 * a22 - b2 * a12;
        double Dy = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                System.out.println("Hệ phương trình có vô số nghiệm.");
            } else {
                System.out.println("Hệ phương trình vô nghiệm.");
            }
        } else {
    
            double x1 = Dx / D;
            double x2 = Dy / D;
            System.out.println("Hệ phương trình có nghiệm duy nhất: ");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }

        scanner.close();
    }
}
