import java.util.Scanner;

    /****
    This program prompts the user to enter a month (1-12) and a four-digit year 
    (e.g. 2012) and then displays a calendar for that month and year.
    @paramvalue1 is the month entry
    @paramvalue2 is the year entry
    @return is the calendar for that month and year
    
    Pre-conditions: month and year are integer types.
                    year is a four-digit integer.
    
    Post-conditions: output should be a calendar with dates specified in 
    correct order.
    ****/    

public class MonthCalendar
{
    /****
    The isLeapYear() method returns true if the specified year is a leap year,
    and returns false otherwise.
    ****/
    
    public static boolean isLeapYear(int year)
    {   
        boolean leap;
        if (year % 400==0)
            leap = true;
        else if ((year % 4==0) & (year % 100!=0))
            leap = true;
        else
            leap = false;
        return leap;
    }
    
    /****
    The getNumDaysinMonth() method returns the number of days in a specified
    month and year.  Leap years are accounted for.
    ****/
    
    public static int getNumDaysinMonth(int month, int year)
    {
        int NumDays;
        
        if (month==1 || month==3 || month==5 || month==7 || month==8|| month==10 || month==12)
            NumDays = 31;
        else if(month==4 || month==6 || month==9 || month==11)
            NumDays = 30;
        else if((month==2) && (isLeapYear(year)==false))
            NumDays = 28;
        else
            NumDays = 29;
        
        return NumDays;
    }
    
    /****
    The getMonthName() method returns the name of the month for a 
    specified month number (e.g. returns March for m=3)
    ****/
    
    public static String getMonthName(int month)
    {
        String Monthname;
        
        if(month==1)
            Monthname = "January";
        else if (month==2)
            Monthname = "February";
        else if (month==3)
            Monthname = "March";
        else if (month==4)
            Monthname = "April";
        else if (month==5)
            Monthname = "May";
        else if (month==6)
            Monthname = "June";
        else if (month==7)
            Monthname = "July";
        else if (month==8)
            Monthname = "August";
        else if (month==9)
            Monthname = "September";
        else if (month==10)
            Monthname = "October";
        else if (month==11)
            Monthname = "November";
        else
            Monthname = "December";
        
        return Monthname;
    }
    
    /****
    The method getStartDay() implements Zeller's Algorithm for determining the
    day of the week the first day of a month is. The method adjusts Zeller's
    numbering scheme for day of week ( 0=Saturday, ..., 6=Friday ) to conform
    to a day of week number that corresponds to ISO conventions (i.e.,
    1=Monday, ..., 7=Sunday)
    
    Pre-Conditions: The month value, m,  is 1-12
                    The year value, y, is the full year (e.g., 2012)
                  
    Post-Conditions: A value of 1-7 is returned, representing the first day of
    the month: 1 = Monday, ..., 7 = Sunday
    ****/
        
    public static int getStartDay(int month,int year)
    {
        final int day = 1; // Must be set to day 1 for this to work.


        // Adjust month number & year to fit Zeller's numbering system
        if ( month < 3 ) 
        {
            month = month + 12;
            year = year - 1;
        }
        
        int yearInCent = year % 100;      // k Calculate year within century
        int century = year / 100;      // j Calculate century term
        int firstDay  = 0;            // h Day number of first day in month 'm'
        
        firstDay = (day + (13 * (month + 1) / 5) + yearInCent +
            (yearInCent / 4) + (century / 4) + (5 * century)) % 7;
        
        // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
        int dayNum = ((firstDay + 5) % 7) + 1;     
        
        return dayNum;
    }
    
    /****
    The printMonthBody method below displays the days in the calendar associated
    with the corresponding days of the week
    ****/
    
