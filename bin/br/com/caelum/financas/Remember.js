/*
********************************************************************************
Estados da entidade:
Transient -> Quando faz o new
Managed   -> Quando já foi salvo
Detached  -> Quando já deu o em.close(), ela representa o BD mas
não está sendo atualizada automaticamente.
Removed   -> Quando é deletada do database.

********************************************************************************
@Entity
public class Usuario {
   @OneToMany
   private List<Permissao> permissoes;
}
@Entity
public class Permissao {
}
@OneToMany - Apenas 1 usuário pode ter essa permissão
1 usuário pode ter N permissões, porem não repete para outros usuários

********************************************************************************

















********************************************************************************
*/