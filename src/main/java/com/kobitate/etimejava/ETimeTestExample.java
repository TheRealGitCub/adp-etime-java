package com.kobitate.etimejava;

/**
 * Created by TheRealGitCub on 7/11/17.
 */

import java.io.IOException;

public class ETimeTestExample {
    public static void main(String[] args) {
        try {
            ETime etime = new ETime("user@example", "password");
            System.out.println(etime.getTimecard());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ETimePasswordException e) {
            e.printStackTrace();
        }
    }
}