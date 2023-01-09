package com.freestrokes;

import com.freestrokes.controller.BoardController;
import com.freestrokes.proxy.CashPerf;
import com.freestrokes.proxy.Payment;
import com.freestrokes.proxy.Store;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@RunWith(SpringRunner.class)
@SpringBootTest()
public class ProxyPatternTests {

    @Test
    public void contextLoads() {
        Payment cashPerf = new CashPerf();
        Store store = new Store(cashPerf);
        store.buySomething(100);
    }

}
