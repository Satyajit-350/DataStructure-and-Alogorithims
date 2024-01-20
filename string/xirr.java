package string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class xirr {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine(); 

        double[] payments = new double[N];
        Date[] dates = new Date[N];

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            payments[i] = Double.parseDouble(input[0]);
            try {
                dates[i] = dateFormat.parse(input[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    
        double ans = calculateXIRR(payments, dates);

        System.out.printf("%.2f\n", ans * 100);

    }

     private static double calculateXIRR(double[] payments, Date[] dates) {
        double guess = 0.1; 
        double epsilon = 1e-6; 
        int maxIterations = 1000; 

        for (int i = 0; i < maxIterations; i++) {
            double xirr = calculateXIRR(payments, dates, guess);
            double derivative = calculateXIRRDerivative(payments, dates, guess);

            guess -= xirr / derivative;

            if (Math.abs(xirr) < epsilon) {
                return guess;
            }
        }
        return Double.NaN;
    }

    private static double calculateXIRR(double[] payments, Date[] dates, double rate) {
        double result = 0.0;

        for (int i = 0; i < payments.length; i++) {
            double days = (dates[i].getTime() - dates[0].getTime()) / (1000.0 * 60 * 60 * 24);
            result += payments[i] / Math.pow(1.0 + rate, days / 365.0);
        }

        return result;
    }
    
    private static double calculateXIRRDerivative(double[] payments, Date[] dates, double rate) {
        double result = 0.0;

        for (int i = 0; i < payments.length; i++) {
            double days = (dates[i].getTime() - dates[0].getTime()) / (1000.0 * 60 * 60 * 24);
            result -= (days / 365.0) * payments[i] / Math.pow(1.0 + rate, days / 365.0 + 1.0);
        }

        return result;
    }

}
