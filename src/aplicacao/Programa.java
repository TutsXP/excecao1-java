package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.exceptions.DomainException;
import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
		
			System.out.print("Numero do quarto: ");
				int numSala = sc.nextInt();
			System.out.print("Check-in data (dia/mes/ano): ");
				Date entradaCheck = sdf.parse(sc.next());
			System.out.print("Check-out data (dia/mes/ano): ");
				Date fimCheck = sdf.parse(sc.next());
			
			
			
			Reserva reserva = new Reserva(numSala, entradaCheck, fimCheck);
			System.out.println("Reserva: " + reserva);
			
			
			System.out.println();
			System.out.println("Digite a data da atualizacao da reserva");
			System.out.print("Check-in data (dia/mes/ano): ");
				entradaCheck = sdf.parse(sc.next());
			System.out.print("Check-out data (dia/mes/ano): ");
				fimCheck = sdf.parse(sc.next());
			
			
			reserva.dataAtualizacao(entradaCheck, fimCheck);
			
			System.out.println("Reserva: " + reserva);
		}
		catch(ParseException e) {
			System.out.println("Data invalida!");
		}
		catch(DomainException e) {
			System.out.println("Erro de reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro!");
		}
		sc.close();
		}

}
