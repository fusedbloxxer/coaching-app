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
                            new User("strong_pass", null, "Bia", "Mia", "hehe", "client"),
                            new User("$L9@$%%Mwo6c", null, "Euan", "Ismail", "PORtouLT", "client"),
                            new User("NJgUOw$Q0uQ#", "8lark9@vdemegtic.shop", "Austin", "Casey", "deCtRIbl", "client"),
                            new User("Z&seZnWzsSpV", "dtmahb@planeselect.com", "Rafael", "Kelly", "WAYlEDOP", "coach"),
                            new User("tkip_securitate", "profesor@ok.ro", "Cornel", "Vlad", "master", "coach"),
                            new User("MeYefo8YzTm^", null, "Cleo", "Evangeline", "moLuEGIT", "client"),
                            new User("PQQ#tqC%mrSw", "zprince.kashif.5g@hnyl96.com", "Abdullah", "Damien", "AckAriUm", "client"),
                            new User("EkH$H1p5$W8q", "banis@d7restoration.com", "Barnaby", "Matthew (Matt)", "LENzymPE", "coach"),
                            new User("PL3^rKhx&wJ*", "iamal.abd.790y@trestle.com", "Ioan", "Mathew (Matt)", "IlExuate", "client"),
                            new User("wuuunX^YRqQM", "wmateus@itaspanishautoinsurancemax.live", "Robin", "Jessie", "bErgLiTy", "client"),
                            new User("suiafisud9", null, "Zabuza", "Marshal", "Org@niz3r", "contabil"),
                            new User("sgfs97fgs9", "good@mail.com", "Sasuke", "Van", "M4sterful", "contabil"),
                            new User("yn73vg8793", null, "Itachi", "Mihai", "Wizz@rd", "ajutor_tehnic"),
                            new User("5yb45yu3y54b", "funnyboy@gmail.com", "Minato", "Radu", "PowerUser", "ajutor_tehnic"),
                            new User("abyay3byb", null, "Kushina", "Sasu", "CatEars", "programator"),
                            new User("baye4abyyb", "techguys@gmail.com", "Sarutobi", "Ionescu", "ToyfulGuy", "programator"),
                            new User("ab4yay4by", null, "Jiraia", "Popescu", "YouStraw", "vanzator"),
                            new User("aby4aybaye", "sales@men.com", "Sakura", "Budescu", "MouseLight", "vanzator"),
                            new User("abye4byyba4", null, "Rock", "Rotescu", "FizzyDrinks", "administrator"),
                            new User("ns5u45nus", "admin@noreply.app.ro", "Lee", "Mendel", "GlassVision", "administrator"),
                            new User("8w6mwm8", null, "Metal", "Sekeles", "Boxing44", "researcher"),
                            new User("w56nm84", "ressurecti@research.com", "Boruto", "Volcor", "CableFury", "researcher"),
                            new User("sm8sm8s8m", null, "Konohamaru", "Tondo", "TheDestroyer", "leader"),
                            new User("srumus", "leader@entrep.com", "Hyuga", "Pranta", "Speedy", "leader"),
                            new User("ysberby", null, "Neji", "Zah", "Teriola", "entrepreneur"),
                            new User("vstrvtrs", "powerful_senior@good.com", "Mirai", "Zekel", "MarsRocket", "entrepreneur"),
                            new User("neenk", null, "Ino", "Ezekiel", "FuriousPursuit", "analyst"),
                            new User("r,o8p,opr8", "bitcoin_trad3r@gmail.com", "Tsunade", "Anderson", "CarRacer", "analyst"),
                            new User("r llr", null, "Tenten", "Louie", "SavageTechGuy", "legal"),
                            new User("w4b55by4uw", "legalsing@gmail.com", "Shikamaru", "Suzy", "Linnux", "legal"),
                            new User("8nmm8s65", null, "Senju", "Michael", "Windoows", "secretary"),
                            new User("o,of,yty", "dosc_paper@gmail.com", "Sai", "Andrew", "Maacingtosh", "secretary"),
                            new User(",77086rmr", null, "Gaara", "Johan", "BitsPop", "security"),
                            new User("n4r8urgu", "bravery@security.hidden.ro", "Kiba", "Kaichi", "matise21", "security"),
                            new User("mne6uty58", null, "Deidara", "Zenwa", "addisonT", "client"),
                            new User("nrtyue56", "antrenoring@gmai.com", "Iruka", "Kaiji", "ROPlayz", "client"),
                            new User("tmydym85e", null, "Shino", "Kakashi", "Domena", "coach"),
                            new User("m5e68mtty", "coachingpower@gmail.com", "Hyuga", "Hinata", "LOU1ZGOD", "coach"),
                    };
                }
            }
        }
        return sUsers;
    }
}
