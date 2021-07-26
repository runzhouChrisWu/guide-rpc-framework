package github.javaguide.loadbalance.loadbalancer;

import github.javaguide.loadbalance.AbstractLoadBalance;
import github.javaguide.remoting.dto.RpcRequest;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TrainLoadBalance extends AbstractLoadBalance {
    private final ConcurrentHashMap<Integer,Integer> selectors = new ConcurrentHashMap<>();
    @Override
    protected String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest) {
        if (serviceAddresses == null) {
            return null;
        }
        Integer index,hashCode = System.identityHashCode(serviceAddresses);
        index = selectors.get(hashCode);
        if (index != null) {
            selectors.put(hashCode,index+1);
            return serviceAddresses.get(index+1);
        }
        selectors.put(hashCode,0);
        return serviceAddresses.get(0);
    }
}
