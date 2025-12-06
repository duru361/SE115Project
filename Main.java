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
        for(int i=0;i<COMMS;i++){
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
        for(int i=0;i<COMMS;i++){
            totalProfit+=data[month][day][i];
        }
        return totalProfit;
       }

        public static int commodityProfitInRange(String commodity, int from, int to) {
            int totalProfit=0;
            int comNum=-1;

            for(int i=0;i<COMMS;i++) {
                if (commodity==commodities[i]) {
                    comNum=i;
                    break;
                }
            }
            if(comNum==-1) return -99999;

            if(from<0||from>27||to<0||to>27||from>to) {
                return -99999;
            }

            for(int month=0;month<MONTHS;month++) {
                for (int i = from; i < to; i++) {
                    totalProfit += data[month][i][comNum];
                }
            }
            return totalProfit;
        }

        public static int bestDayOfMonth(int month) {
            if(month<0||month>11) return -1;
            int profit[]=new int[DAYS];
            int highestProfitDay=0;
            for(int day=0;day<DAYS;day++){
                for(int com=0;com<COMMS;com++){
                    profit[day]+=data[month][day][com];
                }
            }
            int highestProfit=profit[0];
            for(int i=1;i<DAYS;i++){
                if(profit[i]>highestProfit){
                    highestProfit=profit[i];
                    highestProfitDay=i;
                }
            }
            return highestProfitDay+1;
        }
    
        public static String bestMonthForCommodity(String comm) {
            int comNum = -1;
            int highestProfitMonth = 0;
            int monthsProfit[] = new int[MONTHS];
            for (int i = 0; i < 5; i++) {
                if (commodities[i] == comm) {
                    comNum = i;
                    break;
                }
            }
            if (comNum == -1) return "INVALID_COMMODITY";

            for (int month = 0; month < MONTHS; month++) {
                for (int day = 0; day < DAYS; day++) {
                    monthsProfit[month] += data[month][day][comNum];
                }
            }
            int highestProfit =monthsProfit[0];
            for (int i = 1; i <MONTHS; i++) {
                if (monthsProfit[i] > highestProfit) {
                    highestProfit = monthsProfit[i];
                    highestProfitMonth = i;
                }
            }
            return months[highestProfitMonth];
        }

        public static int consecutiveLossDays (String comm){
            int comNum=-1;
            for(int i=0;i<COMMS;i++){
                if(comm==commodities[i]) {
                    comNum = i;
                    break;
                }
            }
            if(comNum==-1){
                return -1;
            }
            int lossStreak=0;
            int longestStreak=0;
            for(int month=0;month<MONTHS;month++){
                for(int day=0;day<DAYS;day++){
                    if(data[month][day][comNum]<0){
                        lossStreak++;
                    }
                    else lossStreak=0;

                    if(lossStreak>longestStreak){
                        longestStreak=lossStreak;
                    }
                }
            }
            return longestStreak;
        }

        public static int daysAboveThreshold (String comm,int threshold){
         int thresholdDay=0;
         int comNum=-1;
         for(int i=0;i<COMMS;i++){
             if(comm==commodities[i]){
                 comNum=i;
                 break;
             }
         }
         if(comNum==-1) return -1;

         for(int month=0;month<MONTHS;month++){
             for(int day=0;day<DAYS;day++){
                 if(data[month][day][comNum]>threshold){
                     thresholdDay++;
                 }
             }
         }
            return thresholdDay;
        }

        public static int biggestDailySwing ( int month){
        if(month<0||month>11) return -99999;
        int profits[]=new int[DAYS];
        int dailySwing[]=new int[DAYS];
        for(int days=0;days<DAYS;days++){
            for(int com=0;com<COMMS;com++){
                profits[days]+=data[month][days][com];
            }
        }
        for(int i=0;i<DAYS-1;i++){
            dailySwing[i]=profits[i+1]-profits[i];
            if(dailySwing[i]<0){
                dailySwing[i]*=-1;
            }
        }
        int biggest=dailySwing[0];
        for(int i=1;i<DAYS-1;i++){
            if(dailySwing[i]>biggest){
                biggest=dailySwing[i];
            }
        }
            return biggest;
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