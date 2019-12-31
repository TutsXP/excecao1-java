package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numSala = sc.nextInt();
		System.out.print("Check-in data (dia/mes/ano): ");
		Date entradaCheck = sdf.parse(sc.next());
		System.out.print("Check-out data (dia/mes/ano): ");
		Date fimCheck = sdf.parse(sc.next());
		
		if (!fimCheck.after(entradaCheck)) {
			System.out.println("Erro na reserva: a data do check-out deve ser posterior à data do check-in");
		}
		else {
			Reserva reserva = new Reserva(numSala, entradaCheck, fimCheck);
			System.out.println("Reserva: " + reserva);
			
			
			System.out.println();
			System.out.println("Digite a data da atualizacao da reserva");
			System.out.print("Check-in data (dia/mes/ano): ");
			entradaCheck = sdf.parse(sc.next());
			System.out.print("Check-out data (dia/mes/ano): ");
			fimCheck = sdf.parse(sc.next());
			
			Date now = new Date();
			if (!fimCheck.after(entradaCheck)) {
				System.out.println("Erro na reserva: a data do check-out deve ser posterior à data do check-in");
			}
			else if (entradaCheck.before(now) || fimCheck.before(now)) {
				System.out.println("Erro na reserva, a reserva tem que ser com datas futuras!");
			}
			
			else {
				reserva.dataAtualizacao(entradaCheck, fimCheck);
				System.out.println("Reserva: " + reserva);
			}
		}
		sc.close();
		}

}
