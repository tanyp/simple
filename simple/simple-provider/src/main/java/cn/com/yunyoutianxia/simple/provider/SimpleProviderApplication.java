package cn.com.yunyoutianxia.simple.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableDiscoveryClient
@MapperScan("cn.com.yunyoutianxia.simple.provider.mapper")
public class SimpleProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleProviderApplication.class, args);
    }

//    @Primary
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.one")
//    public DataSource dataSourceOne(){
//        return DruidDataSourceBuilder.create().build();
//    }
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.two")
//    public DataSource dataSourceTwo(){
//        return DruidDataSourceBuilder.create().build();
//    }
}
