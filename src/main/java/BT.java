public class BT {
    /*S = a * 10^2n (*)

√S = √a * 10^n (**)

a < 10
    2 * 10^n
a >= 10
    6 * 10^n



S = 512348

S = 51.2348 * 10^(2*2)      (*)

S = √51.2348 * 10^2      (**)

Ta có: a = 51.2348

if (51.2348 >= 10)
    a = 6;
else
    a = 2;


x0 = a * 10^n = 6 * 10^2 => 600.0

x1 = 1 / 2 * (x0 + S / x0) =


1. Tìm số a.
2. Lặp 10 lần để ra số căn bậc 2.
3. Điều chỉnh lại số lần lặp.*/
    static double squareRoot(double number) {
        double S = number;
        double a = S;
        int n = 0;

        while (a / 100.0 > 100.0) {
            a = a / 100.0;
            n++;
        }
        a = a < 10.0 ? 2.0 : 6.0;
        final double epsilon = 0.00001;
//        double x0 = a * Math.pow(10.0, n);
//        double x1 = 1.0 / 2.0 * (x0 + S / x0);
//        while (Math.abs(x0 - x1) > epsilon) {
//            x0 = x1;
//            x1 = 1.0 / 2.0 * (x0 + S / x0);
//        }
        double x0 = a * Math.pow(10.0, n);
        double x1=0.0;
        do {
            x0 = x1;
            x1 = 1.0 / 2.0 * (x0 + S / x0);
        }while (Math.abs(x0 - x1) > epsilon);
        return x0;
    }

    public static void main(String[] args) {
        System.out.println(squareRoot(9));
    }
}
