package com.tenilodev.spark.controllers;

import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by azisa on 3/25/2017.
 */
public class HomeController {

    public static HomeController getInstance() {
        return new HomeController();
    }

    public String index(Response response) {
        response.header("Content-Type","application/json");
        return "welcome";
    }
}
