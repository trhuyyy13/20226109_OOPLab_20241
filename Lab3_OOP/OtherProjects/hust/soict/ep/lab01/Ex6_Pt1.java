import java.util.Scanner;

public class Ex6_Pt1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        if (a==0){
            System.out.println("This equation is not first-degree equation ");
        }

        else {
            double x = -b/a;
            System.out.println("The root of equation: " + x);
        }
    }
}
