package junit;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitTest {
    @Test
    void aaa(){
        System.out.println("aaa");
    }
    @Test
    @Order(1)
    void bbb(){
        System.out.println("bbb");
    }
    @Test
    void ccc(){
        System.out.println("ccc");
    }
}
