package provaLP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Janela {

	private String material;
	private Double comprimento;
	private Double altura;
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public Double getComprimento() {
		return comprimento;
	}
	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Janela(String material, Double comprimento, Double altura) {
		super();
		this.material = material;
		this.comprimento = comprimento;
		this.altura = altura;
	}
	
	public void informaMaterial() {
		System.out.println("O material da janela é " +  material);
	}
	
	public void Conexao() {
		String sql = "INSERT INTO janela(material, comprimento, altura) VALUES(?,?,?)";
		try {
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prova", "postgres", "4321");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, material);
		ps.setString(2, comprimento);
		ps.setString(3, altura);
		ps.execute();
		con.commit();
		con.close();
		System.out.println("Cadastrado com sucesso!");
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

}
