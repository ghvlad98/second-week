package datetime;

import utils.LOG;
import java.util.GregorianCalendar;

public class DateJava {
    public static void main(String[] args) {
        LOG L = LOG.getInstance();
        GregorianCalendar actualDate = new GregorianCalendar();
        actualDate.get(GregorianCalendar.HOUR);
        int year = actualDate.get(GregorianCalendar.YEAR);
        int month = actualDate.get(GregorianCalendar.MONTH) + 1;
        int hour = actualDate.get(GregorianCalendar.HOUR);
        int minutes = actualDate.get(GregorianCalendar.MINUTE);
        int seconds = actualDate.get(GregorianCalendar.SECOND);

        L.info(String.valueOf(year));
        L.info(String.valueOf(month));
        L.info(String.valueOf(hour));
        L.info(String.valueOf(minutes));
        L.info(String.valueOf(seconds));

        GregorianCalendar date1 = new GregorianCalendar(2008, 11, 18);
        GregorianCalendar date2 = new GregorianCalendar(2007, 11, 10);
        if (date1.before(date2)) {
            L.info("date1 before date2");
        } else if (date1.after(date2)) {
            L.info("date2 before date1");
        } else {
            L.info("The dates are equal");
        }
    }
}
