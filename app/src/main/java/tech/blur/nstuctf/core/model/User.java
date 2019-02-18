package tech.blur.nstuctf.core.model;

import android.widget.ScrollView;

public class User {

    private String id;
    private String login;
    private String name;
    private String password;
    private String trusted;

    public User(String id, String login, String password, String name, String trusted) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.trusted = trusted;
    }

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String getTrusted() {
        return trusted;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }
}
