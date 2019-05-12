package com.example.blog.commons;

import java.util.Date;

public class PrefixID {

    public static String getPre() {
        int random =(int) ((Math.random()+1)*100000);
        String dataStr=new Date().toString().replace(" ","").replace(":","");
        return random+dataStr;
    }
}
