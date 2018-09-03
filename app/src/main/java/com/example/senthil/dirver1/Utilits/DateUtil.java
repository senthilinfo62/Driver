package com.example.senthil.dirver1.Utilits;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by david on 5/25/2016.
 */
public class DateUtil {

    public static long getDateAlone() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        LogUtils.i("Current Date Alone " + cal.getTimeInMillis() / 1000);
        return cal.getTimeInMillis() / 1000;
    }

    public static long parseDate(String dateString) {
        long dateValue = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateString);
            dateValue = date.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateValue;
    }


    public static long getDateTime() {
        return System.currentTimeMillis() / 1000;
    }

    public static String convertDateFromUniversal(String date) {
        String defaultTimezone = TimeZone.getDefault().getID();
        try {
            Date dateTime = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).parse(date.replaceAll("Z$", "+0000"));
            DateFormat targetFormat = new SimpleDateFormat("MMM dd,yyyy h:mm a", Locale.getDefault());
            String formattedDate = null;

            formattedDate = targetFormat.format(dateTime);
            //System.out.println(formattedDate);
            return formattedDate;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getTimeAlone(long time) {
        // Get date from string
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date.setTime(time);
        dateFormatter.format(date);
        // Get time from date
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String displayValue = timeFormatter.format(date);
        return displayValue;
    }

    public static String getTimeAloneFormat(long time) {
        // Get date from string
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date.setTime(time);
        dateFormatter.format(date);
        // Get time from date
        SimpleDateFormat timeFormatter = new SimpleDateFormat("kk:mm ");
        String displayValue = timeFormatter.format(date);
        return displayValue;
    }


    public static String getTimeAloneFromUniversal(long time) {
        // Get date from string
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        date.setTime(time);
        dateFormatter.format(date);
        // Get time from date
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        timeFormatter.setTimeZone(TimeZone.getDefault());
        String displayValue = timeFormatter.format(date);

        return displayValue;
    }

    public static String getDateAlone(long time) {
        // Get date from string
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date.setTime(time);
        dateFormatter.format(date);
        // Get time from date
        SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String displayValue = timeFormatter.format(date);

        return displayValue;
    }

    public static String getDateTime(long time) {
        // Get date from string
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date.setTime(time);
        dateFormatter.format(date);
        // Get time from date
        SimpleDateFormat timeFormatter = new SimpleDateFormat("MMM dd,yyyy h:mm a");
        String displayValue = timeFormatter.format(date);

        return displayValue;
    }

    public static long getDateDiff(long endValue) {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.clear();
        cal2.setTimeInMillis(endValue);
        long diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        long days = diff / (24 * 60 * 60 * 1000);
        return days;
    }

    public static String parseTimeDateDiff(String timeAtMiliseconds)
    {
        if (timeAtMiliseconds.equalsIgnoreCase(""))
        {
            return "";
        }
        //API.log("Day Ago "+dayago);
        String result = "now";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataSot = formatter.format(new Date());
        Calendar calendar = Calendar.getInstance();
//        long dayagolong = Long.valueOf(timeAtMiliseconds) * 1000;

        long dayagolong = Long.valueOf(timeAtMiliseconds);
        calendar.setTimeInMillis(dayagolong);
        String agoformater = formatter.format(calendar.getTime());

        Date CurrentDate = null;
        Date CreateDate = null;

        try {
            CurrentDate = formatter.parse(dataSot);
            CreateDate = formatter.parse(agoformater);

            long different = Math.abs(CurrentDate.getTime() - CreateDate.getTime());

            long secondsInMilli = 1000;
            long minutesInMilli = secondsInMilli * 60;
            long hoursInMilli = minutesInMilli * 60;
            long daysInMilli = hoursInMilli * 24;

            long elapsedDays = different / daysInMilli;
            different = different % daysInMilli;

            long elapsedHours = different / hoursInMilli;
            different = different % hoursInMilli;

            long elapsedMinutes = different / minutesInMilli;
            different = different % minutesInMilli;

            long elapsedSeconds = different / secondsInMilli;

            different = different % secondsInMilli;
            if (elapsedDays == 0) {
                if (elapsedHours == 0) {
                    if (elapsedMinutes == 0) {
                        if (elapsedSeconds < 0) {
                            return "0" + " s";
                        } else {
                            if (elapsedDays > 0 && elapsedSeconds < 59) {
                                return "now";
                            }
                        }
                    } else {
                        return String.valueOf(elapsedMinutes) + "min ago";
                    }
                } else {
                    return String.valueOf(elapsedHours) + "hour ago";
                }

            } else {
                if (elapsedDays <= 29) {
                    return String.valueOf(elapsedDays) + "days ago";
                }
                if (elapsedDays > 29 && elapsedDays <= 58) {
                    return "1Month ago";
                }
                if (elapsedDays > 58 && elapsedDays <= 87) {
                    return "2Month ago";
                }
                if (elapsedDays > 87 && elapsedDays <= 116) {
                    return "3Month ago";
                }
                if (elapsedDays > 116 && elapsedDays <= 145) {
                    return "4Month ago";
                }
                if (elapsedDays > 145 && elapsedDays <= 174) {
                    return "5Month ago";
                }
                if (elapsedDays > 174 && elapsedDays <= 203) {
                    return "6Month ago";
                }
                if (elapsedDays > 203 && elapsedDays <= 232) {
                    return "7Month ago";
                }
                if (elapsedDays > 232 && elapsedDays <= 261) {
                    return "8Month ago";
                }
                if (elapsedDays > 261 && elapsedDays <= 290) {
                    return "9Month ago";
                }
                if (elapsedDays > 290 && elapsedDays <= 319) {
                    return "10Month ago";
                }
                if (elapsedDays > 319 && elapsedDays <= 348) {
                    return "11Month ago";
                }
                if (elapsedDays > 348 && elapsedDays <= 360) {
                    return "12Month ago";
                }

                if (elapsedDays > 360 && elapsedDays <= 720) {
                    return "1 year ago";
                }

                if (elapsedDays > 720)
                {
                    SimpleDateFormat formatterYear = new SimpleDateFormat("MM/dd/yyyy");
                    Calendar calendarYear = Calendar.getInstance();
                    calendarYear.setTimeInMillis(dayagolong);
                    return formatterYear.format(calendarYear.getTime()) + "";
                }

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Used to convert 24hr format to 12hr format with AM/PM values
    public static String updateTime(int hours, int mins) {

        String timeSet = "";
        if (hours > 12) {
            hours -= 12;
            timeSet = "PM";
        } else if (hours == 0) {
            hours += 12;
            timeSet = "AM";
        } else if (hours == 12)
            timeSet = "PM";
        else
            timeSet = "AM";


        String minutes = "";
        if (mins < 10)
            minutes = "0" + mins;
        else
            minutes = String.valueOf(mins);

        // Append in a StringBuilder
//        String aTime = new StringBuilder().append(hours).append(':')
//                .append(minutes).append(" ").append(timeSet).toString();
        String aTime = new StringBuilder().append(hours).append(":")
                .append(minutes).toString();

        return aTime;
    }

    // Used to convert 24hr format to 12hr format with AM/PM values
    public static String updateTimeWithAMPM(int hours, int mins) {

        String timeSet = "";
        if (hours > 12) {
            hours -= 12;
            timeSet = "PM";
        } else if (hours == 0) {
            hours += 12;
            timeSet = "AM";
        } else if (hours == 12)
            timeSet = "PM";
        else
            timeSet = "AM";


        String minutes = "";
        if (mins < 10)
            minutes = "0" + mins;
        else
            minutes = String.valueOf(mins);

        // Append in a StringBuilder
        String aTime = new StringBuilder().append(hours).append(':')
                .append(minutes).append(" ").append(timeSet).toString();

        return aTime;
    }

    public static String convertDate(long milliseconds) {
        String dateText = "";
        try {
            Date date = new Date(milliseconds);
            SimpleDateFormat df2 = new SimpleDateFormat("MMM dd,yyyy");
            dateText = df2.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateText;
    }

    public static String convertNotificationDate(long milliseconds){
        String dateText = "";
        try {
            Date date = new Date(milliseconds);
            SimpleDateFormat df2 = new SimpleDateFormat("MMM d, yyyy");
            // SimpleDateFormat df2 = new SimpleDateFormat("EEEE, MMM d, yyyy");
            dateText = df2.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateText;

    }

    public static String convertDateForHeader(long milliseconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Calendar yestCalendar = Calendar.getInstance();
        yestCalendar.set(Calendar.HOUR_OF_DAY, 0);
        yestCalendar.set(Calendar.MINUTE, 0);
        yestCalendar.set(Calendar.SECOND, 0);
        yestCalendar.set(Calendar.MILLISECOND, 0);

        SimpleDateFormat df2 = new SimpleDateFormat("MMM dd,yyyy");
        Date date = new Date(milliseconds);
        String dateText = df2.format(date);
        //Current Date
        Date currentDate = new Date(calendar.getTimeInMillis());
        String currentDateText = df2.format(currentDate);
        if (currentDateText.equalsIgnoreCase(dateText)) {
            return "Today";
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            Date tomoDate = new Date(calendar.getTimeInMillis());
            String tomoDateText = df2.format(tomoDate);
            yestCalendar.add(Calendar.DAY_OF_MONTH, -1);
            Date yestDate = new Date(yestCalendar.getTimeInMillis());
            String yestDateText = df2.format(yestDate);
            if (dateText.equalsIgnoreCase(tomoDateText)) {
                return "Tomorrow";
            } else if (dateText.equalsIgnoreCase(yestDateText)) {
                return "Yesterday";
            } else {
                return dateText;
            }
        }

    }

    public static String convertDateForSchedule(long milliseconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Calendar yestCalendar = Calendar.getInstance();
        yestCalendar.set(Calendar.HOUR_OF_DAY, 0);
        yestCalendar.set(Calendar.MINUTE, 0);
        yestCalendar.set(Calendar.SECOND, 0);
        yestCalendar.set(Calendar.MILLISECOND, 0);

        SimpleDateFormat df2 = new SimpleDateFormat("MMM dd,yyyy");
        Date date = new Date(milliseconds);
        String dateText = df2.format(date);
        return dateText;
    }

    public static String getDateValue(int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, value);
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateText = df2.format(calendar.getTime());
        return dateText;

    }

 
    public static String getTimeAMPM(String time) {
        String[] array = time.split(":");
        String timeValue = array[0];
        int tempTime = Integer.parseInt(timeValue);
        if (Integer.parseInt(timeValue) < 12) {
            timeValue = new StringBuilder().append(time).append("AM").toString();
        } else {
            tempTime = tempTime - 12;
            timeValue = new StringBuilder().append(tempTime).append(":" + array[1]).append("PM").toString();
        }
        return timeValue;
    }

    public static boolean isTimeGreaterThanCurrent(String time) {
        //Time value received
        String[] array = time.split(":");
        String hrTimeValue = array[0];
        String minTimeValue = array[1];
        int tempHourTime = Integer.parseInt(hrTimeValue);
        int tempMinTime = Integer.parseInt(minTimeValue);

        // Get date from string
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        dateFormatter.format(date);
        // Get time from date
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
        String displayValue = timeFormatter.format(date);
        String[] currentTimeArray = displayValue.split(":");
        String curHrTimeValue = currentTimeArray[0];
        String curMinTimeValue = currentTimeArray[1];
        int curHourTime = Integer.parseInt(curHrTimeValue);
        int curMinTime = Integer.parseInt(curMinTimeValue);

        //Hour Check
        if (tempHourTime < curHourTime) {
            return false;
        } else if (tempHourTime == curHourTime) {
            //Min check
            return tempMinTime >= curMinTime;
        } else {
            return true;
        }
    }

    /**
     * Method to format date
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String formatDate(int year, int month, int day) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(year, month, day);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
        return sdf.format(date);
    }

    public static String formatGeneralDate(int year, int month, int day) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(year, month, day);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(date);
    }

    public static String formatGeneralDate(long dateValue) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateValue);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(date);
    }
    public static String getPainDate(long dateValue) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateValue);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm, EEEE, MMM d, yyyy");
        return sdf.format(date);
    }

    public static String getPainActionBarDate(long dateValue) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateValue);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm");
        return sdf.format(date);
    }
    public static String convertToDefaultFormat(String originalDate) {
        DateFormat originalFormat;
        if (originalDate.contains("/")) {
            originalFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
        } else {
            originalFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        }
        DateFormat targetFormat = new SimpleDateFormat("MMM dd, yyyy");
        Date date = null;
        String formattedDate = "";
        try {
            date = originalFormat.parse(originalDate);
            formattedDate = targetFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return originalDate;
        }
        return formattedDate;
    }

}
