package week11.distributed;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

import java.util.Random;

/**
 * @PROJECT_NAME: JAVA-000
 * @PACKAGE_NAME: week11.distributed
 * @NAME: RedisPubSub
 * @Author: guanys
 * @DATE: 1/5/21:11:40 PM
 * @Description: TODO
 * @Version: 1.0
 **/
public class RedisPubSub {

    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        JedisPool jedisPool  = new JedisPool(jedisPoolConfig, "192.168.1.1");

        String channelName = "order channel";

        new SubscribeOrder(jedisPool, channelName);
        new PublishOrder(jedisPool, channelName);
    }

}


/**
 * 订阅订单信息
 */
class SubscribeOrder {

    public SubscribeOrder(final JedisPool jedisPool, final String channelName) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start subscriber order");
                try (Jedis jedis = jedisPool.getResource()) {
                    jedis.subscribe(setupSubscriber(), channelName);
                }
            }
        }, "subscriberThread").start();
    }

    private JedisPubSub setupSubscriber() {
        return new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                if (message.isEmpty()) {
                    System.out.println("SubPub End");
                    System.exit(0);
                }
                System.out.printf("Receive message from %s :: %s\n", channel, message);
            }
        };
    }
}

/**
 * 发布订单信息
 */
class PublishOrder {

    public PublishOrder(JedisPool jedisPool, String channelName) {
        System.out.println("Start publisher order");
        try (Jedis jedis = jedisPool.getResource()) {
            int sleepTime = 0;
            for (int i = 0; i < 10; i++) {
                sleepTime = new Random().nextInt(10) + 1;

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                jedis.publish(channelName, "order publish " + sleepTime);
            }
            jedis.publish(channelName, "");
        }
    }
}
