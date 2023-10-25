package ru.appline;

import ru.appline.logic.Model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static ru.appline.ServletAdd.gson;

@WebServlet(urlPatterns = "/get")
public class ServletList extends HttpServlet {
    Model model = Model.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        response.setContentType("application/json=utf=8");
        PrintWriter pw = response.getWriter();
        if (id == 0) {
            pw.print(gson.toJson(model.getFromList()));
        } else if (id > 0) {
            if (id > model.getFromList().size()) {
                //todo
            } else {
                pw.print(gson.toJson(model.getFromList().get(id)));
            }
        } else {
            //todo

        }
    }
}