    public static void printMonthBody(int month, int year)
    {
        
        if (getStartDay(month,year) == 7 & getNumDaysinMonth(month, year)==31)
        {
            System.out.println("  1   2   3   4   5   6   7");
            System.out.println("  8   9  10  11  12  13  14");
            System.out.println(" 15  16  17  18  19  20  21");
            System.out.println(" 22  23  24  25  26  27  28");
            System.out.println(" 29  30  31 ");            
        }
        
        else if (getStartDay(month,year) == 7 & getNumDaysinMonth(month, year)==30)
        {
            System.out.println("  1   2   3   4   5   6   7");
            System.out.println("  8   9  10  11  12  13  14");
            System.out.println(" 15  16  17  18  19  20  21");
            System.out.println(" 22  23  24  25  26  27  28");
            System.out.println(" 29  30");            
        }
        
        else if (getStartDay(month,year) == 7 & getNumDaysinMonth(month, year)==29)
        {
            System.out.println("  1   2   3   4   5   6   7");
            System.out.println("  8   9  10  11  12  13  14");
            System.out.println(" 15  16  17  18  19  20  21");
            System.out.println(" 22  23  24  25  26  27  28");
            System.out.println(" 29");            
        }
        
        else if (getStartDay(month,year) == 7 & getNumDaysinMonth(month, year)==28)
        {
            System.out.println("  1   2   3   4   5   6   7");
            System.out.println("  8   9  10  11  12  13  14");
            System.out.println(" 15  16  17  18  19  20  21");
            System.out.println(" 22  23  24  25  26  27  28");            
        }
        
        else if (getStartDay(month,year) == 1 & getNumDaysinMonth(month, year)==31)
        {
            System.out.println("      1   2   3   4   5   6");
            System.out.println("  7   8   9  10  11  12  13");
            System.out.println(" 14  15  16  17  18  19  20");
            System.out.println(" 21  22  23  24  25  26  27");
            System.out.println(" 28  29  30  31");            
        }
        
        else if (getStartDay(month,year) == 1 & getNumDaysinMonth(month, year)==30)
        {
            System.out.println("      1   2   3   4   5   6");
            System.out.println("  7   8   9  10  11  12  13");
            System.out.println(" 14  15  16  17  18  19  20");
            System.out.println(" 21  22  23  24  25  26  27");
            System.out.println(" 28  29  30");             
        }
        
        else if (getStartDay(month,year) == 1 & getNumDaysinMonth(month, year)==28)
        {
            System.out.println("      1   2   3   4   5   6");
            System.out.println("  7   8   9  10  11  12  13");
            System.out.println(" 14  15  16  17  18  19  20");
            System.out.println(" 21  22  23  24  25  26  27");
            System.out.println(" 28");            
        }
        
        else if (getStartDay(month,year) == 1 & getNumDaysinMonth(month, year)==29)
        {
            System.out.println("      1   2   3   4   5   6");
            System.out.println("  7   8   9  10  11  12  13");
            System.out.println(" 14  15  16  17  18  19  20");
            System.out.println(" 21  22  23  24  25  26  27");
            System.out.println(" 28  29");            
        }
        
        else if (getStartDay(month,year) == 2 & getNumDaysinMonth(month, year)==31)
        {
            System.out.println("          1   2   3   4   5");
            System.out.println("  6   7   8   9  10  11  12");
            System.out.println(" 13  14  15  16  17  18  19");
            System.out.println(" 20  21  22  23  24  25  26");
            System.out.println(" 27  28  29  30  31");            
        }
        
        else if (getStartDay(month,year) == 2 & getNumDaysinMonth(month, year)==30)
        {
            System.out.println("          1   2   3   4   5");
            System.out.println("  6   7   8   9  10  11  12");
            System.out.println(" 13  14  15  16  17  18  19");
            System.out.println(" 20  21  22  23  24  25  26");
            System.out.println(" 27  28  29  30");            
        }
        
        else if (getStartDay(month,year) == 2 & getNumDaysinMonth(month, year)==28)
        {
            System.out.println("          1   2   3   4   5");
            System.out.println("  6   7   8   9  10  11  12");
            System.out.println(" 13  14  15  16  17  18  19");
            System.out.println(" 20  21  22  23  24  25  26");
            System.out.println(" 27  28");            
        }
        
        else if (getStartDay(month,year) == 3 & getNumDaysinMonth(month, year)==31)
        {
            System.out.println("              1   2   3   4");
            System.out.println("  5   6   7   8   9  10  11");
            System.out.println(" 12  13  14  15  16  17  18");
            System.out.println(" 19  20  21  22  23  24  25");
            System.out.println(" 26  27  28  29  30  31");            
        }
        
        else if (getStartDay(month,year) == 3 & getNumDaysinMonth(month, year)==30)
        {
            System.out.println("              1   2   3   4");
            System.out.println("  5   6   7   8   9  10  11");
            System.out.println(" 12  13  14  15  16  17  18");
            System.out.println(" 19  20  21  22  23  24  25");
            System.out.println(" 26  27  28  29  30");            
        }
        
        else if (getStartDay(month,year) == 3 & getNumDaysinMonth(month, year)==29)
        {
            System.out.println("              1   2   3   4");
            System.out.println("  5   6   7   8   9  10  11");
            System.out.println(" 12  13  14  15  16  17  18");
            System.out.println(" 19  20  21  22  23  24  25");
            System.out.println(" 26  27  28  29");            
        }
        
        else if (getStartDay(month,year) == 3 & getNumDaysinMonth(month, year)==28)
        {
            System.out.println("              1   2   3   4");
            System.out.println("  5   6   7   8   9  10  11");
            System.out.println(" 12  13  14  15  16  17  18");
            System.out.println(" 19  20  21  22  23  24  25");
            System.out.println(" 26  27  28");            
        }
        
        else if (getStartDay(month,year) == 4 & getNumDaysinMonth(month, year)==31)
        {
            System.out.println("                  1   2   3");
            System.out.println("  4   5   6   7   8   9  10");
            System.out.println(" 11  12  13  14  15  16  17");
            System.out.println(" 18  19  20  21  22  23  24");
            System.out.println(" 25  26  27  28  29  30  31");            
        }
        
        else if (getStartDay(month,year) == 4 & getNumDaysinMonth(month, year)==30)
        {
            System.out.println("                  1   2   3");
            System.out.println("  4   5   6   7   8   9  10");
            System.out.println(" 11  12  13  14  15  16  17");
            System.out.println(" 18  19  20  21  22  23  24");
            System.out.println(" 25  26  27  28  29  30");            
        }
        
        else if (getStartDay(month,year) == 4 & getNumDaysinMonth(month, year)==29)
        {
            System.out.println("                  1   2   3");
            System.out.println("  4   5   6   7   8   9  10");
            System.out.println(" 11  12  13  14  15  16  17");
            System.out.println(" 18  19  20  21  22  23  24");
            System.out.println(" 25  26  27  28  29");            
        }
        
        else if (getStartDay(month,year) == 4 & getNumDaysinMonth(month, year)==28)
        {
            System.out.println("                  1   2   3");
            System.out.println("  4   5   6   7   8   9  10");
            System.out.println(" 11  12  13  14  15  16  17");
            System.out.println(" 18  19  20  21  22  23  24");
            System.out.println(" 25  26  27  28");            
        }
        
        else if (getStartDay(month,year) == 5 & getNumDaysinMonth(month, year)==31)
        {
            System.out.println("                      1   2");
            System.out.println("  3   4   5   6   7   8   9");
            System.out.println(" 10  11  12  13  14  15  16");
            System.out.println(" 17  18  19  20  21  22  23");
            System.out.println(" 24  25  26  27  28  29  30");       
            System.out.println(" 31");       
        }
        
        else if (getStartDay(month,year) == 5 & getNumDaysinMonth(month, year)==30)
        {
            System.out.println("                      1   2");
            System.out.println("  3   4   5   6   7   8   9");
            System.out.println(" 10  11  12  13  14  15  16");
            System.out.println(" 17  18  19  20  21  22  23");
            System.out.println(" 24  25  26  27  28  29  30");              
        }
        
        else if (getStartDay(month,year) == 5 & getNumDaysinMonth(month, year)==29)
        {
            System.out.println("                      1   2");
            System.out.println("  3   4   5   6   7   8   9");
            System.out.println(" 10  11  12  13  14  15  16");
            System.out.println(" 17  18  19  20  21  22  23");
            System.out.println(" 24  25  26  27  28  29");       
        }
        
        else if (getStartDay(month,year) == 5 & getNumDaysinMonth(month, year)==28)
        {
            System.out.println("                      1   2");
            System.out.println("  3   4   5   6   7   8   9");
            System.out.println(" 10  11  12  13  14  15  16");
            System.out.println(" 17  18  19  20  21  22  23");
            System.out.println(" 24  25  26  27  28");       
        }
        
        else if (getStartDay(month,year) == 6 & getNumDaysinMonth(month, year)==31)
        {
            System.out.println("                          1");
            System.out.println("  2   3   4   5   6   7   8");
            System.out.println("  9  10  11  12  13  14  15");
            System.out.println(" 16  17  18  19  20  21  22");
            System.out.println(" 23  24  25  26  27  28  29");       
            System.out.println(" 30  31");       
        }
        
        else if (getStartDay(month,year) == 6 & getNumDaysinMonth(month, year)==30)
        {
            System.out.println("                          1");
            System.out.println("  2   3   4   5   6   7   8");
            System.out.println("  9  10  11  12  13  14  15");
            System.out.println(" 16  17  18  19  20  21  22");
            System.out.println(" 23  24  25  26  27  28  29");       
            System.out.println(" 30");       
        }
        
        else if (getStartDay(month,year) == 6 & getNumDaysinMonth(month, year)==29)
        {
            System.out.println("                          1");
            System.out.println("  2   3   4   5   6   7   8");
            System.out.println("  9  10  11  12  13  14  15");
            System.out.println(" 16  17  18  19  20  21  22");
            System.out.println(" 23  24  25  26  27  28  29");           
        }
        
        else
        {
            System.out.println("                          1");
            System.out.println("  2   3   4   5   6   7   8");
            System.out.println("  9  10  11  12  13  14  15");
            System.out.println(" 16  17  18  19  20  21  22");
            System.out.println(" 23  24  25  26  27  28");           
        }
       
    }
    
    /****
    The printMonthHeader() method displays the header information (month, year, 
    line separator, 3-character day names) for a calendar
    ****/
    
    public static void printMonthHeader(int month, int year)
    {
        System.out.println("       " + getMonthName(month) + "  " + year + "       ");
        System.out.println("_____________________________");
        System.out.println("Sun " + "Mon " + "Tue " + "Wed " + "Thu " + "Fri " + "Sat ");   
    }
    
    public static void printMonthCalendar(int month, int year)
    
    {    
        printMonthHeader(month, year);
        printMonthBody(month, year);
    }
    
    /****
    The main method below prompts the user to enter month and year 
    and calls the printMonthCalendar() method
    ****/
    
    public static void main(String[] args)
    {
        int month;
        int year;


        Scanner input = new Scanner(System.in);
        System.out.print("Enter a month number from 1 to 12: ");
        month = input.nextInt();
        
        System.out.print("Enter a random 4-digit year: ");
        year = input.nextInt();

        printMonthCalendar(month, year); // Print the calendar. JRD.
    }
}

