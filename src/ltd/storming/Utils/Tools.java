package ltd.storming.Utils;

import ltd.storming.Domain.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Tools {
    public static int BirthdayToAge(String Birthday) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date BirDate = sdf.parse(Birthday);
        Calendar nowCal = Calendar.getInstance();
        Calendar birCal = Calendar.getInstance();
        birCal.setTime(BirDate);
        if (nowCal.after(birCal)){
            int age = nowCal.get(Calendar.YEAR) - birCal.get(Calendar.YEAR);
            if (birCal.get(Calendar.MONTH) < nowCal.get(Calendar.MONTH)){
                age++;
            }else{
                if (birCal.get(Calendar.DAY_OF_MONTH) < nowCal.get(Calendar.DAY_OF_MONTH)){
                    age++;
                }
            }
            return age;
        }else {
            return -1;
        }
    }


    public static void printPerson(Person p){
        System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getSex()+"\t"+p.getAge()+"\t"+p.show());
    }
}
