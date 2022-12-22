package Product.Serv;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/start")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest reg, HttpServletResponse resp) throws SecurityException, IOException {
        PrintWriter writer =resp.getWriter();
        writer.write("html");
        writer.write("body");
        writer.write("<h1>  Я запустился! </h1>");
        writer.write("/html");
        writer.write("/body");
    }


}

