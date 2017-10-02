package com.convert.persistence;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.converter.domain.persistence.Currency;
import com.converter.domain.persistence.CurrencyCode;

@Component
public class CurrencyDOImpl implements CurrencyDO {

    @PersistenceContext(unitName = "convertPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public Currency getCurrency(final CurrencyCode fromCurrencyCode, final CurrencyCode toCurrencyCode) {
        final TypedQuery<Currency> query =
                entityManager.createNamedQuery("getCurrency", Currency.class);
        query.setParameter("fromCurrencyCode", fromCurrencyCode);
        query.setParameter("toCurrencyCode", toCurrencyCode);
        final List<Currency> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }

    @Override
    public void create(final Currency currency) {
        this.entityManager.persist(currency);
    }
}
