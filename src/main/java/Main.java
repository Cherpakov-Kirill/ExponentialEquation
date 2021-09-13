public class Main {

    public static void startCalculations(double a){
        AnswerFinder solution = new AnswerFinder(a);
        ChartBuilder chart = new ChartBuilder(a, solution);
    }

    public static void main(String[] args) {
        new GetValueFrame();
    }
}