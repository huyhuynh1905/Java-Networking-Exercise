import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        Calendar cl1 = Calendar.getInstance();
        cl1.set(2019,10,1);
        Calendar cl2 = Calendar.getInstance();
        cl2.set(2019,11,15);
        SimpleDateFormat dateF = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(dateF.format(cl1.getTime()));
        System.out.println(dateF.format(cl2.getTime()));
        int countDate =(int) (cl2.getTimeInMillis() - cl1.getTimeInMillis())/(1000*60*60*24);
        System.out.println(countDate);
        Date date1 = null;
        Date date2 = null;
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date1Str = dateF.format(cl1.getTime());
        String date2Str = dateF.format(cl2.getTime());
        date1 = simpleDateFormat.parse(date1Str);
        date2 = simpleDateFormat.parse(date2Str);
        long getDiff = date2.getTime() - date1.getTime();

        long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
        System.out.println(getDaysDiff);

    }
}
