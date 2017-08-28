package com.example.android.progressbartamir.dataAccess;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.android.progressbartamir.Entities.User;

/**
 * Created by tamir on 28/08/17.
 */

public class UserPreferences {
    SharedPreferences _userPreferences;
    SharedPreferences.Editor _editor;
    static final String _USER_KEY = "user";
    private static final String _USER_DB = "userDB";
    private static final String _USER_INDEX = "userIndex";

    public UserPreferences(Context context) {
        _userPreferences = context.getSharedPreferences(_USER_DB, Context.MODE_PRIVATE);
        _editor = _userPreferences.edit();
    }

    public void saveUserInDB(User user) {
        String userStr = convertUserToString(user);
        int index = getIndexAndIncrement();
        String key = _USER_KEY + index;
        _editor.putString(key, userStr);
        _editor.commit();

    }

    public User getUser(int index) {
        String key = _USER_KEY + index;
        String userStr = _userPreferences.getString(key, null);
        if (userStr == null) return null;
        return convertStringToUser(userStr);
    }

    private String convertUserToString(User user) {
        String result = "";
        if (!user.get_name().equals(""))
            result += user.get_name() + "--";
        if (!user.get_lustName() .equals(""))
            result += user.get_lustName() + "--";
        if (!user.get_age().equals(""))
            result += user.get_age() + "--";
        if (!user.get_salary().equals(""))
            result += user.get_salary();
        return result;
    }

    private User convertStringToUser(String userStr) {
        String[] values = userStr.split("--");
        String name = values[0];
        String age = values[1];
        User user = new User();
        user.set_name(name);
        user.set_age(age);
        return user;
    }

    private void setUserIndex(int userIndex) {
        _editor.putInt(_USER_INDEX, userIndex);
        _editor.commit();
    }

    public int getIndex() {
        int index = _userPreferences.getInt(_USER_INDEX, 0);
        return index;
    }

    private int getIndexAndIncrement() {
        int index = _userPreferences.getInt(_USER_INDEX, 0);
        _editor.putInt(_USER_INDEX, index + 1);
        _editor.commit();
        return index;
    }


}
