public class PenDistribution {
    public static void main(String[] args) {
        int tP = 14;// TOTAL PENS
        int tS = 3;// TOTAL STUDENTS
        int pensPerStudent = tP / tS;
        int remainingPens = tP % tS;
        System.out.println("The Pen Per Student is " + pensPerStudent +
                " and the remaining pen not distributed is " + remainingPens);
    }
}
