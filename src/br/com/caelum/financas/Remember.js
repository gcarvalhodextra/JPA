/*
********************************************************************************
#Estados da entidade:
Transient -> Quando faz o new
Managed   -> Quando já foi salvo
Detached  -> Quando já deu o em.close(), ela representa o BD mas não está sendo atualizada automaticamente.
Removed   -> Quando é deletada do database.

********************************************************************************
@OneToOne - Cada cliente pode ter apenas 1 conta
@JoinColumn(unique = true) // Condição cada usuario tem a sua conta
private Conta conta;

@OneToMany - Cada usuário pode ter n permissoes *(Não pode salvar a permissão de outros usuários)*
private List<Permissao> permissoes;

@ManyToMany - Muitos para muitos, muitos podem ter a mesma (Cria a tavela de relacionamento)
private List<Categoria> categoria;

@ManyToOne - Muitas Movimentações tem uma conta
private Conta conta;

********************************************************************************
JDBC - Java
JPQL - Java Persistenve Query Language

********************************************************************************
# Select em um campo @ManyToMany
private static void ex03(EntityManager em) {
  Categoria categoria = new Categoria();
  categoria.setId(1);

  String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria order by m.valor desc";
  Query query = em.createQuery(jpql);
  query.setParameter("pCategoria", categoria);

  ((List<Movimentacao>) query.getResultList()).stream().forEach(r -> System.out.println("Resultado -> " + r.getValor()));
}

* ********************************************************************************
#Relacionamento bidirecional
public class Movimentacao {
  @ManyToOne
  private Conta conta;
}

@Entity
public class Conta {
  @OneToMany(mappedBy = "conta")
  private List<Movimentacao> movimentacoes;
}
#mappedBy = "conta" <- Relacionamento forte para ajudar o JPA a entender o relacionamento com a outra tabela


* ********************************************************************************
Lazy Loading (Default) -> Traz as informações no GET
@OneToMany(mappedBy = "conta", fetch = FetchType.LAZY)
private List<Movimentacao> movimentacoes;

@OneToMany(mappedBy = "conta", fetch = FetchType.EAGER) - Se colocar no select não precisa desse
Eager Loading -> Traz tudo -> Transformando em Eager abaixo
// Lista todos os bancos, mesmo que ele não tenha movimentações
// Left join mostra o da esquerda mesmo que o da direita não exista
String jpql = "select distinct  c from Conta c left join fetch c.movimentacoes";
OBS: Precisa do distinct

* ********************************************************************************
# Força o retorno como Double.class
TypedQuery<Double> query = em.createQuery(jpql, Double.class);
List<Double> result = query.getResultList();

* ********************************************************************************
# Utilizando NamedQuery, são processados ao iniciar o hibernate
@Entity
@NamedQuery(query = "select avg(m.valor) from Movimentacao m group by m.data", name = "groupByData")
public class Movimentacao {}

private static void useNamedQuery(EntityManager em) {
    TypedQuery<Double> query = em.createNamedQuery("groupByData", Double.class);
    List<Double> result = query.getResultList();
    result.stream().forEach(m -> System.out.println("Media " + m));
}


* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
* ********************************************************************************
*/