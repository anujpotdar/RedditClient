package com.anuj.potdar.redditclient;

import com.anuj.potdar.redditclient.model.Child;

import java.util.ArrayList;

/**
 * Created by potda on 6/23/2018.
 */

public interface MainNavigation {

    void navigateToLogin();

    void navigateToHomePage(ArrayList<Child> children);

}
