class DateTestDrive{
    public static void main(String args[]){

        Date todaysDate = new Date();

        todaysDate.setTodaysDate(7,1,2021);

        int dateOfNDaysAhead = 1000;

        todaysDate.getDateOfNDaysAhead(dateOfNDaysAhead);
    }
}