package com.uca.gamenews.Tablas;

import java.util.List;

public class User {

    public String _id;
    public String user;
    public String password;
    public List<New>  favoriteNews;


    public User() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<New> getFavoriteNews() {
        return favoriteNews;
    }

    public void setFavoriteNews(List<New> favoriteNews) {
        this.favoriteNews = favoriteNews;
    }
}
