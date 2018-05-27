package br.com.caelum.financas.util;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

public class PopulaMovimentacoes {

    public static void main(String[] args) {
        Conta conta = new Conta("Itau", "2162", "01 005850-2");

        Categoria cat1 = new Categoria("Viagem");
        Categoria cat2 = new Categoria("Negócios");

        Movimentacao m1 = new Movimentacao();
        m1.setData(Calendar.getInstance());
        m1.setDescricao("Viagem à SP");
        m1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        m1.setValor(new BigDecimal("100.0"));
        m1.setCategorias(Arrays.asList(cat1, cat2));
        m1.setConta(conta);

        Calendar amanha = Calendar.getInstance();
        amanha.add(Calendar.DAY_OF_MONTH, 1);

        Movimentacao m2 = new Movimentacao();
        m2.setData(amanha);
        m2.setDescricao("Viagem ao RJ");
        m2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        m2.setValor(new BigDecimal("300.0"));
        m2.setCategorias(Arrays.asList(cat1, cat2));
        m2.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(conta);

        em.persist(cat1);
        em.persist(cat2);

        em.persist(m1);
        em.persist(m2);

        em.getTransaction().commit();
        em.close();
    }
}
