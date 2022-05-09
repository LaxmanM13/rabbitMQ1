package com.iauro.rabbitMQ.configuration;


import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;

public class RabbitMQConfig {


    public static final String ROUNTING_A=routing.A;
    public static final String  ROUTING_B=routing.B;
    @congiguration
    public class RabbitMQConfig  {
        @Bean
        Queue queueA() {
            return new Queue();
        }
        @Bean
        Queue queueB()
        {
            return new Queue();
        }

        @Bean
        DirectExchange exchange() {
            return new DirectExchange();
        }


        @Bean
        Binding binding(Queue queueA, DirectExchnage exchnage) {
            return BindingBuilder.bind(queueA)
                    .to(exchange)
                    .with(ROUTING_A);
        }

        @Bean
        Binding binding(Queue queueB,DirectExchange exchange)
        {
            return BindingBuilder.bind(QueueB)
                    .to(exchange)
                    .with(ROUTING_B);
        }

        @Bean
        RabbitTemplate rabbitTemplate(ConnectionFactory factory) {
            RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
            rabbitTemplate.setMessageConverter(messageConverter());
            return rabbitTemplate;
        }


    }
}

