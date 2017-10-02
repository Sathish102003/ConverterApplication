package com.convert.persistence;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.convert.persistence.exception.NoResultFoundException;
import com.converter.domain.persistence.Currency;
import com.converter.domain.persistence.CurrencyCode;

@Component
public class CurrencyDOImpl implements CurrencyDO {

    @PersistenceContext(unitName = "convertPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public Currency getCurrency(final CurrencyCode fromCurrencyCode, final CurrencyCode toCurrencyCode) throws NoResultFoundException {
        final TypedQuery<Currency> query =
                entityManager.createNamedQuery("getCurrency", Currency.class);
        query.setParameter("fromCurrencyCode", fromCurrencyCode);
        query.setParameter("toCurrencyCode", toCurrencyCode);
        final List<Currency> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            throw new NoResultFoundException("No Currency Conversion is available");
        }
        return resultList.get(0);
    }

    @Override
    public void create(final Currency currency) {
        this.entityManager.persist(currency);
    }
}
