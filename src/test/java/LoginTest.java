




import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;





public class LoginTest {
    static MainPage mainPage;
    static ProfilePage profilePage;

    @BeforeAll
    static void beforeAll(){
        mainPage=MainPage.start();
        profilePage=mainPage.gotoProfile();
    }



    @ParameterizedTest
    @CsvSource({
            "1825206302,xxxxxxxxxxx,手机号码填写错误",
            "18252063029,xxxxxxxxxxxx,用户名或密码错误"
    })
    public void 密码登录(String username,String password, String expection){
        LoginPage loginPage=profilePage.gotoLogin();
        loginPage.passwordFail(username,password);
        assertThat(loginPage.getMessage(),equalTo(expection));
        profilePage=loginPage.gotoProfile();

    }

}
