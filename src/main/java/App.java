import com.google.gson.Gson;
import models.dao.implementations.DepartmentImplementation;
import models.dao.implementations.DepartmentNewsImplementation;
import models.dao.implementations.GeneralNewsImplementaion;
import models.dao.implementations.UserImplementation;
import models.pojos.Department;
import models.pojos.DepartmentNews;
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

        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        String connectionString = "postgres://bnzylatosfehuz:9342a14425650a095b8371b6519eee9945f452fa3936a2a2c5796e55dce045ed@ec2-3-216-221-31.compute-1.amazonaws.com:5432/d6c8prohuumrv0";
        Sql2o sql2o = new Sql2o(connectionString, "bnzylatosfehuz", "9342a14425650a095b8371b6519eee9945f452fa3936a2a2c5796e55dce045ed\n");

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


        get("/users","application/json",(request, response) -> gson.toJson(userImplementation.getAll()));

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


        get("/department/news","application/json",(request, response) -> gson.toJson(departmentNewsImplementation.findAll()));

        post("/department/:id/news/new","application/json",(request, response) -> {

            int id = Integer.parseInt(request.params("id"));
            DepartmentNews departmentNews = gson.fromJson(request.body(),DepartmentNews.class);
            departmentNews.setDepartmentId(id);
            departmentNewsImplementation.add(departmentNews);
            response.status(200);
            return  gson.toJson(departmentNews) ;

        });

        get("/news","application/json",(request, response) -> {
            return gson.toJson(generalNewsImplementaion.findAll());
        });

        post("/news/new","application/json",(request, response) -> {

            GeneralNews generalNews = gson.fromJson(request.body(),GeneralNews.class);
            generalNewsImplementaion.add(generalNews);
            return gson.toJson(generalNews);

        });
    }

}
