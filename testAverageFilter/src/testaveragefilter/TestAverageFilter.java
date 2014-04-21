/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaveragefilter;

import java.util.Random;

/**
 *
 * @author grr340
 */
public class TestAverageFilter {

    int input;
    public static int loopcounter = 0;
   public static double currentAverage=666;
     
    public static double[] unfiltered = new double[10];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        setMax(unfiltered);
        for (int i = 0; i < 1000; i++) {
            System.out.print(getAverageFilteredUltrasonic());
        }
    }

    public static double getAverageFilteredUltrasonic() {
        Random randomGenerator = new Random();
        double returned;
        double sum = 0;
         double filterme=randomGenerator.nextDouble()*100;
        if (loopcounter == 10) {
            loopcounter = 0;
        }
        if(isGoodNumber(filterme)==true){
            unfiltered[loopcounter]=filterme;
        }
        
        
        for (int i = 0; i < arrayCounter(unfiltered); i++) {
            sum += unfiltered[i];
        }
        System.out.println((sum / arrayCounter(unfiltered)));
        loopcounter++;
        currentAverage=sum / arrayCounter(unfiltered);
        return currentAverage;

    }

    public static int arrayCounter(double[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 100000) {
                count++;
            } else {
                System.out.println(count);
                return count;

            }
            
        }
        return count;
    }

    

    public static void setMax(double[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 100000;
        }
        unfiltered = a;
    }
     public static boolean isGoodNumber(double test) {
        if (test < 0) {
            return false;
        }
        if(currentAverage!=666){
        if(test + 2 >= currentAverage
                || test - 2 <= currentAverage) {
        } else {
            return false;
        }
        }
        return true;
    }

}
