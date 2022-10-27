public class TotalTime{

    public static int[] CalculateTime(String enterdate, String exitdate, String entertime, String exittime){

        int firstDay = Integer.parseInt(enterdate.substring(8, 10));
        int lastDay = Integer.parseInt(exitdate.substring(8, 10));
        int firstMonth = Integer.parseInt(enterdate.substring(5,7), 10);
        int lastMonth = Integer.parseInt(exitdate.substring(5,7));
        int firstYear = Integer.parseInt(enterdate.substring(0,4));

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

            int Days = daysInMonth - firstDay;
            Days = Days + (lastDay - 1);
            int HourInTotalDays = Days * 24;

            // Total hour in 1st day
            int HoursInFirstDay = 0;
            int MinutesInFirstDay = 0;

            if (entertime.substring(6, 8).equals("AM")) {
                if (Integer.parseInt(entertime.substring(0, 2)) == 12) {
                    HoursInFirstDay = 11 + 12;
                    MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                } else {
                    HoursInFirstDay = (12 - (Integer.parseInt(entertime.substring(0, 2)) + 1)) + 12;
                    MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                }
            } else if (entertime.substring(6, 8).equals("PM")) {
                if (Integer.parseInt(entertime.substring(0, 2)) == 12) {
                    HoursInFirstDay = 11;
                    MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                } else {
                    HoursInFirstDay = 12 - (Integer.parseInt(entertime.substring(0, 2)) + 1);
                    MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                }
            }


            // Total hour and minute in last day
            int HoursInLastDay = 0;
            int MinutesInLastDay = 0;

            if (exittime.substring(6, 8).equals("AM")) {
                if (Integer.parseInt(exittime.substring(0, 2)) == 12) {
                    HoursInLastDay = 0;
                    MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                } else {
                    HoursInLastDay = Integer.parseInt(exittime.substring(0, 2));
                    MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                }
            } else if (exittime.substring(6, 8).equals("PM")) {
                if (Integer.parseInt(exittime.substring(0, 2)) == 12) {
                    HoursInLastDay = 12;
                    MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                } else {
                    HoursInLastDay = 12 + Integer.parseInt(exittime.substring(0, 2));
                    MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                }
            }

            // Total hours  and minutes

            int hour = HourInTotalDays + HoursInFirstDay + HoursInLastDay;
            int minute = MinutesInFirstDay + MinutesInLastDay;

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
                int HourInTotalDays = Days * 24;

                // Total hour in 1st day
                int HoursInFirstDay = 0;
                int MinutesInFirstDay = 0;

                if (entertime.substring(6, 8).equals("AM")) {
                    if (Integer.parseInt(entertime.substring(0, 2)) == 12) {
                        HoursInFirstDay = 11 + 12;
                        MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                    } else {
                        HoursInFirstDay = (12 - (Integer.parseInt(entertime.substring(0, 2)) + 1)) + 12;
                        MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                    }
                } else if (entertime.substring(6, 8).equals("PM")) {
                    if (Integer.parseInt(entertime.substring(0, 2)) == 12) {
                        HoursInFirstDay = 11;
                        MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                    } else {
                        HoursInFirstDay = 12 - (Integer.parseInt(entertime.substring(0, 2)) + 1);
                        MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                    }
                }


                // Total hour and minute in last day
                int HoursInLastDay = 0;
                int MinutesInLastDay = 0;

                if (exittime.substring(6, 8).equals("AM")) {
                    if (Integer.parseInt(exittime.substring(0, 2)) == 12) {
                        HoursInLastDay = 0;
                        MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                    } else {
                        HoursInLastDay = Integer.parseInt(exittime.substring(0, 2));
                        MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                    }
                } else if (exittime.substring(6, 8).equals("PM")) {
                    if (Integer.parseInt(exittime.substring(0, 2)) == 12) {
                        HoursInLastDay = 12;
                        MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                    } else {
                        HoursInLastDay = 12 + Integer.parseInt(exittime.substring(0, 2));
                        MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                    }
                }

                // Total hours  and minutes

                int hour = HourInTotalDays + HoursInFirstDay + HoursInLastDay;
                int minute = MinutesInFirstDay + MinutesInLastDay;

                if (minute >= 60) {
                    minute = minute - 60;
                    hour = hour + 1;
                }

                return new int[]{hour, minute};
            }

            // for one day difference only

            else if ((lastDay - firstDay) == 1) {
                int HoursInFirstDay = 0;
                int MinutesInFirstDay = 0;

                if (entertime.substring(6, 8).equals("AM")) {
                    if (Integer.parseInt(entertime.substring(0, 2)) == 12) {
                        HoursInFirstDay = 11 + 12;
                        MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                    } else {
                        HoursInFirstDay = (12 - (Integer.parseInt(entertime.substring(0, 2)) + 1)) + 12;
                        MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                    }
                } else if (entertime.substring(6, 8).equals("PM")) {
                    if (Integer.parseInt(entertime.substring(0, 2)) == 12) {
                        HoursInFirstDay = 11;
                        MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                    } else {
                        HoursInFirstDay = 12 - (Integer.parseInt(entertime.substring(0, 2)) + 1);
                        MinutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                    }

                }

                // nour and minute in first and last days
                int HoursInLastDay = 0;
                int MinutesInLastDay = 0;

                if (exittime.substring(6, 8).equals("AM")) {
                    if (Integer.parseInt(exittime.substring(0, 2)) == 12) {
                        HoursInLastDay = 0;
                        MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                    } else {
                        HoursInLastDay = Integer.parseInt(exittime.substring(0, 2));
                        MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                    }

                } else if (exittime.substring(6, 8).equals("PM")) {
                    if (Integer.parseInt(exittime.substring(0, 2)) == 12) {
                        HoursInLastDay = 12;
                        MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                    } else {
                        HoursInLastDay = 12 + Integer.parseInt(exittime.substring(0, 2));
                        MinutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
                    }

                }
                int hour = HoursInFirstDay + HoursInLastDay;
                int minute = MinutesInFirstDay + MinutesInLastDay;
                if (minute >= 60) {
                    minute = minute - 60;
                    hour = hour + 1;
                }
                return new int[]{hour, minute};

            }

            // for one single day

            else if ((lastDay - firstDay) == 0) {
                int ParkedHour = 0;
                int ParkedMinute = 0;
                int ExitHour = 0;
                int ExitMinute = 0;
                int hour = 0;
                int minute = 0;

                if (entertime.substring(6, 8).equals("AM") && exittime.substring(6, 8).equals("AM")) {
                    if (Integer.parseInt(entertime.substring(0, 2)) == 12) {
                        hour = Integer.parseInt(exittime.substring(0, 2));
                        minute = (60 - Integer.parseInt(entertime.substring(3, 5))) + Integer.parseInt(exittime.substring(3, 5));
                    } else {
                        hour = Integer.parseInt(exittime.substring(0, 2)) - (Integer.parseInt(entertime.substring(0, 2)) + 1);
                        minute = (60 - Integer.parseInt(entertime.substring(3, 5))) + Integer.parseInt(exittime.substring(3, 5));
                    }
                } else if (entertime.substring(6, 8).equals("PM") && exittime.substring(6, 8).equals("PM")) {

                    if (Integer.parseInt(entertime.substring(0, 2)) == 12) {
                        hour = Integer.parseInt(exittime.substring(0, 2));
                        minute = (60 - Integer.parseInt(entertime.substring(3, 5))) + Integer.parseInt(exittime.substring(3, 5));
                    } else {
                        hour = Integer.parseInt(exittime.substring(0, 2)) - (Integer.parseInt(entertime.substring(0, 2)) + 1);
                        minute = (60 - Integer.parseInt(entertime.substring(3, 5))) + Integer.parseInt(exittime.substring(3, 5));
                    }

                } else if (entertime.substring(6, 8).equals("AM") && exittime.substring(6, 8).equals("PM")) {

                    if (Integer.parseInt(entertime.substring(0, 2)) == 12) {
                        ParkedHour = 12;
                        ParkedMinute = 60 - Integer.parseInt(entertime.substring(3, 5));
                    } else {
                        ParkedHour = 12 - (Integer.parseInt(entertime.substring(0, 2)) + 1);
                        ParkedMinute = 60 - Integer.parseInt(entertime.substring(3, 5));
                    }

                    if (Integer.parseInt(exittime.substring(0, 2)) == 12) {
                        ExitHour = 0;
                        ExitMinute = Integer.parseInt(exittime.substring(3, 5));
                    } else {
                        ExitHour = Integer.parseInt(exittime.substring(0, 2));
                        ExitMinute = Integer.parseInt(exittime.substring(3, 5));
                    }
                    hour = ParkedHour + ExitHour;
                    minute = ParkedMinute + ExitMinute;

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