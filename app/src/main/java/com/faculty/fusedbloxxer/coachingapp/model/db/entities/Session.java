package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;
import static androidx.room.ForeignKey.SET_NULL;
import static com.faculty.fusedbloxxer.coachingapp.utilities.Utils.timestamp;

@Entity(
        tableName = "sedinte",
        foreignKeys = {
                @ForeignKey(
                        entity = Problem.class,
                        parentColumns = "id_problema",
                        childColumns = "id_problema",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                ),
                @ForeignKey(
                        entity = Location.class,
                        parentColumns = "id_locatie",
                        childColumns = "id_locatie",
                        onUpdate = CASCADE,
                        onDelete = SET_NULL
                )
        },
        indices = {
                @Index(value = "id_problema"),
                @Index(value = "id_locatie")
        }
)
public class Session {
    @NonNull
    @ColumnInfo(name = "discutie")
    private String discussion;

    @NonNull
    @ColumnInfo(name = "data_de_incepere")
    private Date startDate;

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_sedinta")
    private Long sessionId;

    @NonNull
    @ColumnInfo(name = "id_problema")
    private Long problemId;

    @ColumnInfo(name = "id_locatie")
    private Long locationId;

    public Session(@NonNull String discussion, @NonNull Date startDate, @NonNull Long sessionId, @NonNull Long problemId, Long locationId) {
        this.discussion = discussion;
        this.startDate = startDate;
        this.sessionId = sessionId;
        this.problemId = problemId;
        this.locationId = locationId;
    }

    @Ignore
    public Session(@NonNull String discussion, @NonNull Date startDate, @NonNull Long problemId, Long locationId) {
        this.discussion = discussion;
        this.startDate = startDate;
        this.problemId = problemId;
        this.locationId = locationId;
    }

    @NonNull
    public String getDiscussion() {
        return discussion;
    }

    public void setDiscussion(@NonNull String discussion) {
        this.discussion = discussion;
    }

    @NonNull
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(@NonNull Date startDate) {
        this.startDate = startDate;
    }

    @NonNull
    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(@NonNull Long sessionId) {
        this.sessionId = sessionId;
    }

