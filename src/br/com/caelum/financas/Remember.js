/*
********************************************************************************
Estados da entidade:
Transient -> Quando faz o new
Managed   -> Quando já foi salvo
Detached  -> Quando já deu o em.close(), ela representa o BD mas
não está sendo atualizada automaticamente.
Removed   -> Quando é deletada do database.

********************************************************************************
@OneToOne - Cada cliente pode ter apenas 1 conta
@JoinColumn(unique = true) // Se não colocar isso ele aceita dois clientes com a mesma conta
@OneToOne
private Conta conta; 

@OneToMany - Apenas 1 usuário pode ter essa permissão
1 usuário pode ter N permissões, porem não repete para outros usuários
@Entity
public class Usuario {
   @OneToMany
   private List<Permissao> permissoes;
}
@Entity
public class Permissao {
}

@ManyToMany - Muitos para muitos, muitos podem ter a mesma
@ManyToMany
private List<Categoria> categoria;

********************************************************************************

















********************************************************************************
*/