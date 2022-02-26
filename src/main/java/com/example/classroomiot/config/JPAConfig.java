//package com.example.classroomiot.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableJpaRepositories(basePackages = {"com.example.classroomiot.logic.repository"})
//@EnableTransactionManagement
//public class JPAConfig {
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPersistenceUnitName("persistence-data");
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(additionalProperties());
//        return em;
//    }
//
//    @Qualifier("transactionManager")
//    @Bean
//    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
//        return jpaTransactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor(){
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/iot?useSSL=true");
//        dataSource.setUsername("root");
//        dataSource.setPassword("$1234");
//        return dataSource;
//    }
//
//    Properties additionalProperties(){
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect" , "org.hibernate.dialect.PostgreSQL9Dialect");
//        properties.setProperty("hibernate.show_sql" , "true");
//        properties.setProperty("hibernate.format_sql" , "true");
//        //properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//        //properties.setProperty("hibernate.hbm2ddl.auto", "create");
//        properties.setProperty("hibernate.hbm2ddl.auto", "none");
////        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
//        return properties;
//
//    }
//
//}
