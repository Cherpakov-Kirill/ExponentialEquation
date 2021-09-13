public class AnswerFinder {
    private final int delta = 1;
    private final double epsilon = 1e-12;
    private final double a;
    public int countOfAnswers;
    public double firstAnswer;
    public double secondAnswer;

    private double distance(double currentX) {
        return Math.exp(currentX) - currentX - a;
    }

    private Interval findInterval(int delta) {
        int start = 0;
        boolean expBiggerXPlusA = Math.exp(start) < start + a;
        int currentX = start;
        while (expBiggerXPlusA == Math.exp(currentX) < currentX + a) {
            currentX += delta;

        }
        if (Math.exp(currentX) == currentX + a) System.out.println(currentX + " - this is answer");
        else if (delta > 0) {
            Interval area = new Interval((currentX - delta), currentX);
            System.out.println(area);
            return area;
        } else {
            Interval area = new Interval(currentX, (currentX - delta));
            System.out.println(area);
            return area;
        }
        return null;
    }
    AnswerFinder(double a){
        this.a = a;
        countOfAnswers = 0;
        firstAnswer = 2;
        secondAnswer = -2;
        if (Math.exp(0) > a) {
            System.out.println("Have not answer");
        } else if (Math.exp(0) < a) {
            Interval first = findInterval(delta);
            Interval second = findInterval(-delta);
            countOfAnswers = 2;
            if (first != null) {
                double c = (first.a + first.b) / 2;
                double distance = distance(c);
                while (Math.abs(distance(c)) > epsilon) {
                    if (distance < -epsilon) first.a = c;
                    if (distance > epsilon) first.b = c;
                    c = (first.a + first.b) / 2;
                    distance = distance(c);
                }
                firstAnswer = c;
                System.out.println("Answer 1: " + c);
                System.out.println("exp(x) = " + Math.exp(c));
                System.out.println("x + a  = " + (c + a));
            }
            if (second != null) {
                double c = (second.a + second.b) / 2;
                double distance = distance(c);
                while (Math.abs(distance(c)) > epsilon) {
                    if (distance < -epsilon) second.b = c;
                    if (distance > epsilon) second.a = c;
                    c = (second.a + second.b) / 2;
                    distance = distance(c);
                }
                secondAnswer = c;
                System.out.println("Answer 2: " + c);
                System.out.println("exp(x) = " + Math.exp(c));
                System.out.println("x + a  = " + (c + a));
            }
        } else if (Math.exp(0) == a) {
            countOfAnswers = 1;
            firstAnswer = 0;
            secondAnswer = 0;
            System.out.println(0 + " - this is answer");
        }
    }
}
