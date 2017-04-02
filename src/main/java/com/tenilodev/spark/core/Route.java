package com.tenilodev.spark.core;


import com.tenilodev.spark.controllers.Controller;
import com.tenilodev.spark.controllers.HomeController;
import com.tenilodev.spark.utils.ReflexUtils;
import spark.Request;
import spark.Response;
import spark.Spark;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by azisa on 4/2/2017.
 */
public class Route {

    private static final String dir_controller = "com.tenilodev.spark.controllers";

    private ResourceComponent resource;

    public Route() {
    }

    public void resources(String name, Class cls){
        try {
            this.resource = (ResourceComponent) cls.newInstance();

        Spark.path(name, () -> {
            Spark.get("", (req, rest) -> resource.index());
            Spark.get("/create", (req, rest) -> resource.create());
            Spark.post("/store", (req, resp) -> resource.store(req));
            Spark.get("/*/edit", (request, response) -> resource.edit(Integer.valueOf(request.splat()[0])));
            Spark.put("/*", (request, response) -> resource.update(request,Integer.valueOf(request.splat()[0])));
            Spark.get("/*",(request, response) -> resource.show(Integer.valueOf(request.splat()[0])));
            Spark.delete("/*", (request, response) -> resource.destroy(Integer.valueOf(request.splat()[0])));
        });

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void get(String path, String ctrlMethod){
        Spark.get(path, new spark.Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return ReflexUtils.getInstance().toMethod(ctrlMethod, dir_controller, request.splat());
            }
        });
    }
}
