package com.tenilodev.spark;

import com.tenilodev.spark.routes.Web;

import static spark.Spark.*;

/**
 * Created by azisa on 3/25/2017.
 */
public class Server {

    public static void main(String[] args) {
        new Server();
    }

    private Server() {
        Web.init();
    }
}

