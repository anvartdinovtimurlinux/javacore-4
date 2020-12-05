public class Main {

    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        Integer c = null;
        try {
            c = calc.devide.apply(a, b);
            // Здесь мы делим на ноль
            // Менять код Калькулятора и вставлять туда проверки - плохая идея
            // Поэтому опасный код заключаю в try-catch
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя");
        }

        calc.println.accept(c);
    }

}
