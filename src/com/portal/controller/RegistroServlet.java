package com.portal.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by italo on 15/05/17.
 */
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import com.portal.model.UsersEntity;
import com.portal.service.RegistroService;


public class RegistroServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        UsersEntity user = new UsersEntity();
        user.setUsuario(userId);
        user.setSenha(password);
        user.setDataCriacao(Date.from(Instant.now()));

        try {
            RegistroService registerService = new RegistroService();
            boolean result = registerService.register(user);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration Successful</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            if(result){
                out.println("<h1>Thanks for Registering with us :</h1>");
                out.println("To login with new UserId and Password<a href=login.jsp>Click here</a>");
            }else{
                out.println("<h1>Registration Failed</h1>");
                out.println("To try again<a href=register.jsp>Click here</a>");
            }
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}
