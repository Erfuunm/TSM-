package Main;

import java.util.HashMap;

public class IDandPasswoards {

    HashMap<String,String> logininfo = new HashMap<String,String>();
    IDandPasswoards(){
        logininfo.put("erfan" , "mizban");
        logininfo.put("helia" , "mazinani");

    }

    protected HashMap<String, String> getLogininfo() {
        return logininfo;
    }
}
