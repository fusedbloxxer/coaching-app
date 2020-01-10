package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "roluri")
public class Role {

    @NonNull
    @ColumnInfo(name = "url_imagine")
    private String urlImage;

    @NonNull
    @ColumnInfo(name = "descriere")
    private String description;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id_rol")
    private String idRole;

    public Role(@NonNull String urlImage, @NonNull String description, @NonNull String idRole) {
        this.urlImage = urlImage;
        this.description = description;
        this.idRole = idRole;
    }

    @NonNull
    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(@NonNull String urlImage) {
        this.urlImage = urlImage;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(@NonNull String idRole) {
        this.idRole = idRole;
    }

    @NonNull
    @Override
    public String toString() {
        return "Role{" +
                "urlImage='" + urlImage + '\'' +
                ", description='" + description + '\'' +
                ", idRole='" + idRole + '\'' +
                '}';
    }

    private static Role[] sRoles;

    @NonNull
    public static Role[] getFakeRoles() {
        if (sRoles == null) {
            synchronized (Role.class) {
                if (sRoles == null) {
                    sRoles = new Role[]{
                            new Role("https://media.istockphoto.com/vectors/retention-icon-vector-id961056084?k=6&m=961056084&s=170667a&w=0&h=bs1xfnZO3qBiRdRDacXUQ-KVVXgIIjE4RZJFrkUwz5g=", "Persoana care isi doreste sa se dezvolte personal si sa ajunga departe in viata.", "client"),
                            new Role("https://imageog.flaticon.com/icons/png/512/939/939286.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF", "Persoana care a acumulat experienta in viata si stie cum sa abordeze o gama larga de probleme. Este dispus sa ii ajute pe ceilalti si sa ii ghideze catre o viata mult mai buna.", "coach"),
                            new Role("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCefJdPS7xbEFEN0CgkhgBrdcN39bnu4gktnfBGRcjkOj6dYf1&s", "Persoana care se ocupa cu tranzactiile financiare care au loc intre client si coach.", "contabil"),
                            new Role("https://image.flaticon.com/icons/png/512/69/69114.png", "Persoana care ii ghideaza pe utilizatorii aplicatiei atunci cand intampina dificultati tehnice.", "ajutor_tehnic"),
                            new Role("https://image.flaticon.com/icons/png/512/1465/1465611.png", "Persoana care se ocupa cu dezvoltarea aplicatiei: adaugare de optiuni noi, repararea erorilor care apar, extinderea si intretinerea aplicatiei.", "programator"),
                            new Role("https://image.flaticon.com/icons/png/512/857/premium/857138.png", "Persoana care vine cu noi strategii de promovare a serviciilor curente, precum si a celor noi. Acest rol este unul esential deoarece influenteaza in mod direct numarul de potentiali utilizatori pe care ii poate avea aplicatia, dupa ce aceasta este lansata.", "vanzator"),
                            new Role("https://cdn2.iconfinder.com/data/icons/financial-tools/512/worker-512.png", "Persona autorizata capabila să modifice direct baza de date a aplicatiei.", "administrator"),
                            new Role("https://mpng.pngfly.com/20191203/irf/transparent-careers-men-icon-researcher-icon-scientist-icon-5de63d82881e30.1303157615753701145575.jpg", "Persoană care se ocupa cu o gama larga de studii pentru a furniza servicii de o calitate cat mai ridicata.", "researcher"),
                            new Role("https://cdn.iconscout.com/icon/premium/png-256-thumb/leader-1475143-1248003.png", "Persoana care are rolul de a coordona activitatea tuturor angajatilor de la cel mai inalt nivel. Acestă persoană este cea care indică directia în care se îndreaptă aplicația.", "leader"),
                            new Role("https://image.flaticon.com/icons/png/512/875/875348.png", "Persoana care deține firma curentă. Este mai presus de liderul aplicației, acesta comanda intreaga sa companie.", "entrepreneur"),
                            new Role("https://cdn3.iconfinder.com/data/icons/bitcoin-cryptocurrency/512/Icon_47-512.png", "Persoană care supraveghează traficul de oameni care accesează aplicația și foloseste instrumente avansate pentru a afisa progresul aplicației.", "analyst"),
                            new Role("https://cdn.iconscout.com/icon/premium/png-256-thumb/legal-1609915-1363760.png", "Persoană care se ocupă cu rezolvarea conflictelor legale, stabilirea termenilor și a conditiilor, etc.", "legal"),
                            new Role("https://cdn.iconscout.com/icon/premium/png-256-thumb/secretary-338510.png", "Persoană care se ocupă cu organizarea documentelor în cadrul companiei.", "secretary"),
                            new Role("https://image.flaticon.com/icons/png/512/30/30394.png", "Persoană care asigură faptul că aplicația este securizată si ca nu au loc scurgeri de informații. Previne atacurile externe.", "security"),
                            new Role("https://cdn4.iconfinder.com/data/icons/professions-1-2/151/29-512.png", "Persoană care organizează echipe micuțe pentru a atinge obiectivele propuse în cadrul companiei.", "manager")
                    };
                }
            }
        }
        return sRoles;
    }
}
