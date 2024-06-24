package com.pieropan.propostaapp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue criarFilaPropostaPendenteMsAnaliseCredito(){
        return QueueBuilder.durable("proposta-pendente.ms-analise-credito").build();
    }

    @Bean
    public Queue criarFilaPropostaPendenteMsAnaliseNotificacao(){
        return QueueBuilder.durable("proposta-pendente.ms-analise-notificacao").build();
    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsAnaliseCredito(){
        return QueueBuilder.durable("proposta-concluida.ms-proposta").build();
    }

    @Bean
    public Queue criarFilaPropostaConcluidaPendenteMsAnaliseNotificacao(){
        return QueueBuilder.durable("proposta-concluida.ms-notificacao").build();
    }
}
