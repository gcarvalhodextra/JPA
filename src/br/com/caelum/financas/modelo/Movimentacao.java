package br.com.caelum.financas.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Entity
@NamedQuery(query = "select avg(m.valor) from Movimentacao m group by m.data", name = "groupByData")
public class Movimentacao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private BigDecimal valor;

  // Define um Enum para salvar no banco de daos ENTRADA e SAIDA
  @Enumerated(EnumType.STRING)
  private TipoMovimentacao tipoMovimentacao;

  /**
   * Pode ser:
   * DATE: Somente a data, sem a hora;
   * TIME: Somente a hora, sem data;
   * TIMESTAMP: Tanto data quanto hora.
   */
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar data;

  @ManyToOne
  private Conta conta;

  private String descricao;

  @ManyToMany
  private List<Categoria> categoria;

  public Movimentacao() {
  }

  public Movimentacao(BigDecimal valor, TipoMovimentacao tipoMovimentacao, Calendar data, Conta conta, String descricao,
    List<Categoria> categoria) {
    this.valor = valor;
    this.tipoMovimentacao = tipoMovimentacao;
    this.data = data;
    this.conta = conta;
    this.descricao = descricao;
    this.categoria = categoria;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public TipoMovimentacao getTipoMovimentacao() {
    return tipoMovimentacao;
  }

  public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
    this.tipoMovimentacao = tipoMovimentacao;
  }

  public Calendar getData() {
    return data;
  }

  public void setData(Calendar data) {
    this.data = data;
  }

  public Conta getConta() {
    return conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public List<Categoria> getCategorias() {
    return categoria;
  }

  public void setCategorias(List<Categoria> categoria) {
    this.categoria = categoria;
  }
}