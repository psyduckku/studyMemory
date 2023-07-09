package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="requestBodySpringServlet", urlPatterns ="/request-body-string")
public class ReqeustBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); //클라이언트의 message body의 내용을 inputStream을통해 bite코드로 꺼냄.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // 스프링 내장. : bite-> string으로 바꿔줌
        // bite를 문자로 변환할때는 어떤 인코딩인지 알려줘야함. 반대로 문자를 바이트로 변환할때도 인코딩을 어떤 인코딩인지 알려줘야함. 대부분 utf8사용
        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok"); //클라이언트가 요청후 서버가 제대로 받았다면 클라이언트에게 ok를 응답해줌

    }
}
