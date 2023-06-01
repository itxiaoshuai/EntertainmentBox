package com.ls.entertainmentbox.app.api;


import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RequestBodyUtils {

    private static final String MEDIA_TYPE = "application/json; charset=utf-8";
//    private static final String MEDIA_TYPE = "application/form-data; charset=utf-8";

    public static class Builder{

        private JSONObject params;

        public Builder() {
            params = new JSONObject();
        }

        public Builder addParam(String key , Object value) throws JSONException {
            params.put(key,value);
            return this;
        }

        public RequestBody builder(){
            return RequestBody.create(MediaType.parse(MEDIA_TYPE),null == params ? "" : params.toString());
        }


    }

}
