package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	private Integer numSala;
	private Date entradaCheck;
	private Date fimCheck;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reserva(Integer numSala, Date entradaCheck, Date fimCheck)  {
		if (!fimCheck.after(entradaCheck)) {
			throw new DomainException("Erro na reserva: a data do check-out deve ser posterior � data do check-in");
		}
		this.numSala = numSala;
		this.entradaCheck = entradaCheck;
		this.fimCheck = fimCheck;
	}


	public Integer getNumSala() {
		return numSala;
	}


	public void setNumSala(Integer numSala) {
		this.numSala = numSala;
	}


	public Date getEntradaCheck() {
		return entradaCheck;
	}

	public Date getFimCheck() {
		return fimCheck;
	}
	
	public long duracao() {
		long diff = fimCheck.getTime() - entradaCheck.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void dataAtualizacao(Date entradaCheck, Date fimCheck) {
		
		Date now = new Date();
		if (entradaCheck.before(now) || fimCheck.before(now)) {
			throw new DomainException("Erro na reserva, a reserva tem que ser com datas futuras!");
		}
		if (!fimCheck.after(entradaCheck)) {
			throw new DomainException("Erro na reserva: a data do check-out deve ser posterior � data do check-in");
		}
		this.entradaCheck = entradaCheck;
		this.fimCheck = fimCheck;
	}
	
	@Override
	public String toString() {
		return "Sala "
				+ numSala
				+ ", check-in: "
				+ sdf.format(entradaCheck)
				+ ", check-out: "
				+ sdf.format(fimCheck)
				+ ", "
				+ duracao()
				+ " noites.";
	}
}
