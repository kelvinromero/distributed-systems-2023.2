import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Producer {
    private static final String EXCHANGE_NAME = "exchange_direct";
    private static final String[] SEVERITIES = { "info", "warning", "error" };

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        try (
                Connection connection = connectionFactory.newConnection();
                Channel channel = connection.createChannel();
        ) {
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            System.out.println("Kelvin Romero");
            for (String severity : SEVERITIES) {
                String message = "Log message with severity: " + severity;
                channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "' with severity '" + severity + "'");
            }
        }
    }
}


