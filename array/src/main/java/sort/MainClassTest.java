package sort;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class MainClassTest {
    @Test
    @DisplayName("메인클래스의 메인메소드에 특수문자가 들어갈 경우")
    public void testMain() {

        //given -일반적인 메인클래스의 조작이 발생할 때,
        String[] args = {"Hello world!"};


        //when
        Main.main(args);


        //then

    }
}
