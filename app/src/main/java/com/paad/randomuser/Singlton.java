package com.paad.randomuser;


import com.paad.randomuser.API.Result;

import java.util.ArrayList;
import java.util.List;

public class Singlton {

    public List<Result> characterList;

    private static Singlton instance = new Singlton();

    private Singlton(){
        characterList = new ArrayList<>();
    }

    public static Singlton getInstance(){
        return instance;
    }

}