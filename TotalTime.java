public class TotalTime{

    public static int[] CalculateTime(String enterdate, String exitdate, String entertime, String exittime){

        int i = Integer.parseInt(enterdate.substring(8, 10));
        int j = Integer.parseInt(exitdate.substring(8, 10));

        if((j-i) >= 2){
            // Total hour in days
            int Days = (j - (i-1)) - 2;
            int HourInTotalDays = Days * 24;

            // Total hour in 1st day
            int HoursInFirstDay = 0;
            int MinutesInFirstDay = 0;

            if(entertime.substring(6,8).equals("AM")){
                if(Integer.parseInt( entertime.substring(0,2)) == 12){
                    HoursInFirstDay = 11 + 12;
                    MinutesInFirstDay = 60 - Integer.parseInt( entertime.substring(3,5) );
                }
                else {
                    HoursInFirstDay = (12 - (Integer.parseInt(entertime.substring(0, 2)) + 1)) + 12;
                    MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                }
            }
            else if(entertime.substring(6,8).equals("PM")){
                if(Integer.parseInt(entertime.substring(0, 2)) == 12){
                    HoursInFirstDay = 11;
                    MinutesInFirstDay =  60 - Integer.parseInt(entertime.substring(3, 5));
                }
                else {
                    HoursInFirstDay = 12 - (Integer.parseInt(entertime.substring(0, 2)) + 1);
                    MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                }
            }



            // Total hour and minute in last day
            int HoursInLastDay = 0;
            int MinutesInLastDay = 0;

            if(exittime.substring(6,8).equals("AM")){
                if(Integer.parseInt(exittime.substring(0, 2)) == 12){
                    HoursInLastDay =  0;
                    MinutesInLastDay =  Integer.parseInt(exittime.substring(3, 5));
                }
                else {
                    HoursInLastDay = Integer.parseInt(exittime.substring(0, 2));
                    MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                }
            }
            else if(exittime.substring(6,8).equals("PM")){
                if(Integer.parseInt(exittime.substring(0, 2)) == 12){
                   HoursInLastDay = 12;
                   MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                }
                else {
                    HoursInLastDay = 12 + Integer.parseInt(exittime.substring(0, 2));
                    MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                }
            }

            // Total hours  and minutes

            int hour = HourInTotalDays + HoursInFirstDay + HoursInLastDay;
            int minute = MinutesInFirstDay + MinutesInLastDay;

            if(minute >= 60){
                minute = minute - 60;
                hour = hour + 1;
            }

            return new int[] {hour, minute};
        }

        // for one day difference only

        else if((j - i) == 1){
            int HoursInFirstDay = 0;
            int MinutesInFirstDay = 0;

            if(entertime.substring(6,8).equals("AM")){
                if(Integer.parseInt( entertime.substring(0,2)) == 12){
                    HoursInFirstDay = 11 + 12;
                    MinutesInFirstDay = 60 - Integer.parseInt( entertime.substring(3,5) );
                }
                else {
                    HoursInFirstDay = (12 - (Integer.parseInt(entertime.substring(0, 2)) + 1)) + 12;
                    MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                }
            }
            else if(entertime.substring(6,8).equals("PM")){
                if(Integer.parseInt(entertime.substring(0, 2)) == 12){
                    HoursInFirstDay = 11;
                    MinutesInFirstDay =  60 - Integer.parseInt(entertime.substring(3, 5));
                }
                else {
                    HoursInFirstDay = 12 - (Integer.parseInt(entertime.substring(0, 2)) + 1);
                    MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                }

            }

            // nour and minute in first and last days
            int HoursInLastDay = 0;
            int MinutesInLastDay = 0;

            if(exittime.substring(6,8).equals("AM")){
                if(Integer.parseInt(exittime.substring(0, 2)) == 12){
                    HoursInLastDay =  0;
                    MinutesInLastDay =  Integer.parseInt(exittime.substring(3, 5));
                }
                else {
                    HoursInLastDay = Integer.parseInt(exittime.substring(0, 2));
                    MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                }

            }
            else if(exittime.substring(6,8).equals("PM")){
                if(Integer.parseInt(exittime.substring(0, 2)) == 12){
                    HoursInLastDay = 12;
                    MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                }
                else {
                    HoursInLastDay = 12 + Integer.parseInt(exittime.substring(0, 2));
                    MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                }

            }
            int hour = HoursInFirstDay + HoursInLastDay;
            int minute = MinutesInFirstDay + MinutesInLastDay;
            if(minute >= 60){
                minute = minute - 60;
                hour = hour + 1;
            }
            return new int[] {hour, minute};

        }

        // for one single day

        else if( (j - i) == 0){
            int ParkedHour = 0;
            int ParkedMinute = 0;
            int ExitHour = 0;
            int ExitMinute = 0;
            int hour = 0;
            int minute = 0;

            if( entertime.substring(6,8).equals("AM") && exittime.substring(6,8).equals("AM")){
                if(Integer.parseInt(entertime.substring(0, 2)) == 12){
                    hour =  Integer.parseInt(exittime.substring(0, 2));
                    minute = (60 - Integer.parseInt(entertime.substring(3, 5))) + Integer.parseInt(exittime.substring(3, 5));
                }
                else {
                    hour = Integer.parseInt(exittime.substring(0, 2)) - (Integer.parseInt(entertime.substring(0, 2)) + 1);
                    minute = (60 - Integer.parseInt(entertime.substring(3, 5))) + Integer.parseInt(exittime.substring(3, 5));
                }
            }
            else if(entertime.substring(6,8).equals("PM") && exittime.substring(6,8).equals("PM")){

                if(Integer.parseInt(entertime.substring(0, 2)) == 12){
                    hour =  Integer.parseInt(exittime.substring(0, 2));
                    minute = (60 - Integer.parseInt(entertime.substring(3, 5))) + Integer.parseInt(exittime.substring(3, 5));
                }
                else {
                    hour = Integer.parseInt(exittime.substring(0, 2)) - (Integer.parseInt(entertime.substring(0, 2)) + 1);
                    minute = (60 - Integer.parseInt(entertime.substring(3, 5))) + Integer.parseInt(exittime.substring(3, 5));
                }

            }

            else if( entertime.substring(6,8).equals("AM") && exittime.substring(6,8).equals("PM")){

                if(Integer.parseInt( entertime.substring(0,2)) == 12){
                    ParkedHour = 12;
                    ParkedMinute = 60 - Integer.parseInt( entertime.substring(3,5) );
                }
                else {
                    ParkedHour = 12 - ( Integer.parseInt(entertime.substring(0,2)) + 1);
                    ParkedMinute = 60 - Integer.parseInt(entertime.substring(3, 5));
                }

                if(Integer.parseInt(exittime.substring(0,2)) == 12){
                    ExitHour = 0;
                    ExitMinute = Integer.parseInt(exittime.substring(3,5));
                }
                else {
                    ExitHour = Integer.parseInt(exittime.substring(0,2));
                    ExitMinute = Integer.parseInt(exittime.substring(3,5));
                }
                hour = ParkedHour + ExitHour;
                minute = ParkedMinute + ExitMinute;

            }

            if(minute >= 60){
                minute = minute - 60;
                hour = hour + 1;
            }

            return new int[] {hour, minute};
        }
        return new int[] {};
    }

}