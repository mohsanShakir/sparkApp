package com.sparkapp

import com.sparkapp.domain.Project
import static spark.Spark.*;

/**
 * Created by mohsan.shakir on 05-05-2014.
 */
class MyApp {

    private static List<Project> projects = new ArrayList<Project>()

    public static void main(String[] args) {
        makeData

        staticFileLocation("/public")


        get("/projects/:id", {request, response ->
            Project project = projects.find{ it.id == Long.parseLong(request.params(":id")) }
            project ? project : notfound(response)
        },new JsonTransformer())

        get("/projects", {request, response ->
            return projects
        },new JsonTransformer())


        delete("/projects/:id", {request, response ->
            Project project = projects.find { it.id == Long.parseLong(request.params(":id")) }
            projects.remove(project)
            project ? projects : notfound(response)
        },new JsonTransformer())
        post("/projects",  {request, response ->
            String name = request.queryParams("name");
            String descirption = request.queryParams("descirption");
            int id = projects.size()
            boolean isActive= request.queryParams("isActive");
            Project project = new Project(name: name,description:descirption,id: id, isActive:isActive )
            projects.add(project)

            response.status(201); // 201 Created
            return "Project Added"
        },new JsonTransformer())

        put("/projects/:id", {request, response ->
            Project project = projects.find { it.id  == Long.parseLong(request.params(":id")) }
            if (project) {
                String name = request.queryParams("name");
                String descirption = request.queryParams("descirption");
                if (name) {
                    project.name = name;
                }
                if (descirption) {
                    project.description= descirption
                }
                return "Book updated";
            } else {
                notfound(response)
            }
        },new JsonTransformer())

    }

    static def getMakeData() {
        Project p1 = new Project(id: 1, name: "Project1", description: "just a project", isActive: true)
        Project p2 = new Project(id: 2, name: "Project2", description: "just a project", isActive: true)
        Project p3 = new Project(id: 3, name: "Project3", description: "just a project", isActive: false)
        projects.addAll([p1,p2,p3])
    }

    private static String notfound(response){
        response.status(404)
        return "Resource not found"
    }


}
