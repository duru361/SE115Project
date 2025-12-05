// Main.java — Students version
import java.io.*;
import java.util.*;

public class Main {
    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;
    static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = {"January","February","March","April","May","June",
                              "July","August","September","October","November","December"};
    public static int[][][] data =new int[12][28][5];

    // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
    public static void loadData() {

    }

    // ======== 10 REQUIRED METHODS (Students fill these) ========

    public static String mostProfitableCommodityInMonth(int month) {
        if(month<0||month>11){
            return "INVALID_MONTH";
        }
        int sum[]=new int[5];
        for(int i=0;i<28;i++){
            for(int j=0;j<5;j++){
                sum[j]+=data[month][i][j];
            }
        }
        int maxCom=0;
        int maxProfit=0;
        for(int i=0;i<5;i++){
            if(sum[i]>maxProfit){
                maxCom=i;
                maxProfit=sum[i];
            }
        }
        return commodities[maxCom]+" "+maxProfit;
    }

    public static int totalProfitOnDay(int month, int day) {
        int totalProfit=0;
        if(month<0||month>11||day<0||day>27){
            return -99999;
        }
        for(int i=0;i<5;i++){
            totalProfit+=data[month][day][i];
        }
        return totalProfit;
       }

        public static int commodityProfitInRange(String commodity, int from, int to) {
            int totalProfit=0;
            int comNum=0;

            for(int i=0;i<5;i++) {
                if (commodity==commodities[i]) {
                    comNum=i;
                    break;
                }
            }
            if(comNum==-1) return -99999;

            if(from<0||from>27||to<0||to>27||from>to) {
                return -99999;
            }

            for(int month=0;month<12;month++) {
                for (int i = from; i < to; i++) {
                    totalProfit += data[month][i][comNum];
                }
            }
            return totalProfit;
        }

        public static int bestDayOfMonth(int month) {
            if(month<0||month>11) return -1;
            int profit[]=new int[28];
            int highestProfitDay=0;
            for(int day=0;day<28;day++){
                for(int com=0;com<5;com++){
                    profit[day]+=data[month][day][com];
                }
            }
            int highestProfit=profit[0];
            for(int i=1;i<28;i++){
                if(profit[i]>highestProfit){
                    highestProfit=profit[i];
                    highestProfitDay=i;
                }
            }
            return highestProfitDay+1;
        }
    
        public static String bestMonthForCommodity(String comm) {
           return "DUMMY";
        }

        public static int consecutiveLossDays (String comm){
           return 1234;
        }

        public static int daysAboveThreshold (String comm,int threshold){
            return 1234;
        }

        public static int biggestDailySwing ( int month){
            return 1234;
        }

        public static String compareTwoCommodities (String c1, String c2){
            return "DUMMY is better by 1234";
        }

        public static String bestWeekOfMonth ( int month){
            return "DUMMY";
        }

        public static void main (String[]args){
            loadData();
            System.out.println("Data loaded – ready for queries");
        }

}