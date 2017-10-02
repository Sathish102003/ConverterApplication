package com.convert.persistence;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.convert.persistence.configuration.TestConfiguration;
import com.converter.domain.persistence.Currency;
import com.converter.domain.persistence.CurrencyCode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class, loader = AnnotationConfigContextLoader.class)
@Transactional(value = "convertTxManager")
public class CurrencyDOTest {
    @Resource
    private CurrencyDO currencyDO;

    @Test
    public void getCurrency() throws Exception {
        final Currency currency = currencyDO.getCurrency(CurrencyCode.EUR, CurrencyCode.INR);
        assertThat(currency.getId(), is(1L));
    }

}