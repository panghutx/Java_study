package junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class ParameterTest {
    @ParameterizedTest
    @ValueSource(strings = {"张忠智","王文凯","胖虎同学"})
    void name(String name){
        System.out.println("name:"+name);
    }

    @ParameterizedTest
    @CsvSource(value = {"张忠智-19","王文凯-20"},delimiterString = "-")
    void nameAndAge(String name,int age){
        System.out.println("name:"+name+",age:"+age);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/my.csv")
    void multiFile(String name,int age){
        System.out.println("name:"+name+",age:"+age);
    }

    @ParameterizedTest
    @MethodSource
    void dynamic(String name){
        System.out.println("name:"+name);
    }
    static Stream<String> dynamic(){
        return Stream.of("张忠智","王文凯","胖虎");
    }

    @ParameterizedTest
    @MethodSource
    void dynamicMul(String name,int age){
        System.out.println("name:"+name+",age:"+age);
    }
    static Stream<Arguments> dynamicMul(){
        return Stream.of(Arguments.arguments("张忠智",20),Arguments.arguments("王文凯",22));
    }
}
