import chapter2.Dog;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class Main {
    public static void main(String[] args){


        LocalDate today = LocalDate.parse("2019-12-01");
        DateTimeFormatter dftDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dftDate.format(today);

        LocalDateTime time = LocalDateTime.of(2019,12,11,14,12,11);
        DateTimeFormatter dftTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dftTime.format(time);
    }
}
