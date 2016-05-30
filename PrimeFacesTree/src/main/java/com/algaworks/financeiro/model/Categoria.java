package com.algaworks.financeiro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private String analiticoSintetico;
	private BigDecimal quantidadeHoras;
	private Categoria categoriaPai;
	private List<Categoria> subcategorias;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 80, nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

		
	public String getAnaliticoSintetico() {
		return analiticoSintetico;
	}

	public void setAnaliticoSintetico(String analiticoSintetico) {
		this.analiticoSintetico = analiticoSintetico;
	}

	public BigDecimal getQuantidadeHoras() {
		return quantidadeHoras;
	}

	public void setQuantidadeHoras(BigDecimal quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
	}

	@ManyToOne
	@JoinColumn(name = "categoria_pai")
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	@OneToMany(mappedBy = "categoriaPai")
	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(List<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  descricao;
	}

}