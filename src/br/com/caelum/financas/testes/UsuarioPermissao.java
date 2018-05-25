package br.com.caelum.financas.testes;

import br.com.caelum.financas.modelo.Permissao;
import br.com.caelum.financas.modelo.Usuario;
import br.com.caelum.financas.util.JPAUtil;
import java.util.Arrays;
import javax.persistence.EntityManager;

public class UsuarioPermissao {

  public static void main(String[] args) {

    Permissao per01 = new Permissao("ADMIN");
    Permissao per02 = new Permissao("RH");
    Permissao per03 = new Permissao("FINANCEIRO");

    Usuario us01 = new Usuario();
    us01.setNome("Thamires");
    us01.setPermissoes(Arrays.asList(per01, per02));

    Usuario us02 = new Usuario();
    us02.setNome("Michelle");
    us02.setPermissoes(Arrays.asList(per03));

    EntityManager em = new JPAUtil().getEntityManager();
    em.getTransaction().begin();

    em.persist(per01);
    em.persist(per02);
    em.persist(per03);

    em.persist(us01);
    em.persist(us02);

    em.getTransaction().commit();
    em.close();
  }
}
