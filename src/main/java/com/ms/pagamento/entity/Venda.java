package com.ms.pagamento.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

public class Venda implements Serializable{

	private static final long serialVersionUID = -6824647952178312220L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name = "data", nullable = false)
	private Date data;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venda", cascade = CascadeType.REFRESH)
	private List<ProdutoVenda> produtos;
	
	@Column(name = "valor_total", nullable = false, length = 10)
	private Double valorTotal;
	

}
