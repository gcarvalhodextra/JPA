package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;

public class MovimentacaoDAO {

    private EntityManager em;

    public MovimentacaoDAO(EntityManager em) {
        this.em = em;
    }

    public BigDecimal getSUM() {
        String jpql = "select sum(m.valor) from Movimentacao m";
        Query query = em.createQuery(jpql);
        return (BigDecimal) query.getSingleResult();
    }
}
