package github.javaguide.loadbalance.loadbalancer;

import github.javaguide.loadbalance.AbstractLoadBalance;
import github.javaguide.remoting.dto.RpcRequest;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  权重负载均衡
 */
public class WeightRandomLoadBalance extends AbstractLoadBalance {
    static int index = 0;

    @Override
    protected String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest) {
        List<Integer> weights = serviceAddresses.stream().map(s -> {
                    int lastIndex = s.lastIndexOf("%");
            return Integer.parseInt(s.substring(lastIndex+1));
                }
        ).collect(Collectors.toList());

        int allWeights = weights.stream().mapToInt(k->k).sum();
        int number = (index++) % allWeights;

        for (int i = 0; i < weights.size(); i++) {
            if(weights.get(i) > number){
                return serviceAddresses.get(i);
            }
            number -= weights.get(i);
        }

        return "";
    }
}
