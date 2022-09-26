package utils.br.com.serratec;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

	 static NumberFormat formatarValor = new DecimalFormat ("R$ #,##0.00");
	
	public static String doubleToString (Double valor) {
		return formatarValor.format(valor);
	}
	 
	
	
	static public int receberInt() {
		Scanner input = new Scanner(System.in);
		int resp = input.nextInt();
		input.close();
		return resp;
	}
	
	static public String receberString() {
		Scanner input = new Scanner(System.in);
		String resp = input.nextLine();
		input.close();
		return resp;
	}
	
	static public Timestamp receberTimestamp2() {
		Scanner input = new Scanner(System.in);
		try {
		      	System.out.println("DIGITE A DATA DESEJADA (YYYY/MM/DD HH:mm:ss)");
		      	String resp = input.nextLine();
		      	
				DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = formatter.parse(resp);
				Timestamp timeStampDate = new Timestamp(date.getTime());
				input.close();
				return timeStampDate;
		    } 
			catch (ParseException e) {
				System.out.println("Exception :" + e);
				input.close();
				return null;
			}
		
	}
	
	
	
	static public Double receberDouble() {
		Scanner input = new Scanner(System.in);
		Double resp = input.nextDouble();
		input.close();
		return resp;
	}
	
	
	
	
	public static Timestamp receberTimestamp() {
		
		Scanner input = new Scanner(System.in);
		
		Calendar c = Calendar.getInstance();
		System.out.println("DIGITE O ANO");
		int ano = input.nextInt();
		System.out.println("DIGITE O MES");
		int mes = input.nextInt();
		System.out.println("DIGITE O DIA");
		int dia = input.nextInt();
		System.out.println("DIGITE O HORA");
		int hora = input.nextInt();
		System.out.println("DIGITE O MIN");
		int min = input.nextInt();
		System.out.println("DIGITE O SEG");
		int seg = input.nextInt();
		
		c.set(ano, mes-1, dia, hora, min, seg);
								
		Date data = c.getTime();
		
		Timestamp timestamp = new Timestamp(data.getTime());
		input.close();
		return timestamp;
	}
	
	
	
}
