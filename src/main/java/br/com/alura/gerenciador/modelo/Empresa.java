package br.com.alura.gerenciador.modelo;

import java.util.Date;
import javax.servlet.ServletException;
import br.com.alura.gerenciador.utils.DateUtil;

public class Empresa {

	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "[ Empresa: "+this.nome+", Data Abertura: "+this.dataAbertura+" ]";
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	public String getDataAberturaFormated(){
		try {
			return DateUtil.dateFromStringInput(dataAbertura);
		} catch (ServletException e ) {
			throw new RuntimeException(e);
		}
	}
}
