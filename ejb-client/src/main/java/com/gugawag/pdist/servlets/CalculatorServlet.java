package com.gugawag.pdist.servlets;

import calculadoraejb.CalculadoraIF;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/calculator.do"})
public class CalculatorServlet extends HttpServlet {

    @EJB(lookup = "java:global/calculadoraejb-1.0-SNAPSHOT/Calculadora")
    private CalculadoraIF calculator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Calculadora</h1>");
        out.println("<form>");
        out.println("<input type='text' name='a'/>");
        out.println("<input type='text' name='b'/>");
        out.println("<input type='submit' name='somar' value='somar'/>");
        out.println("</form>");

        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String op = req.getParameter("somar");
        if (op != null) {
            out.println("<h2>Resultado: " + calculator.somar(Integer.parseInt(a), Integer.parseInt(b)) + "</h2>");
        }

        out.println("</body></html>");
    }
}