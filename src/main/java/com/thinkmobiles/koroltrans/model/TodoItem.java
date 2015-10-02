package com.thinkmobiles.koroltrans.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("TodoItem")
public class TodoItem extends ParseObject {
    // Ensure that your subclass has a public default constructor
    public TodoItem() {
        super();
    }

    // Add a constructor that contains core properties
    public TodoItem(String body) {
        super();
        setBody(body);
    }

    // Use getString and others to access fields
    public String getBody() {
        return getString("body");
    }

    // Use put to modify field values
    public void setBody(String value) {
        put("body", value);
    }


}