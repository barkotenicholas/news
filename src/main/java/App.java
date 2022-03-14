import com.google.gson.Gson;
import models.dao.implementations.DepartmentImplementation;
import models.dao.implementations.DepartmentNewsImplementation;
import models.dao.implementations.GeneralNewsImplementaion;
import models.dao.implementations.UserImplementation;
import models.pojos.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {

        String connectionString = "jdbc:postgresql://localhost:5432/newsportaltest";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "access");

        Connection conn;
        Gson gson = new Gson();
        UserImplementation userImplementation = new UserImplementation(sql2o);
        GeneralNewsImplementaion generalNewsImplementaion = new GeneralNewsImplementaion(sql2o);
        DepartmentImplementation departmentImplementation = new DepartmentImplementation(sql2o);
        DepartmentNewsImplementation departmentNewsImplementation = new DepartmentNewsImplementation(sql2o);

        conn = sql2o.open();

        get("/", "application/json", (request, response) -> {

            Map<String, Object> models = new HashMap<>();
            models.put("Add user", "/users/new");
            models.put("View all users", "/users");
            return gson.toJson(models);
        });

        get("/users","application/json",(request, response) -> {

            return gson.toJson(userImplementation.getAll());

        });

        get("/user/:id","application/json",(request, response) -> {

            int id = Integer.parseInt(request.params("id"));
            User user = userImplementation.findById(id);

            if(user == null){
                return gson.toJson("No user for that id");
            }

            return gson.toJson(user);

        });

        post("/user/new","application/json",(request, response) -> {
            User user = gson.fromJson(request.body(),User.class);
            userImplementation.add(user);
            response.status(201);
            return gson.toJson(user);
        });
    }

}
