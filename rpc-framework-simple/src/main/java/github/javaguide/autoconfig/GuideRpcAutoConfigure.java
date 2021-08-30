package github.javaguide.autoconfig;

import github.javaguide.loadbalance.LoadBalance;
import github.javaguide.provider.ServiceProvider;
import github.javaguide.registry.ServiceDiscovery;
import github.javaguide.registry.ServiceRegistry;
import github.javaguide.remoting.transport.RpcRequestTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(GuideRpcProperties.class)
public class GuideRpcAutoConfigure {
    @Autowired
    private GuideRpcProperties properties;

    @ConditionalOnMissingBean(LoadBalance.class)
    @Bean
    public LoadBalance loadBalance() throws Exception {
        System.out.println(properties.getLoadBalance());
        try {
            return (LoadBalance) GuideRpcAutoConfigure.class.getClassLoader().loadClass(properties.getLoadBalance()).newInstance();
        } catch (Exception e){
            throw new Exception("An error occurred while creasting loadBalance. Check the configuration file",e);
        }
        // return ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("loadBalance");
    }

    @ConditionalOnMissingBean(ServiceDiscovery.class)
    @Bean
    public ServiceDiscovery serviceDiscovery() throws Exception {
        System.out.println(properties.getServiceDiscovery());
        try {
            return (ServiceDiscovery) GuideRpcAutoConfigure.class.getClassLoader().loadClass(properties.getServiceDiscovery()).newInstance();
        } catch (Exception e){
            throw new Exception("An error occurred while creating serviceDiscovery. Check the configuration file",e);
        }
    }

    @ConditionalOnMissingBean(ServiceRegistry.class)
    @Bean
    public ServiceRegistry serviceRegistry() throws Exception {
        System.out.println(properties.getServiceRegistry());
        try {
            return (ServiceRegistry) GuideRpcAutoConfigure.class.getClassLoader().loadClass(properties.getServiceRegistry()).newInstance();
        } catch (Exception e){
            throw new Exception("An error occurred while creating serviceRegistry. Check the configuration file",e);
        }
    }

    @ConditionalOnMissingBean(ServiceProvider.class)
    @Bean
    public ServiceProvider serviceProvider() throws Exception {
        System.out.println(properties.getServiceRegistry());
        try {
            return (ServiceProvider) GuideRpcAutoConfigure.class.getClassLoader().loadClass(properties.getServiceProvider()).newInstance();
        } catch (Exception e){
            throw new Exception("An error occurred while creating serviceProvider. Check the configuration file",e);
        }
    }

    @ConditionalOnMissingBean(RpcRequestTransport.class)
    @Bean
    public RpcRequestTransport rpcRequestTransport() throws Exception {
        System.out.println(properties.getServiceRegistry());
        try {
            return (RpcRequestTransport) GuideRpcAutoConfigure.class.getClassLoader().loadClass(properties.getRpcRequestTransport()).newInstance();
        } catch (Exception e){
            throw new Exception("An error occurred while creating serviceRegistry. Check the configuration file",e);
        }
    }
}
