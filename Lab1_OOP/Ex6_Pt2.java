import java.util.Scanner;

public class Ex6_Pt2 {
public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    double a = s.nextDouble();
    double b = s.nextDouble();
    double c = s.nextDouble();

    System.out.println(delta);
     if (delta > 0) {
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        System.out.println("Phương trình có 2 nghiệm phân biệt:");
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
    } else if (delta == 0) {
        double x = -b / (2 * a);
        System.out.println("Phương trình có nghiệm kép:");
        System.out.println("x = " + x);
    } else {
        System.out.println("Phương trình vô nghiệm.");
    }

}
}
