package github.javaguide.registry.zk;

import github.javaguide.registry.ServiceRegistry;
import github.javaguide.registry.zk.util.CuratorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;

/**
 * service registration  based on zookeeper
 *
 * @author shuang.kou
 * @createTime 2020年05月31日 10:56:00
 */
@Slf4j
public class ZkServiceRegistryImpl implements ServiceRegistry {

    @Override
    public void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress) {
//      servicePath等同于：/my-rpc/github.javaguide.HelloServicetest2version2/192.168.2.14:9998  从这里可以看出来，放入zk中的节点里包括了一个IP+端口的节点
        String servicePath = CuratorUtils.ZK_REGISTER_ROOT_PATH + "/" + rpcServiceName + inetSocketAddress.toString();
//        System.out.println(servicePath+"AAA");
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        CuratorUtils.createEphemeralNode(zkClient, servicePath);
    }
}
