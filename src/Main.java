import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0.0");
    static int midWeight, finalWeight, hwWeight;
    static double midWeightedScore, finalWeightedScore, hwWeightedScore;

    public static void main(String[] args) {
        begin();
        midterm();
        finalTerm();
        homework();
        report();
    }

    //Main methods
    private static void begin() {
        //TODO: Greetings
        System.out.println("This program reads exam/homework " +
                "scores and reports your overall course grade");
    }

    private static void midterm() {
        int scoreEarned, wereScoreShifted, shiftAmount, totalPoints;
        int maxScore = 100;

        System.out.println("Midterm:");

        //weight
        midWeight = setWeight();

        //score earned
        System.out.print("Score earned? ");
        scoreEarned = scanner.nextInt();

        //were score shifted?
        wereScoreShifted = setScoreShifted(); //to choose between 1=yes, 2=no
        shiftAmount = doScoreShift(wereScoreShifted);

        //total point
        totalPoints = calTotalPoint(scoreEarned, shiftAmount);
        printTotalPoints(totalPoints);
        System.out.println();

        //weighted score
        midWeightedScore = calWeightedScore(maxScore, totalPoints, midWeight);
        printWeightedScore(midWeightedScore, midWeight);

        System.out.println();
    }

    private static void finalTerm() {
        int scoreEarned, wereScoreShifted, shiftAmount, totalPoints, maxScore = 100;

        System.out.println();
        System.out.println("Final:");

        //weight
        finalWeight = setWeight();

        //score earned
        System.out.print("Score earned? ");
        scoreEarned = scanner.nextInt();

        //were score shifted?
        wereScoreShifted = setScoreShifted(); //to choose between 1=yes, 2=no
        shiftAmount = doScoreShift(wereScoreShifted);

        //total point
        totalPoints = calTotalPoint(scoreEarned, shiftAmount);
        printTotalPoints(totalPoints);
        System.out.println();

        //weighted score
        finalWeightedScore = calWeightedScore(maxScore, totalPoints, finalWeight);
        printWeightedScore(finalWeightedScore, finalWeight);

        System.out.println();
    }

    private static void homework() {
        int numOfAsm, numOfAttendance, sectionPoint;
        int[][] asmScoreAndMax;
        int maxSectionPoint = 30;

        System.out.println();
        System.out.println("Homework:");

        //weight
        hwWeight = setWeight();

        //Num of assignment
        System.out.print("Number of assignments? ");
        numOfAsm = scanner.nextInt();
        asmScoreAndMax =setAsmScoreAndMax(numOfAsm);

        //Num of attendances
        System.out.print("How many sections did you attend? ");
        numOfAttendance = scanner.nextInt();
        
        //Section Points (diem chuyen can): 1 buoi x 5, max = 30
        sectionPoint = calSectionPoint(numOfAttendance, maxSectionPoint);
        System.out.println("Section points = " + sectionPoint + " / " + maxSectionPoint);
        
        //total Points
            //get asms points
        int asmPoints = 0;
        int maxAsmPoints = 0;
        for (int i = 0; i < numOfAsm; i++) {
            asmPoints += asmScoreAndMax[i][0];
            maxAsmPoints += asmScoreAndMax[i][1];
        }
        int totalPoints = asmPoints + sectionPoint;
        int maxScore = maxAsmPoints + maxSectionPoint;
        System.out.println("Total points = " + totalPoints + " / " + maxScore);

        //weighted score
        hwWeightedScore = calWeightedScore(maxScore, totalPoints, hwWeight);
        printWeightedScore(hwWeightedScore, hwWeight);

        System.out.println();
    }

    private static void report() {
        double minGPA;

        System.out.println();

        //overall percentage
        double totalWeightedScore = midWeightedScore + finalWeightedScore + hwWeightedScore;
        String overallPercentage = df.format(totalWeightedScore);
        System.out.println("Overall percentage: " + overallPercentage);

        //cal min grade;
        if (totalWeightedScore >= 85.0) {
            minGPA = 3.0;
        } else if (totalWeightedScore < 85.0 || totalWeightedScore >= 75) {
            minGPA = 2.0;
        } else if (totalWeightedScore < 75 || totalWeightedScore >= 60) {
            minGPA = 0.7;
        } else {
            minGPA = 0.0;
        }

        System.out.println("Your grade will be ate least: " + minGPA);
        System.out.println("<<your custom grade message here>>");
    }

    //Side methods

    private static int calSectionPoint(int numOfAttendance, int maxSectionPoint) {
        int total;
        total = numOfAttendance * 5;
        if(total >= maxSectionPoint) {
            total = maxSectionPoint;
        }
        return total;
    }
    private static double calWeightedScore(int maxScore, int totalPoints, int weight) {
        return ((double) totalPoints / maxScore) * weight;
    }
    private static int calTotalPoint(int scoreEarned, int shiftAmount) {
        int totalPoints = scoreEarned + shiftAmount;
        if(totalPoints > 100) {
            totalPoints = 100;
        }
        return totalPoints;
    }

    private static int setWeight(){
        int weight;
        while (true) {
            System.out.print("Weight (0 - 100)? ");
            weight = scanner.nextInt();
            if (true) {
                if (weight >= 0 && weight <= 100) {
                    break;
                } else {
                    inputIncorrect();
                }
            }
        }
        return weight;
    }
    private static int setScoreShifted() {
        int wereScoreShifted;
        while (true) {
            System.out.print("Were score shifted (1=yes, 2=no)? ");
            wereScoreShifted = scanner.nextInt();
            if (wereScoreShifted == 1 || wereScoreShifted == 2) {
                break;
            } else {
                inputIncorrect();
            }
        }
        return wereScoreShifted;
    }
    private static int[][] setAsmScoreAndMax(int numOfAsm) {
        int[][] asmScoreAndMax = new int[numOfAsm][2];
        for (int i = 0; i < numOfAsm; i++) {
            System.out.print("Assignment " + (i + 1) + " score and max? ");
            for (int j = 0; j <= 1; j++) {
                asmScoreAndMax[i][j] = scanner.nextInt();
            }
        }
        return asmScoreAndMax;
    }

    private static int doScoreShift(int wereScoreShifted) {
        int shiftAmount = 0;
        switch (wereScoreShifted) {
            case 1 -> {
                System.out.print("Shift amount? ");
                shiftAmount = scanner.nextInt();
            }
            case 2 -> {
            }
        }
        return shiftAmount;
    }
    private static void inputIncorrect() {
        System.out.println("You have input an incorrect value, please input again");
    }

    private static void printWeightedScore(double weightedScore, int weight) {
        String weightedScoreDF = df.format(weightedScore);
        System.out.print("Weight score = " + weightedScoreDF + "/" + weight);
    }
    private static void printTotalPoints(int totalPoints) {
        System.out.print("Total points = " + totalPoints + "/100");
    }


}
