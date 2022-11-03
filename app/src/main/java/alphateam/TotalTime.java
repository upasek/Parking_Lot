package alphateam;

public class TotalTime{

    public static int[] calculateTime(String enterDate, String exitDate, String enterTime, String exitTime){

        int firstDay = Integer.parseInt(enterDate.substring(8, 10));
        int lastDay = Integer.parseInt(exitDate.substring(8, 10));
        int firstMonth = Integer.parseInt(enterDate.substring(5,7), 10);
        int lastMonth = Integer.parseInt(exitDate.substring(5,7));
        int firstYear = Integer.parseInt(enterDate.substring(0,4));

        //time calculation for different month days
        if( firstMonth != lastMonth){
            int daysInMonth ;
            if (firstMonth == 1 || firstMonth == 3 || firstMonth == 5 || firstMonth == 7 || firstMonth == 8 || firstMonth == 10 || firstMonth == 12 ) {
                daysInMonth = 31;
            }
            else {
                if (firstMonth == 2) {
                    daysInMonth = (firstYear % 4 == 0) ? 29 : 28;
                } else {
                    daysInMonth = 30;
                }
            }

            int days = daysInMonth - firstDay;
            days = days + (lastDay - 1);
            int hourInTotalDays = days * 24;

            // Total hour in 1st day
            int hoursInFirstDay = 0;
            int minutesInFirstDay = 0;

            if (enterTime.substring(6, 8).equals("AM")) {
                if (Integer.parseInt(enterTime.substring(0, 2)) == 12) {
                    hoursInFirstDay = 11 + 12;
                    minutesInFirstDay = 60 - Integer.parseInt(enterTime.substring(3, 5));
                } else {
                    hoursInFirstDay = (12 - (Integer.parseInt(enterTime.substring(0, 2)) + 1)) + 12;
                    minutesInFirstDay = 60 - Integer.parseInt(enterTime.substring(3, 5));
                }
            } else if (enterTime.substring(6, 8).equals("PM")) {
                if (Integer.parseInt(enterTime.substring(0, 2)) == 12) {
                    hoursInFirstDay = 11;
                    minutesInFirstDay = 60 - Integer.parseInt(enterTime.substring(3, 5));
                } else {
                    hoursInFirstDay = 12 - (Integer.parseInt(enterTime.substring(0, 2)) + 1);
                    minutesInFirstDay = 60 - Integer.parseInt(enterTime.substring(3, 5));
                }
            }


            // Total hour and minute in last day
            int hoursInLastDay = 0;
            int minutesInLastDay = 0;

            if (exitTime.substring(6, 8).equals("AM")) {
                if (Integer.parseInt(exitTime.substring(0, 2)) == 12) {
                    hoursInLastDay = 0;
                    minutesInLastDay = Integer.parseInt(exitTime.substring(3, 5));
                } else {
                    hoursInLastDay = Integer.parseInt(exitTime.substring(0, 2));
                    minutesInLastDay = Integer.parseInt(exitTime.substring(3, 5));
                }
            } else if (exitTime.substring(6, 8).equals("PM")) {
                if (Integer.parseInt(exitTime.substring(0, 2)) == 12) {
                    hoursInLastDay = 12;
                    minutesInLastDay = Integer.parseInt(exitTime.substring(3, 5));
                } else {
                    hoursInLastDay = 12 + Integer.parseInt(exitTime.substring(0, 2));
                    minutesInLastDay = Integer.parseInt(exitTime.substring(3, 5));
                }
            }

            // Total hours  and minutes

            int hour = hourInTotalDays + hoursInFirstDay + hoursInLastDay;
            int minute = minutesInFirstDay + minutesInLastDay;

            if (minute >= 60) {
                minute = minute - 60;
                hour = hour + 1;
            }

            return new int[]{hour, minute};

        }
        // time calculation for same month days
        else {
            if ((lastDay - firstDay) >= 2) {
                // Total hour in days
                int Days = (lastDay - (firstDay - 1)) - 2;
                int hourInTotalDays = Days * 24;

                // Total hour in 1st day
                int hoursInFirstDay = 0;
                int minutesInFirstDay = 0;

                if (enterTime.substring(6, 8).equals("AM")) {
                    if (Integer.parseInt(enterTime.substring(0, 2)) == 12) {
                        hoursInFirstDay = 11 + 12;
                        minutesInFirstDay = 60 - Integer.parseInt(enterTime.substring(3, 5));
                    } else {
                        hoursInFirstDay = (12 - (Integer.parseInt(enterTime.substring(0, 2)) + 1)) + 12;
                        minutesInFirstDay = 60 - Integer.parseInt(enterTime.substring(3, 5));
                    }
                } else if (enterTime.substring(6, 8).equals("PM")) {
                    if (Integer.parseInt(enterTime.substring(0, 2)) == 12) {
                        hoursInFirstDay = 11;
                        minutesInFirstDay = 60 - Integer.parseInt(enterTime.substring(3, 5));
                    } else {
                        hoursInFirstDay = 12 - (Integer.parseInt(enterTime.substring(0, 2)) + 1);
                        minutesInFirstDay = 60 - Integer.parseInt(enterTime.substring(3, 5));
                    }
                }


                // Total hour and minute in last day
                int hoursInLastDay = 0;
                int minutesInLastDay = 0;

                if (exitTime.substring(6, 8).equals("AM")) {
                    if (Integer.parseInt(exitTime.substring(0, 2)) == 12) {
                        hoursInLastDay = 0;
                        minutesInLastDay = Integer.parseInt(exitTime.substring(3, 5));
                    } else {
                        hoursInLastDay = Integer.parseInt(exitTime.substring(0, 2));
                        minutesInLastDay = Integer.parseInt(exitTime.substring(3, 5));
                    }
                } else if (exitTime.substring(6, 8).equals("PM")) {
                    if (Integer.parseInt(exitTime.substring(0, 2)) == 12) {
                        hoursInLastDay = 12;
                        minutesInLastDay = Integer.parseInt(exitTime.substring(3, 5));
                    } else {
                        hoursInLastDay = 12 + Integer.parseInt(exitTime.substring(0, 2));
                        minutesInLastDay = Integer.parseInt(exitTime.substring(3, 5));
                    }
                }

                // Total hours  and minutes

                int hour = hourInTotalDays + hoursInFirstDay + hoursInLastDay;
                int minute = minutesInFirstDay + minutesInLastDay;

                if (minute >= 60) {
                    minute = minute - 60;
                    hour = hour + 1;
                }

                return new int[]{hour, minute};
            }

            // for one day difference only

            else if ((lastDay - firstDay) == 1) {
                int hoursInFirstDay = 0;
                int minutesInFirstDay = 0;

                if (enterTime.substring(6, 8).equals("AM")) {
                    if (Integer.parseInt(enterTime.substring(0, 2)) == 12) {
                        hoursInFirstDay = 11 + 12;
                        minutesInFirstDay = 60 - Integer.parseInt(enterTime.substring(3, 5));
                    } else {
                        hoursInFirstDay = (12 - (Integer.parseInt(enterTime.substring(0, 2)) + 1)) + 12;
                        minutesInFirstDay = 60 - Integer.parseInt(enterTime.substring(3, 5));
                    }
                } else if (enterTime.substring(6, 8).equals("PM")) {
                    if (Integer.parseInt(enterTime.substring(0, 2)) == 12) {
                        hoursInFirstDay = 11;
                        minutesInFirstDay = 60 - Integer.parseInt(enterTime.substring(3, 5));
                    } else {
                        hoursInFirstDay = 12 - (Integer.parseInt(enterTime.substring(0, 2)) + 1);
                        minutesInFirstDay = 60 - Integer.parseInt(enterTime.substring(3, 5));
                    }

                }

                // nour and minute in first and last days
                int hoursInLastDay = 0;
                int minutesInLastDay = 0;

                if (exitTime.substring(6, 8).equals("AM")) {
                    if (Integer.parseInt(exitTime.substring(0, 2)) == 12) {
                        hoursInLastDay = 0;
                        minutesInLastDay = Integer.parseInt(exitTime.substring(3, 5));
                    } else {
                        hoursInLastDay = Integer.parseInt(exitTime.substring(0, 2));
                        minutesInLastDay = Integer.parseInt(exitTime.substring(3, 5));
                    }

                } else if (exitTime.substring(6, 8).equals("PM")) {
                    if (Integer.parseInt(exitTime.substring(0, 2)) == 12) {
                        hoursInLastDay = 12;
                        minutesInLastDay = Integer.parseInt(exitTime.substring(3, 5));
                    } else {
                        hoursInLastDay = 12 + Integer.parseInt(exitTime.substring(0, 2));
                        minutesInLastDay = Integer.parseInt(exitTime.substring(3, 5));
                    }

                }
                int hour = hoursInFirstDay + hoursInLastDay;
                int minute = minutesInFirstDay + minutesInLastDay;
                if (minute >= 60) {
                    minute = minute - 60;
                    hour = hour + 1;
                }
                return new int[]{hour, minute};

            }

            // for one single day

            else if ((lastDay - firstDay) == 0) {
                int parkedHour = 0;
                int parkedMinute = 0;
                int exitHour = 0;
                int exitMinute = 0;
                int hour = 0;
                int minute = 0;

                if (enterTime.substring(6, 8).equals("AM") && exitTime.substring(6, 8).equals("AM")) {
                    if (Integer.parseInt(enterTime.substring(0, 2)) == 12) {
                        hour = Integer.parseInt(exitTime.substring(0, 2));
                        minute = (60 - Integer.parseInt(enterTime.substring(3, 5))) + Integer.parseInt(exitTime.substring(3, 5));
                    } else {
                        hour = Integer.parseInt(exitTime.substring(0, 2)) - (Integer.parseInt(enterTime.substring(0, 2)) + 1);
                        minute = (60 - Integer.parseInt(enterTime.substring(3, 5))) + Integer.parseInt(exitTime.substring(3, 5));
                    }
                } else if (enterTime.substring(6, 8).equals("PM") && exitTime.substring(6, 8).equals("PM")) {

                    if (Integer.parseInt(enterTime.substring(0, 2)) == 12) {
                        hour = Integer.parseInt(exitTime.substring(0, 2));
                        minute = (60 - Integer.parseInt(enterTime.substring(3, 5))) + Integer.parseInt(exitTime.substring(3, 5));
                    } else {
                        hour = Integer.parseInt(exitTime.substring(0, 2)) - (Integer.parseInt(enterTime.substring(0, 2)) + 1);
                        minute = (60 - Integer.parseInt(enterTime.substring(3, 5))) + Integer.parseInt(exitTime.substring(3, 5));
                    }

                } else if (enterTime.substring(6, 8).equals("AM") && exitTime.substring(6, 8).equals("PM")) {

                    if (Integer.parseInt(enterTime.substring(0, 2)) == 12) {
                        parkedHour = 12;
                        parkedMinute = 60 - Integer.parseInt(enterTime.substring(3, 5));
                    } else {
                        parkedHour = 12 - (Integer.parseInt(enterTime.substring(0, 2)) + 1);
                        parkedMinute = 60 - Integer.parseInt(enterTime.substring(3, 5));
                    }

                    if (Integer.parseInt(exitTime.substring(0, 2)) == 12) {
                        exitHour = 0;
                        exitMinute = Integer.parseInt(exitTime.substring(3, 5));
                    } else {
                        exitHour = Integer.parseInt(exitTime.substring(0, 2));
                        exitMinute = Integer.parseInt(exitTime.substring(3, 5));
                    }
                    hour = parkedHour + exitHour;
                    minute = parkedMinute + exitMinute;

                }

                if (minute >= 60) {
                    minute = minute - 60;
                    hour = hour + 1;
                }

                return new int[]{hour, minute};
            }
        }
        return new int[] {};
    }

}