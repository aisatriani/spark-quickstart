package com.tenilodev.spark.controllers;

import spark.Request;

/**
 * Created by azisa on 4/2/2017.
 */
public class UserController extends Controller {

    @Override
    public String index() {
        return "user index";
    }

    @Override
    public String create() {
        return "create user view";
    }

    @Override
    public String show(int id) {
        return "show id "+ String.valueOf(id);
    }

    @Override
    public String store(Request request) {
        return super.store(request);
    }

    @Override
    public String edit(int id) {
        return "edit id "+ String.valueOf(id);
    }

    @Override
    public String update(Request request, int id) {
        return super.update(request, id);
    }

    @Override
    public String destroy(int id) {
        return super.destroy(id);
    }
}
