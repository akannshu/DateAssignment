class Date{

    private int day;
    private int month;
    private int year;
    private int[] numberOfDaysInMonth = {-1,31,28,31,30,31,30,31,31,30,31,30,31}; 

    private boolean checkLeapYear(int year){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ;
    }

    private int numberOfDaysLeftInCurrentMonth(){
        return numberOfDaysInMonth[month] - day;
    }

    private int numberOfDaysLeftInYear(){
        
        int numberOfDaysLeft = numberOfDaysLeftInCurrentMonth();
        int k = month+1;

        for(int i=k; i<numberOfDaysInMonth.length; i++){
            numberOfDaysLeft+=numberOfDaysInMonth[i];
        }

        return numberOfDaysLeft;
    }

    private void findDateAndMonth(int dateOfNDaysAhead){

        for(int i=month; i<numberOfDaysInMonth.length; i++){

            if(dateOfNDaysAhead <= numberOfDaysInMonth[i]){

                System.out.println(dateOfNDaysAhead+"-"+i+"-"+year);
                return;
            }

            dateOfNDaysAhead-=numberOfDaysInMonth[i];
        }
    }


    public void getTodaysDate(){
        System.out.println(day+"-"+month+"-"+year);
    }

    public void setTodaysDate(int day, int month, int year){

        boolean isLeapYear = false;

        if(year<1900){
            System.out.println("You Entered wrong year ");
            return;
        }

        else{
                isLeapYear = checkLeapYear(year);

                if(isLeapYear){
                    numberOfDaysInMonth[2] = 29;
                }
                else{
                    numberOfDaysInMonth[2] = 28;
                }
        }

        if(month>12){
            System.out.println("You Entered wrong month ");
            return;            
        }

        if(day>31){
            System.out.println("You Entered wrong day ");
        }

        if(day>28){
            if(day==29 && month==2){
                if(isLeapYear==false){
                    System.out.println("You Entered wrong day ");
                }
            }
        }
    
        this.day = day;
        this.month = month;
        this.year = year;
    }



    public void getDateOfNDaysAhead(int dateOfNDaysAhead){

        int daysLeftInMonth = numberOfDaysLeftInCurrentMonth();
        int daysLeftInYear = numberOfDaysLeftInYear();

        if(dateOfNDaysAhead <= daysLeftInMonth){
            System.out.println(day+dateOfNDaysAhead+"-"+month+"-"+year);
            return;
        }
        

        if(dateOfNDaysAhead <= daysLeftInYear){

            daysLeftInYear-=daysLeftInMonth;
            dateOfNDaysAhead-=daysLeftInMonth;
            ++month;

            findDateAndMonth(dateOfNDaysAhead);

        }

        if(dateOfNDaysAhead>daysLeftInYear){
          
            dateOfNDaysAhead-=daysLeftInYear;
            ++year;
            day = 1;
            month = 1;

            while(true){

                if(checkLeapYear(year)){
                    daysLeftInYear = 366;
                    numberOfDaysInMonth[2] = 29;
                }
                else{
                    daysLeftInYear = 365;
                    numberOfDaysInMonth[2] = 28;
                }

                if(dateOfNDaysAhead<=daysLeftInYear){
                    findDateAndMonth(dateOfNDaysAhead);
                    break;  
                }

                else{
                    ++year;
                    dateOfNDaysAhead-= daysLeftInYear;
                }
            }
        }

    }
}