    @NonNull
    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(@NonNull Long problemId) {
        this.problemId = problemId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @NotNull
    @Override
    public String toString() {
        return "Session{" +
                "discussion='" + discussion + '\'' +
                ", startDate=" + startDate +
                ", sessionId=" + sessionId +
                ", problemId=" + problemId +
                ", locationId=" + locationId +
                '}';
    }

    private static Session[] sSessions;

    @NonNull
    public static Session[] getFakeSessions() {
        if (sSessions == null) {
            synchronized (Session.class) {
                if (sSessions == null) {
                    sSessions = new Session[]{
                            new Session("In aceasta sesiune iti vom ridica moralul !", timestamp(), 1L, 1L),
                            new Session("Totul este ok :) ", timestamp(), 2L, 5L),
                            new Session("Nu ai de ce sa te ingrizorezi :)", timestamp(), 1L, 2L),
                            new Session("In aceasta sesiune iti vom ridica moralul !", timestamp(), 1L, 2L),
                            new Session("Totul se va rezolva imediat", timestamp(), 4L, 4L),
                            new Session("De ce crezi ca ai aceste temeri?", timestamp(), 4L, 4L),
                            new Session("Voi fi sprijinul tau", timestamp(), 3L, 4L),
                            new Session("Incepem cu cateva exercitii fizice.", timestamp(), 3L, 3L),
                            new Session("O sa iesim cu bine din situatia asta.", timestamp(), 3L, 3L),
                            new Session("Haide sa mergi pe afara sa faci niste jogging in aer liber. O sa-ti placa. Nu e bine sa stai jos, iti stagneaza sangele si de picioare ai nevoie toata viata.", timestamp(), 1L, 1L),
                            new Session("Gandeste-te ca atunci cand stai jos esti ca o piatra... existi si nu poti face nimic. Sunt oamenii care isi doresc sa se poata misca.", timestamp(), 1L, 1L),
                            new Session("Daca esti gras si nu incetezi sa mai mananc prostii o sa faci diabet.", timestamp(), 1L, 1L),
                            new Session("Mananca mai putin, iesi pe afara mai des, si oricand ai ocazia ridica-te de pe scaun. Mergi pana pe hol, da o tura de bloc, orice.", timestamp(), 1L, 1L),
                            new Session("In primul rand nu te stresa. Toti studentii trec prin asta. Hai sa facem un plan, o sa reusesti sa inveti tot ca sa treci.", timestamp(), 2L, 2L),
                            new Session("Incearca sa te culci devreme si sa te trezesti devreme, o sa dai randament mult mai mare.", timestamp(), 2L, 2L),
                            new Session("In fiecare zi respecta planul pe care l-am discutat si ia-le pe rand, treptat. De la mic la mare, de la stanga la dreapta.", timestamp(), 2L, 3L),
                            new Session("Acest lucru se trateaza cu exercitiu. Gandeste-te ca este necesar sa obtii informatii, cand o sa fi intr-o situatie limita trebuie sa fi cat mai flexibil.", timestamp(), 3L, 4L),
                            new Session("Fa exercitiile care iti aduc punctajul minim de trecere. Ia-le ordonat pe deadline si opreste toate distragerile gen facebook.", timestamp(), 4L, 5L),
                            new Session("Sa incepem prin a-ti pune alarma sa sune de dimineata. Dormi doar 10 ore, dupa o saptamana 9 ore si apoi 8. Easy peasy.", timestamp(), 6L, 6L),
                            new Session("Inseamna ca nu te-ai obijnuit sa comunici din diverse motive. Uite, fa asa: saluta-ti maine toti colegii, da noroc cu ei si priveste-i in ochi. O sa ajungi sa fi cel mai respectat iti zic eu !", timestamp(), 7L, 7L),
                            new Session("Bun, lucrurile au decurs fain. Imi place cum ai progresat, acum iti recomand sa fi tu cel care propune idei si sa dezbati asupra lor.", timestamp(), 7L, 8L),
                            new Session("Totul se rezolva cu exercitiu, pas cu pas, de la mic la mare, de la stanga la dreapta. Iti recomand sa te inscri la mai multe proiecte si sa iti prezinti ideile. Vei ajunge departe daca o ti asa.", timestamp(), 8L, 9L),
                            new Session("CALM ! Esti sigur ? Daca sunt oameni rai, cheama politia repede sau sari pe geam.", timestamp(), 9L, 10L),
                            new Session("Gandeste-te ca multi sunt ca tine si au ajuns sa fie bine. Haide sa vedem ce putem face. Povesteste-mi mai multe.", timestamp(), 10L, 11L),
                            new Session("Incearca sa intelegi ca trec printr-o faza grea. Identifica problemele care au rasarit si spune-le ca te deranjeaza si ca vrei o schimbare. DAca te iubesc vor face ceva.", timestamp(), 10L, 12L),
                            new Session("Spune parintilor tai ce s-a intamplat, daca situatia nu se schimba o sa ramai fara jucari si nu e bine.", timestamp(), 20L, 13L),
                            new Session("Ar trebui sa nu mai iei in considerare ce spun prietenii tai, ba chiar nici nu ar trebui sa mai stai cu ei. Un prieten il valorifica la maxim pe celalalt si ei se sprijina. Poti spune cu certitudine ca aceia sunt prieteni de-ai tai cu adevarat ? Eu spun ca nu.", timestamp(), 11L, 14L),
                            new Session("Acest lucru nu este bun absolut deloc, nu este permis asa ceva in scoli.", timestamp(), 12L, 15L),
                            new Session("Statul arunca bani pe lucruri inutile de multe ori si uita ca elementul cel mai important este omul, cetateanul, copilul care va deveni un adult. Hai sa indreptam lucrurile.", timestamp(), 13L, 16L),
                            new Session("Empatizeaza cu ea si intelege de ce ar face acest lucru. Crezi ca este normal? I-ai dat motive sa creada aceste lucruri ?", timestamp(), 14L, 17L),
                            new Session("De multe ori profesorii au stabilit anumite reguli care, pentru ei au sens, dar daca intrebi pe altcineva cu siguranta i-ar contrazice. Este cu siguranta o neintelegere la mijloc dar este dificil sa te intelegi cu anumite persoane. Hai sa cautam o solutie ca sa diminuam aceasta problema pentru viitor apropiat.", timestamp(), 15L, 18L),
                            new Session("Nu este bine niciodata sa ai multe lucruri pe cap, pentru ca apare HAOS ! Haide sa te reoganizam si sa te scapam de probleme inainte sa se agraveze.", timestamp(), 16L, 18L),
                            new Session("Acest lucru s-ar putea sa fie un mecanism de auto-aparare dezvoltat la o varsta mai frageda. Hai sa investigam unde e radacina.", timestamp(), 17L, 19L),
                            new Session("Acest lucru s-ar putea sa fie un mecanism de auto-aparare dezvoltat la o varsta mai frageda. Hai sa investigam unde e radacina.", timestamp(), 18L, 20L),
                            new Session("In viata vor fi provocari peste provocari. Nu ne putem ascunde intr-o cochilie in timp ce lumea e bombardata. Si noi vom fi prinsi, asa ca trebuie sa rezolvam situatia sa nu se ajunga la o astfel de situatie.", timestamp(), 19L, 21L),
                            new Session("Acest lucru s-ar putea sa fie cauzat din faptul ca ei nu au jucarii acasa. Inseamna ca parintii lor nu au o situatie buna financiara. Poate ca au probleme acasa si jucariile tale le ofera singura bucurie.", timestamp(), 20L, 22L),
                            new Session("Facultatea nu este by-default o cale spre succes in viata. Se predau multe lucruri invechite, in timp ce afacerile se dezvolta si avanseaza tehnologic foarte mult.", timestamp(), 21L, 23L),
                            new Session("Viata este un mister pe care cu totii cautam sa-l elucidam. Haide sa investigam putin.", timestamp(), 22L, 24L),
                            new Session("In prim plan lumea ofera o varietate de oportunitati, s-ar putea sa-ti placa una.", timestamp(), 22L, 25L),
                            new Session("Gandeste-te la tine insuti, ce te face fericit ?", timestamp(), 22L, 26L),
                            new Session("Ce inseamna moartea ? Asta e o intrebare si mai buna.", timestamp(), 22L, 27L),
                            new Session("Statul nu aloca banii cum trebuie, multi sunt furati, sunt pline partidele de coruptie. Haide sa facem ceva in legatura cu asta.", timestamp(), 28L, 28L),
                            new Session("Batranetea isi spune cuvantul, este normal sa se intampla asa ceva. Sa vedem cum procedam.", timestamp(), 29L, 29L),
                            new Session("'Knowledge is power' - ca sa masterezi anumite lucruri e nevoie sa investesti timp.", timestamp(), 30L, 30L),
                            new Session("Cu rabdarea poti sa treci si marea !", timestamp(), 30L, 30L),
                            new Session("Nu mai bea, punct !", timestamp(), 34L, 18L),
                            new Session("Scoala s-ar putea sa ofere sprijin in legatura cu acest lucru.", timestamp(), 40L, 16L),
                            new Session("Posibil ca vremea este cea care e de vina, oare de ce ?", timestamp(), 29L, 22L),
                            new Session("Sa o luam usor, este o problema fina care trebuie tratata cat mai devreme si sa nu mai apara pe viitor. Poate avea impact mare.", timestamp(), 33L, null),
                            new Session("Hai sa identificam care sunt factorii care te trag in jos.", timestamp(), 1L, null),
                            new Session("Acest lucru trebuie tratat urgent, este nevoie sa apelam la autoritati.", timestamp(), 42L, null),
                            new Session("Gandeste-te ca sunt vreo 1% din totii oamenii care gandesc ca tine care au reusit. Crezi ca ai ce trebuie ca sa atingi visul tau ?", timestamp(), 44L, null),
                            new Session("Nu este normal asa ceva ! Trebuie raportat la autoritati ca sa se faca ceva.", timestamp(), 40L, null),
                            new Session("Inseamna ca acel loc nu era pentru tine si este mai bine ca ai acumulat niste experienta si poti cauta un loc mai bun unde dreptul tau sa poata fi respectat.", timestamp(), 39L, null),
                            new Session("Un sir de mistere :)", timestamp(), 22L, null),
                            new Session("Esti baiat destept, te descurci tu...", timestamp(), 4L, null)
                    };
                }
            }
        }
        return sSessions;
    }
}
