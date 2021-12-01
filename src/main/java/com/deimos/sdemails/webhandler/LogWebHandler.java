package com.deimos.sdemails.webhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.DispatcherHandler;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Mono;


public class LogWebHandler implements WebHandler {
    private static final Logger log = LoggerFactory.getLogger(LogWebHandler.class);

    private final DispatcherHandler defaultHandler;

    public LogWebHandler(DispatcherHandler defaultHandler) {
        this.defaultHandler = defaultHandler;
    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange) {
        log.info("before dispatch: " + exchange.getRequest().getHeaders());
        Mono<Void> result = defaultHandler.handle(exchange);
        log.info("after dispatch: " + exchange.getResponse().getHeaders());
        return result;
    }
}