package com.tenilodev.spark;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.tenilodev.spark.routes.Web;
import org.javalite.activejdbc.Base;

import javax.sql.DataSource;

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

        System.out.println("run app");

    }
}

