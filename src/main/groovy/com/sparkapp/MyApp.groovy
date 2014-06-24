package com.sparkapp

import static spark.Spark.*;
import spark.*;

/**
 * Created by mohsan.shakir on 05-05-2014.
 */
class MyApp {

    public static void main(String[] args) {

        staticFileLocation("/public")

        get(new Route("/hello") {
            @Override
            Object handle(Request request, Response response) {
                return "Hello world"
            }
        })
    }
}
