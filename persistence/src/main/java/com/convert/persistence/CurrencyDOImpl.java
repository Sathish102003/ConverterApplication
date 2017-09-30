package com.convert.persistence;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.convert.persistence.model.Currency;

@Component
public class CurrencyDOImpl implements CurrencyDO {

    private static final String GET_ALL_CURRENCIES = "getAllCurrencies";

    @PersistenceContext(unitName = "convertPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public Currency getCurrency(final long id) {
        return this.entityManager.find(Currency.class, id);
    }

    @Override
    public void create(final Currency currency) {
        this.entityManager.persist(currency);
    }

    @Override
    public List<Currency> getAllCurrencies() {
        final TypedQuery<Currency> currencyTypedQuery =
                entityManager.createNamedQuery(GET_ALL_CURRENCIES, Currency.class);
        return currencyTypedQuery.getResultList();
    }
}
