package ua.training.controller;

import ua.training.model.service.CreditService;
import ua.training.model.service.InMemoryCreditService;
import ua.training.model.entities.Target;
import ua.training.model.entities.TargetCredit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Servlet extends HttpServlet {

    private CreditService creditService = new InMemoryCreditService();
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = request.getRequestURI();
        String context = "";
        if (path.startsWith("/credits")) {
            path = path.replaceFirst("/credits", "");
            context = "/credits";
        }
        request.setAttribute("context", context);
        if (path.startsWith("/en")) {
            Locale.setDefault(new Locale("en"));
            path = path.replace("/en", "");
        } else {
            Locale.setDefault(new Locale("ua"));
        }
        ResourceBundle bundle = ResourceBundle.getBundle("labels");
        request.setAttribute("bundle", bundle);

        if (path.equals("/search") && request.getParameterMap().isEmpty()) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/search.jsp");
            requestDispatcher.forward(request, response);
        }
        else if (path.startsWith("/credits")) {
            String bank = request.getParameter("bank-name");
            String target = request.getParameter("target-name");
            boolean isIncreaseAble = false;
            if (request.getParameter("increase-able") != null) {
                isIncreaseAble = true;
            }
            boolean isClosable = false;
            if (request.getParameter("close-able") != null) {
                isClosable = true;
            }
            List<TargetCredit> credits = creditService.getCreditsByParameters(bank, Target.valueOf(target.toUpperCase()), isClosable, isIncreaseAble);
            request.setAttribute("credits", credits);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/show.jsp");
            requestDispatcher.forward(request, response);
        } else if (path.startsWith("/credit")) {
            int id = Integer.parseInt(path.replace("/credit/", ""));
            TargetCredit credit = creditService.getCreditById(id);
            request.setAttribute("credit", credit);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showone.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/search.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
