import com.google.gson.Gson;
import com.google.gson.JsonObject;
import models.dao.implementations.DepartmentImplementation;
import models.dao.implementations.DepartmentNewsImplementation;
import models.dao.implementations.GeneralNewsImplementaion;
import models.dao.implementations.UserImplementation;
import models.pojos.Department;
import models.pojos.GeneralNews;
import models.pojos.User;
import org.json.JSONObject;
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

        get("/department","application/json",(request, response) -> gson.toJson(departmentImplementation.findAll()));

        get("/department/:id","application/json",(request, response) ->
        {
            int id = Integer.parseInt(request.params("id"));
            Department department = departmentImplementation.findById(id);
            if(department == null){
                return gson.toJson("No Department for that id");
            }

            return gson.toJson(department);

        });


        post("/department/new","application/json",(request, response) -> {

            Department department = gson.fromJson(request.body(),Department.class);
            departmentImplementation.add(department);
            response.status(201);
            return  gson.toJson(department);

        });


        get("/users","application/json",(request, response) -> {

            return gson.toJson(userImplementation.getAll());

        });

        get("/user/:id","application/json",(request, response) -> {

            int id = Integer.parseInt(request.params("id"));
            User user = userImplementation.findById(id);
            Department department = departmentImplementation.findById(user.getDepartmentid());
            if(user == null){
                return gson.toJson("No user for that id");
            }

            JSONObject item = new JSONObject();
            item.put("user",user);
            item.put("department",department);

            return gson.toJson(item);

        });

        post("/user/new/:id","application/json",(request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            User user = gson.fromJson(request.body(),User.class);
            user.setDepartmentid(id);
            userImplementation.add(user);
            response.status(201);
            return gson.toJson(user);
        });


        get("/news","application/json",(request, response) -> gson.toJson(generalNewsImplementaion.findAll()));

        post("/news/new","application/json",(request, response) -> {

            var news = gson.fromJson(request.body(), GeneralNews.class);
            generalNewsImplementaion.add(news);
            response.status(201);
            return gson.toJson(news);

        });


    }

}
