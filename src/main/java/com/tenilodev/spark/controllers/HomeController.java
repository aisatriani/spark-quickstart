package com.tenilodev.spark.controllers;

import com.tenilodev.spark.models.Obat;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by azisa on 3/25/2017.
 */
public class HomeController extends Controller {

    public static HomeController getInstance() {
        return new HomeController();
    }

//    public HomeController() {
//    }

    public String index(Response response) {
        Base.open();
        LazyList<Model> all = Obat.findAll();
        all.dump();

        Base.close();
        //String json = all.toJson(true);
        response.header("Content-Type","application/json");
        return "test";
    }

    public String test(String x){
        return "wawa amazing "+ x;
    }

    public String like(){
        return "waw i like u bibeh..";
    }
}
