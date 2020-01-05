package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        tableName = "utilizatori",
        foreignKeys = {
                @ForeignKey(
                        entity = Role.class,
                        parentColumns = "id_rol",
                        childColumns = "id_rol",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                )
        },
        indices = {
                @Index(value = {"id_rol"})
        }
)
public class User {
    @NonNull
    @ColumnInfo(name = "parola")
    private String password; // TODO: CHECK (sa aibă lungimea mai mare de 6 caractere)

    @ColumnInfo(name = "adresa_email")
    private String emailAddress;

    @NonNull
    @ColumnInfo(name = "prenume")
    private String firstName;

    @NonNull
    @ColumnInfo(name = "nume")
    private String lastName;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "nume_utilizator")
    private String username; // TODO: CHECK(să nu conțină spații)

    @NonNull
    @ColumnInfo(name = "id_rol")
    private String roleId;

    public User(@NonNull String password, String emailAddress, @NonNull String firstName, @NonNull String lastName, @NonNull String username, @NonNull String roleId) {
        this.password = password;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.roleId = roleId;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(@NonNull String roleId) {
        this.roleId = roleId;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }

    private static User[] sUsers;

    @NonNull
    public static User[] getFakeUsers() {
        if (sUsers == null) {
            synchronized (User.class) {
                if (sUsers == null) {
                    sUsers = new User[]{
                            new User("strong_pass", null, "Andrei", "Ionescu", "fusedbloxxer", "client"),
                            new User("$L9@$%%Mwo6c", null, "Euan", "Ismail", "PORtouLT", "client"),
                            new User("NJgUOw$Q0uQ#", "8lark9@vdemegtic.shop", "Austin", "Casey", "deCtRIbl", "client"),
                            new User("Z&seZnWzsSpV", "dtmahb@planeselect.com", "Rafael", "Kelly", "WAYlEDOP", "coach"),
                            new User("tkip_securitate", "profesor@my.fmi.unibuc.ro", "Cornel", "Vlad", "master", "coach"),
                            new User("MeYefo8YzTm^", null, "Cleo", "Evangeline", "moLuEGIT", "client"),
                            new User("PQQ#tqC%mrSw", "zprince.kashif.5g@hnyl96.com", "Abdullah", "Damien", "AckAriUm", "client"),
                            new User("EkH$H1p5$W8q", "banis@d7restoration.com", "Barnaby", "Matthew (Matt)", "LENzymPE", "coach"),
                            new User("PL3^rKhx&wJ*", "iamal.abd.790y@trestle.com", "Ioan", "Mathew (Matt)", "IlExuate", "client"),
                            new User("wuuunX^YRqQM", "wmateus@itaspanishautoinsurancemax.live", "Robin", "Jessie", "bErgLiTy", "client")
                    };
                }
            }
        }
        return sUsers;
    }
}
