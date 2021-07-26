package github.javaguide.transport;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;

import java.nio.charset.StandardCharsets;

public class CuratorTest {
    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1")
                .sessionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .namespace("test")
                .build();
        client.start();
        client.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/0","hello".getBytes(StandardCharsets.UTF_8));

    }
}
