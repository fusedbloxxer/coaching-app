package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        tableName = "probleme",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "nume_utilizator",
                        childColumns = "id_coach",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                ),
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "nume_utilizator",
                        childColumns = "id_client",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                )
        },
        indices = {
                @Index(value = "id_coach"),
                @Index(value = "id_client")
        }
)
public class Problem {

    private static final String DEFAULT_STATE = "noua";

    @NonNull
    @ColumnInfo(name = "stare", defaultValue = DEFAULT_STATE)
    private String state;

    @NonNull
    @ColumnInfo(name = "description")
    private String description;

    @NonNull
    @ColumnInfo(name = "titlu")
    private String title;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id_problema")
    private Long problemId;

    @NonNull
    @ColumnInfo(name = "id_coach")
    private String coachId;

    @NonNull
    @ColumnInfo(name = "id_client")
    private String clientId;

    public Problem(@NonNull String state, @NonNull String description, @NonNull String title, @NonNull Long problemId, @NonNull String coachId, @NonNull String clientId) {
        this.state = state;
        this.description = description;
        this.title = title;
        this.problemId = problemId;
        this.coachId = coachId;
        this.clientId = clientId;
    }

    @Ignore
    public Problem(@NonNull String state, @NonNull String description, @NonNull String title, @NonNull String coachId, @NonNull String clientId) {
        this.state = state;
        this.description = description;
        this.title = title;
        this.coachId = coachId;
        this.clientId = clientId;
    }

    @Ignore
    public Problem(@NonNull String description, @NonNull String title, @NonNull Long problemId, @NonNull String coachId, @NonNull String clientId) {
        this.description = description;
        this.title = title;
        this.problemId = problemId;
        this.coachId = coachId;
        this.clientId = clientId;
        this.state = DEFAULT_STATE;
    }

    @Ignore
    public Problem(@NonNull String description, @NonNull String title, @NonNull String coachId, @NonNull String clientId) {
        this.description = description;
        this.title = title;
        this.coachId = coachId;
        this.clientId = clientId;
        this.state = DEFAULT_STATE;
    }

    @NonNull
    public String getState() {
        return state;
    }

