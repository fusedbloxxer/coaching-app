package com.faculty.fusedbloxxer.coachingapp.model.db.views;

import androidx.room.DatabaseView;
import androidx.room.Embedded;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Role;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.User;

@DatabaseView("SELECT roluri.id_rol AS roleId, url_imagine AS role_urlImage, nume_utilizator AS username, \n" +
        "\tadresa_email AS emailAddress, nume AS lastName, prenume AS firstName, parola AS password " +
        "FROM roluri " +
        "JOIN utilizatori ON(roluri.id_rol = utilizatori.id_rol);")
public class UserWithRole {
    private Role role;

    @Embedded
    private User user;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
