package com.convert.service;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.WebServiceMessageSender;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import static org.apache.http.conn.socket.PlainConnectionSocketFactory.getSocketFactory;

/**
 * ClientConfig.
 */
@Configuration
@EnableCaching
public class ConverterConfig {

    private static final int TTL_VALUE = 1000;

/*    @Rates("classpath:${ssl.keystore.file}")
    private Resource ccKeystoreFile;

    @Rates("${ssl.keystore.password}")
    private String ccKeystorePassword;*/

    @Value("${endpoint.url}")
    private String ccEndpointUrl;

    @Value("#{ T(java.lang.Integer).parseInt('${http.connect.timeout}') }")
    private Integer connectionTimeout;
    @Value("#{ T(java.lang.Integer).parseInt('${http.read.timeout}') }")
    private Integer readTimeout;

    @Value("#{ T(java.lang.Integer).parseInt('${http.max.connections.per.host}') }")
    private Integer maxConnectionsPerHost;
    @Value("#{ T(java.lang.Integer).parseInt('${http.max.total.connections}') }")
    private Integer totalConnections;

    @Bean
    public Jaxb2Marshaller ccJaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPaths("org.tempuri");
        return jaxb2Marshaller;
    }

    @Bean
    public SaajSoapMessageFactory messageFactory() {
        return new SaajSoapMessageFactory();
    }

    @Bean
    public WebServiceTemplate ccWebServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(ccJaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(ccJaxb2Marshaller());
        webServiceTemplate.setDefaultUri(ccEndpointUrl);
        webServiceTemplate.setMessageSender(ccHttpMessageSender());
        return webServiceTemplate;
    }

    @Bean
    public WebServiceMessageSender ccHttpMessageSender() {
        return new HttpComponentsMessageSender(ccHttpClient());
    }

    @Bean
    public HttpClient ccHttpClient() {
        return HttpClientBuilder.create()
                .setConnectionManager(ccPoolingClientConnectionManager())
                .setDefaultRequestConfig(ccBuildRequestConfig())
                .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor())
                .disableConnectionState()
                .build();
    }

    @Bean
    public RequestConfig ccBuildRequestConfig() {
        return RequestConfig.custom().setConnectTimeout(connectionTimeout)
                .setSocketTimeout(readTimeout).build();
    }

    @Bean
    public PoolingHttpClientConnectionManager ccPoolingClientConnectionManager() {
        final PoolingHttpClientConnectionManager connectionManager =
                new PoolingHttpClientConnectionManager(ccBuildSocketRegistry());
        connectionManager.setDefaultMaxPerRoute(maxConnectionsPerHost);
        connectionManager.setMaxTotal(totalConnections);
        connectionManager.setValidateAfterInactivity(TTL_VALUE);
        return connectionManager;
    }

    @Bean
    public Registry<ConnectionSocketFactory> ccBuildSocketRegistry() {
        return RegistryBuilder.<ConnectionSocketFactory>create().register("http", getSocketFactory())
                .register("https",  /*ccSslSocketFactory()*/getSocketFactory()).build();
    }

    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheCacheManager().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
        EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
        cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
        cmfb.setShared(true);
        return cmfb;
    }

    /*  @Bean
        public SSLConnectionSocketFactory ccSslSocketFactory() throws GeneralSecurityException, IOException {
            final SSLContextBuilder contextBuilder = new SSLContextBuilder();
            contextBuilder.loadTrustMaterial(ccTrustStore(), null);
            contextBuilder.loadKeyMaterial(ccTrustStore(), ccKeystorePassword.toCharArray());
            return new SSLConnectionSocketFactory(contextBuilder.build(), NoopHostnameVerifier.INSTANCE);
        }

    @Bean
    public KeyStore ccTrustStore() throws GeneralSecurityException, IOException {
        try (InputStream keyStoreStream = ccKeystoreFile.getInputStream()) {
            if (keyStoreStream == null) {
                throw new ConverterException("Keystore file not found : " + ccKeystoreFile);
            }
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(keyStoreStream, ccKeystorePassword.toCharArray());
            return ks;
        }
    }*/

}
