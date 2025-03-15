import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.example.DAO.Client;
import org.example.DAO.Company;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.Matchers.*;

@SpringBootTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class SpringTest {

    @Test
    public void baseTest(){
        System.out.println("the test has been launched");
        Gson gson = new Gson();
        RestAssured.baseURI = "http://localhost:8080";
        String client = given()
                .when()
                .get("/company/2")
                .then()
                .statusCode(200)
                        .and().extract().asPrettyString();
        System.out.println(client);
        assertThatThrownBy(() -> client.lines().forEach(System.out::println));
    }

}
