package github.javaguide.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rpc")
public class GuideRpcProperties {
    private String loadBalance;

    private String compressType;

    private String serializationType;

    private String serviceDiscovery;

    private String serviceRegistry;

    private String rpcRequestTransport;

    private String serviceProvider;

    public String getLoadBalance() {
        return loadBalance;
    }

    public void setLoadBalance(String loadBalance) {
        this.loadBalance = loadBalance;
    }

    public String getCompressType() {
        return compressType;
    }

    public void setCompressType(String compressType) {
        this.compressType = compressType;
    }

    public String getSerializationType() {
        return serializationType;
    }

    public void setSerializationType(String serializationType) {
        this.serializationType = serializationType;
    }

    public String getServiceDiscovery() {
        return serviceDiscovery;
    }

    public void setServiceDiscovery(String serviceDiscovery) {
        this.serviceDiscovery = serviceDiscovery;
    }

    public String getServiceRegistry() {
        return serviceRegistry;
    }

    public void setServiceRegistry(String serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
    }

    public String getRpcRequestTransport() {
        return rpcRequestTransport;
    }

    public void setRpcRequestTransport(String rpcRequestTransport) {
        this.rpcRequestTransport = rpcRequestTransport;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
