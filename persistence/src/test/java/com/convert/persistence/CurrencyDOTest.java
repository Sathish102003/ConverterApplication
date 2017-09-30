package com.convert.persistence;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.convert.persistence.configuration.TestConfiguration;
import com.convert.persistence.model.Currency;
import com.convert.persistence.model.CurrencyCode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class, loader = AnnotationConfigContextLoader.class)
@Transactional(value = "convertTxManager")
public class CurrencyDOTest {

    @Resource
    private CurrencyDO currencyDO;

    @Test
    public void getCurrency() throws Exception {
        assertThat(currencyDO.getCurrency(1).getId(), is(1L));
    }

    @Test
    public void getAllCurrencies() throws Exception {
        assertEquals(2, currencyDO.getAllCurrencies().size());
    }

    @Test
    public void create() throws Exception {
        final Currency currency = new Currency();
        currency.setFromCurrencyCode(CurrencyCode.AED);
        currencyDO.create(currency);
        assertEquals(3, currencyDO.getAllCurrencies().size());
    }

}