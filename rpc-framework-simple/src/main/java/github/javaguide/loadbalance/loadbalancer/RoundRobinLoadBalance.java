package github.javaguide.loadbalance.loadbalancer;

import github.javaguide.loadbalance.AbstractLoadBalance;
import github.javaguide.remoting.dto.RpcRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 这里的负载均衡含义是:有多个相同的RPC服务可以被调用时，当前应该选择哪个服务。而不是不同的客户端选择哪个服务，需要记录的是RPC服务被调用的情况，不用记录客户端情况。
 * 轮训
 */
@Slf4j
public class RoundRobinLoadBalance extends AbstractLoadBalance {
    private static final ConcurrentHashMap<String,Integer> selectors = new ConcurrentHashMap<>();
    @Override
    protected String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest) {
        String rpcServiceName = rpcRequest.getRpcServiceName();
        Integer pos = selectors.getOrDefault(rpcServiceName,0);
        pos = pos % serviceAddresses.size();
        String serviceAddress = serviceAddresses.get(pos);
        selectors.put(rpcServiceName,pos+1);
        return serviceAddress;
    }
}
