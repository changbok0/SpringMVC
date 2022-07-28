package hello.servlet.web.frontcontroller.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.web.frontcontroller.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet",urlPatterns = "/response-Json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(20);

        //{"username":"kim", "age":20} writeValueAsString: 이 객체로 값을 써서 문자로 바꿔라
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);
    }
}
