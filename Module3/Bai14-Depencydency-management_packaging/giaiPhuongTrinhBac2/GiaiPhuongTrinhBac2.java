public class GiaiPhuongTrinhBac2 {
    private double a, b, c;

    public GiaiPhuongTrinhBac2() {
    }

    public GiaiPhuongTrinhBac2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double tinhDelta() {
        return b * b - 4 * a * c;
    }

    //nghiem thu1
    public double tinhNghiem1() {
        double del = tinhDelta();
        if (del >= 0) {
            return (-b + Math.sqrt(del)) / (2 * a);
        } else {
            return Double.NaN;
        }
    }

    //nghiem thu2
    public double tinhNghiem2() {
        double del = tinhDelta();
        if (del >= 0) {
            return (-b - Math.sqrt(del)) / (2 * a);
        } else {
            return Double.NaN;
        }
    }

    //ket qua
    public void displayResult() {
        double del = tinhDelta();
        if (a == 0) {
            System.out.println("Khong phải phương trinh bac 2");
        } else if (del > 0) {
            System.out.println("x1 = " + tinhNghiem1() + " x2 = " + tinhNghiem2());
        } else if (del == 0) {
            System.out.println("x1 = " + tinhNghiem1());
        } else {
            System.out.println("Vo nghiem");
        }
    }
}
