package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Banco {

	private final static List<Empresa> empresas = new ArrayList<>();
	
	private static Integer proximoId = Integer.valueOf(1);
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Curso em Vídeo");
		
		adicionar(empresa1);		
		adicionar(empresa2);
	}
	
	public static void adicionar(Empresa empresa) {
		empresa.setId(proximoId);
		Banco.empresas.add(empresa);
		proximoId++;
	}
	
	public static List<Empresa> getEmpresas(){
		return Collections.unmodifiableList(Banco.empresas);
	}
	
	public static Optional<Empresa> getEmpresaById(Integer id){
		return Banco
				.getEmpresas()
				.stream()
				.filter(empresa -> empresa.getId().equals(id))
				.findFirst();
	}

	public static void editarEmpresa(Integer idEmpresa, Empresa empresa) {
		Integer indexOfEmpresa = empresas.indexOf(getEmpresaById(idEmpresa).get());
		empresa.setId(idEmpresa);
		empresas.set(indexOfEmpresa, empresa);
	}
	
	public static void removerEmpresa(Integer idEmpresa) {
		empresas.remove(getEmpresaById(idEmpresa).get());
	}

}