    public void setState(@NonNull String state) {
        this.state = state;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(@NonNull Long problemId) {
        this.problemId = problemId;
    }

    @NonNull
    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(@NonNull String coachId) {
        this.coachId = coachId;
    }

    @NonNull
    public String getClientId() {
        return clientId;
    }

    public void setClientId(@NonNull String clientId) {
        this.clientId = clientId;
    }

    @NonNull
    @Override
    public String toString() {
        return "Problem{" +
                "state='" + state + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", problemId=" + problemId +
                ", coachId='" + coachId + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }

    private static Problem[] sProblems;

    @NonNull
    public static Problem[] getFakeProblems() {
        if (sProblems == null) {
            synchronized (Problem.class) {
                if (sProblems == null) {

                    sProblems = new Problem[]{
                            new Problem("Stau foarte mult jos, m-am ingrasat tare !", "Nu-mi place miscarea", "LENzymPE", "AckAriUm"),
                            new Problem("Vine sesiunea si nu am invatat nimic, ce sa fac ?", "Facultatea e obositoare", "LENzymPE", "deCtRIbl"),
                            new Problem("Imi e frica sa vorbesc cu oamenii la telefon. Ma intimideaza!", "Frica de telefon", "master", "IlExuate"),
                            new Problem("Am foarte multe teme la facultate si nu stiu ce sa mai fac", "Facultatea ma omoara", "master", "deCtRIbl"),
                            new Problem("De fiecare data cand ma supara cineva bag in mine ca spartul :(", "Mananc foarte mult", "master", "deCtRIbl"),
                            new Problem("Dorm foarte mult, in fiecare zi cel putin 12 ore. Nu mai am timp de altceva... ajutor!", "Sunt cam lenes", "master", "deCtRIbl"),
                            new Problem("reviewing", "Nu stiu cum sa incep o conversatie, tot timpul ma pierd. Imi este frica sa fac primul pas.", "Frica de a interactiona", "master", "PORtouLT"),
                            new Problem("planning", "De cele mai multe ori am emotii in a-mi exprima opinia in fata mai multor oameni. Chiar am nevoie de ajutor !", "Frica de a vorbi in public", "master", "PORtouLT"),
                            new Problem("in curs de rezolvare", "Tocmai a batut cineva la usa, au venit sa ma ia !! Ce sa fac, ajuutor.", "Sunt amenintat !", "WAYlEDOP", "PORtouLT"),
                            new Problem("decurge", "De cand eram mic, ei tot au avut multe conflicte, dar acum la varsta de 13 ani, ma afecteaza. Urla unul la celalalt in fiecare zi. Ajutor :(", "Parintii mei se cearta", "WAYlEDOP", "PORtouLT"),
                            new Problem("o problema noua", "Ei ma iau in ras. Totul este o gluma, nu mai suport...", "Prietenii nu ma respecta", "master", "deCtRIbl"),
                            new Problem("in curand e gata", "Colegii de la scoala ma bat in pauza pentru ca mananc laptele si cornul din lada.", "Toti sunt rautaciosi", "master", "deCtRIbl"),
                            new Problem("mai avem putin", "Nu ni s-au oferit carti ca sa avem de unde invata. Noi ce facem acum ?", "Protest !", "LENzymPE", "deCtRIbl"),
                            new Problem("merge super", "Am avut o perioada foarte incarcata si nu am avut timp sa vorbesc zilele astea cu ea. Crede ca o insel cu cineva. Ce e de facut ?", "Prietena m-a parasit", "WAYlEDOP", "moLuEGIT"),
                            new Problem("mai e de lucru", "M-am deprimat foarte tare din cauza unui profesor care nu a vrut sa-mi ia in considerare solutia la un test.", "Am luat o nota proasta", "master", "moLuEGIT"),
                            new Problem("veche de tot", "Am uitat, caci am avut multe pe cap. Acum imi vin amenzile pe banda si nu am de unde sa platesc. Cum procedez ?", "Nu mi-am platit taxele !", "master", "AckAriUm"),
                            new Problem("merge bine", "Am momente scurte in care ma balbai si dupa imi scap toata ideea in timpul unei conversatii... Acest lucru este recent, oare de ce se intampla?", "Ma blochez cand vorbesc", "WAYlEDOP", "AckAriUm"),
                            new Problem("merge groaznic", "Cand scriu la tabla imi tremura mainile. Ba chiar si acasa cand stau linistit mi se intampla. O fi oare pentru ca am stat prea mult la calculator?", "Tremurici la maini", "WAYlEDOP", "AckAriUm"),
                            new Problem("merge greu", "Cand ma gandesc ca trebuie sa-mi infrunt parintii sa scap din situatia curent mi se face groaza...", "Frica de a infrunta probleme", "WAYlEDOP", "AckAriUm"),
                            new Problem("merge lent", "M-am suparat pe ei, mi-au luat jucariile...", "Nu mai vorbesc cu nimeni", "master", "AckAriUm"),
                            new Problem("rezolvat", "Ma asteptam ca facultatea sa-mi ofere mai multe optiuni, dar aparent invat doar lucruri invechite.", "Sunt jicnit", "master", "IlExuate"),
                            new Problem("terminat", "Tot timpul stau si ma intreb, eu de ce sunt pe acest pamant? Oricum merg inapoi in el. Sa o fac mai repede ? Nu mai pot domi noaptea...", "Ce inseamna viata ?", "master", "IlExuate"),
                            new Problem("gata", "Cand eram mic am fost muscat de o meduza si acum nu mai pot intra in apa, caci s-ar putea sa ma prinda din nou...", "Mi-e frica sa inot", "master", "IlExuate"),
                            new Problem("Facultatea imi da prea multe de facut, nu mai am timp de facut.", "Prea mult de lucru", "master", "bErgLiTy"),
                            new Problem("Erau rautaciosi !!!", "Mi-am parasit familia", "master", "ROPlayz"),
                            new Problem("Am vazut ca unii doctori nu folosesc manusi ! VAI ... M-am ingrozit..", "Mi-e frica de doctor", "master", "PORtouLT"),
                            new Problem("Astazi domnul profesor nu m-a salutat pe hol. M-am simtit ca un vierme.", "Ma doare sufletu !", "master", "PORtouLT"),
                            new Problem("Abia imi ajung banii de o paine, maica.. de unde bani ?", "Ce grea e viata", "WAYlEDOP", "PORtouLT"),
                            new Problem("Shalele mele ma dor fff.. tare. Ce e de facut domne'?", "Batranetea ma doboara", "WAYlEDOP", "PORtouLT"),
                            new Problem("Vreau sa invat lucruri noi, dar nu am rabdare sa citesc carti... IA PREA MULT !!", "Carti", "master", "deCtRIbl"),
                            new Problem("Toti banii mei merg acolo, nu castig nimic, imi vine sa ma sinucid.", "Jocuri de noroc", "master", "deCtRIbl"),
                            new Problem("Cum fac sa ma opresc ?", "Pacanele", "master", "deCtRIbl"),
                            new Problem("Inca din scoala generala am bagat la aparate, dar acum a ajuns situatia sa fie grava.", "Aparate", "WAYlEDOP", "moLuEGIT"),
                            new Problem("Toata lumea pleaca de langa mine, cei apropiati ma dau afara, nu mai am niciun prieten, doar sticla.", "Alcool", "master", "moLuEGIT"),
                            new Problem("Prietenii mei nu ma lasa in pace ! Ma indeamna sa fumez, ca s-ar asemana cu mancatul a cativa pufuleti. Nu stiu ce inseamna asta, dar nu vreau sa incerc, m-a avertizat mama.", "Fumat", "master", "AckAriUm"),
                            new Problem("Unii oameni nu se tin de cuvant. Am 'colaborat' cu mai multi elevi sa facem proiecte, dar toti s-au retras brusca fara sa zica nimic. Ce e cu mine ? Imi vine sa plang.", "Lumea e inselatoare", "WAYlEDOP", "AckAriUm"),
                            new Problem("Bag ca spartu 2 saorme pe zi, de m-am ingrasat. Banu se duce si grasimea apare. HELP MAN !", "Mancare nesanatoasa", "WAYlEDOP", "AckAriUm"),
                            new Problem("Sunt un gunoi, nu pot face nimic. Toti angajatorii ma dau afara de la interview, zic ca sunt ciudat..", "Nu ma respect", "WAYlEDOP", "AckAriUm"),
                            new Problem("Nu am vrut sa stau peste program deoarece nu mi se pare normal si ghici ce ? Am fost dat afara...", "Am fost dat afara", "master", "AckAriUm"),
                            new Problem("Nu inteleg, si nu am bani de meditatii.. nu pot intra la facultate, ce sa fac ?", "Fizica e grea", "master", "IlExuate"),
                            new Problem("Daca nu o servesc in secunda 2 dupa ce imi ordona e jale pentru mine :'(", "Bunica ma bate", "master", "IlExuate"),
                            new Problem("Cand iau note mici ma bat cu cureaua.. OUCH", "Parintii sunt rai", "master", "IlExuate"),
                            new Problem("Vreau sa ajung un om de success, sa nu fiu angajat/servitorul companiilor. Vreau sa imi deschid propria firma >:)", "Cum ajung in varf?", "master", "bErgLiTy"),
                            new Problem("Ma joc foarte mult si am inceput sa observ ca sunt chiar priceput. Cum fac sa ajung mai sus ?", "The best ?", "master", "ROPlayz")
                    };
                }
            }
        }
        return sProblems;
    }
}
