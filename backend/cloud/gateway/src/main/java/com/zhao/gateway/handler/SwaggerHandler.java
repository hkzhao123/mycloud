package com.zhao.gateway.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.*;

import java.util.Optional;

/**
 * <h3>cloud</h3>
 * <p></p>
 *
 * @author : hkzhao
 * @date : 2020-07-23 22:43
 **/
@RestController
public class SwaggerHandler {
    @Autowired(required = false)
    private SecurityConfiguration securityConfiguration;

    @Autowired(required = false)
    private UiConfiguration uiConfiguration;

    private final SwaggerResourcesProvider swaggerResources;


    public SwaggerHandler(SwaggerResourcesProvider swaggerResources) {
        this.swaggerResources = swaggerResources;
    }

    /*
    * Swagger安全配置,支持oauth和apiKey设置
    *
    */

    @GetMapping("/swagger-resources/configuration/security")
    public Mono<ResponseEntity<SecurityConfiguration>> securityConfiguration(){
        return Mono.just(new ResponseEntity<>(Optional.ofNullable(securityConfiguration).orElse(SecurityConfigurationBuilder.builder().build()), HttpStatus.OK));
    }

    /*
    * SwaggerUi配置
    *
    */

    @GetMapping("/swagger-resources/configuration/ui")
    public Mono<ResponseEntity<UiConfiguration>> uiConfiguration(){
        return Mono.just(new ResponseEntity<>(
                Optional.ofNullable(uiConfiguration).orElse(UiConfigurationBuilder.builder().build()),HttpStatus.OK));
    }
    /*
    *Swagger资源配置，微服务中各个服务的api-docs信息
    */

    @GetMapping("/swagger-resources")
    public Mono<ResponseEntity> swaggerResource(){
        return Mono.just((new ResponseEntity<>(swaggerResources.get(),HttpStatus.OK)));
    }
}
