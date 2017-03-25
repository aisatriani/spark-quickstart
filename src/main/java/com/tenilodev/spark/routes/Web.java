package com.tenilodev.spark.routes;


import com.tenilodev.spark.controllers.HomeController;
import com.tenilodev.spark.utils.JsonTransform;
import spark.ResponseTransformerRouteImpl;
import spark.Spark;
import spark.Spark.*;
/**
 * Created by azisa on 3/25/2017.
 */
public class Web {
    public static void init(){

        Spark.get("/",(request, response) -> HomeController.getInstance().index(response), new JsonTransform());

    }

}
