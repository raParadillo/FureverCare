package com.javaprojectoop.demo;

import com.javaprojectoop.demo.Data.UserProfile;

public class Users {

    // Static user profile so it can be accessed anywhere
    public static final UserProfile currentUserProfile = new UserProfile(
            "Alice", "Smith", "alicesmith123@gmail.com", "09171234567", "25", "Carmen Cagayan de Oro"
    );

}
