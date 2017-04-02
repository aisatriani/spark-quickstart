package com.tenilodev.spark.core;

import spark.*;

/**
 * Created by azisa on 4/2/2017.
 */
public interface ResourceComponent {
    String index();
    String create();
    String show(int id);
    String store(Request request);
    String edit(int id);
    String update(Request request, int id);
    String destroy(int id);
}
