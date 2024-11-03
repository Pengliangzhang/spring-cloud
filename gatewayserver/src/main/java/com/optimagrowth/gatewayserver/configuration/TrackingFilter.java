package com.optimagrowth.gatewayserver.configuration;

import com.optimagrowth.gatewayserver.util.FilterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(1)
@Component
public class TrackingFilter implements GlobalFilter {
    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);
    @Autowired
    private FilterUtils filterUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        if (isCorrelationIdPresent(httpHeaders)) {
            logger.debug("correlation-id found in tracking filter: {}.", filterUtils.getCorrelationId(httpHeaders));
        } else {
            String correlationId = generateCorrelationId();
            exchange = filterUtils.setCorrelationId(exchange, correlationId);
            logger.debug("correlation-id generated in tracking filter: {}.", correlationId);
        }
        return chain.filter(exchange);
    }

    private boolean isCorrelationIdPresent(HttpHeaders httpHeaders) {
        if (filterUtils.getCorrelationId(httpHeaders) != null) {
            return true;
        } else {
            return false;
        }
    }

    private String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }
}
