package Generator;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

// 國際化 vs. 在地化
// i18n vs i10n => internationalization

// Date, Time

public class chloe101 {
	
	// 日月年
	public static SimpleDateFormat f1 = new SimpleDateFormat(
			"yyy-mm-dd HH:MM");
	// 歐洲：月日年
	public static SimpleDateFormat f2 = new SimpleDateFormat(
			"yyy-mm-dd 'at' HH:MM:SS");
	
	public static void main(String[] args) {
		java.util.Date today = new java.util.Date();  // retrun 回格式化的格式
		String df1 = f1.format(today);
		System.out.println(df1);
		String df2 = f1.format(today);
		System.out.println(df2);
		
		LocalDate now = LocalDate.now();
		System.out.println(now);
		
		LocalDate birthday = LocalDate.of(1966, 2, 5);  // Brad birthday
		System.out.println(birthday.isLeapYear());
		System.out.println(birthday.isBefore(now));  // 食物有效期
		System.out.println(now.getDayOfMonth());
		
		LocalDate plus3m = birthday.plusMonths(3);  // 加幾個月
		System.out.println(plus3m);
		
		LocalDate n5 = now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));  // 此刻之後的下個星期五是何時？
		System.out.println(n5);
		
		LocalDate an = LocalDate.of(2022, 4, 12);  // 此刻到某日還剩下幾天
		Period period = Period.between(now, an);
		System.out.println(period.getMonths() + "month(s)" + period.getDays() + "day(s)");
		
		long days = ChronoUnit.DAYS.between(birthday, now);  // 你活在這個世上有幾天了
		System.out.println(days);
		
	}

}
