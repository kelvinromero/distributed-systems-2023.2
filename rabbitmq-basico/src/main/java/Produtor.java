import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Produtor {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        try (
                Connection connection = connectionFactory.newConnection();
                Channel canal = connection.createChannel();
        ) {
            String mensagem = "Ola de Kelvin Romero Meira de Oliveira Cordeiro" + ".";
            String NOME_FILA = "TESTE";

            //(queue, passive, durable, exclusive, autoDelete, arguments)
            boolean durable = true;
            canal.queueDeclare(NOME_FILA, durable, false, false, null);

            // ​(exchange, routingKey, mandatory, immediate, props, byte[] body)
            canal.basicPublish("", NOME_FILA, false, false, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem.getBytes());
            System.out.println("Mensagem enviada: " + mensagem);
        }
    }
}


