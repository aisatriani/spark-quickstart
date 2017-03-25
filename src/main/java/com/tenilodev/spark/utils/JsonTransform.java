package com.tenilodev.spark.utils;

import com.google.gson.Gson;
import spark.*;

/**
 * Created by azisa on 3/25/2017.
 */
public class JsonTransform implements ResponseTransformer{

    @Override
    public String render(Object model) throws Exception {
        Gson gson = new Gson();
        return gson.toJson(model);
    }
}
