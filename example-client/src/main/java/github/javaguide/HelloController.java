package github.javaguide;

import github.javaguide.annotation.RpcReference;
import org.springframework.stereotype.Component;

/**
 * @author smile2coder
 */
@Component
public class HelloController {

    @RpcReference(version = "version1", group = "test1")
    private HelloService helloService;

    public void test() throws InterruptedException {
       this.helloService.hello(new Hello("111", "123"));
       this.helloService.hello(new Hello("111", "546"));
       this.helloService.hello(new Hello("111", "546"));
       this.helloService.hello(new Hello("111", "546"));
       this.helloService.hello(new Hello("111", "546"));
       this.helloService.hello(new Hello("111", "546"));
       this.helloService.hello(new Hello("111", "546"));
       this.helloService.hello(new Hello("111", "546"));
       this.helloService.hello(new Hello("111", "546"));
        // this.helloService.hello(new Hello("111", "25422"));
        //如需使用 assert 断言，需要在 VM options 添加参数：-ea
        // assert "Hello description is 222".equals(hello);
        // Thread.sleep(12000);
        // for (int i = 0; i < 10; i++) {
        //     System.out.println(helloService.hello(new Hello("111", "222")));
        // }
    }
}
