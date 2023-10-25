package ru.appline;

import com.google.gson.JsonObject;
import ru.appline.logic.Model;
import ru.appline.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static ru.appline.ServletAdd.gson;

@WebServlet(urlPatterns = "/update")
class ServletUpdate extends HttpServlet {
    Model model = Model.getInstance();

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer jb = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

        JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);

        request.setCharacterEncoding("UTF-8");

        int userId = jobj.get("id").getAsInt();
        String name = jobj.get("name").getAsString();
        String surname = jobj.get("surname").getAsString();
        double salary = jobj.get("salary").getAsDouble();

        User userToUpdate = new User(name, surname, salary);
        model.update(userId, userToUpdate);

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(model.getFromList()));
    }
}