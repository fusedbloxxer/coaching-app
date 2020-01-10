package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static androidx.room.ForeignKey.CASCADE;
import static com.faculty.fusedbloxxer.coachingapp.utilities.Utils.randomNumber;
import static com.faculty.fusedbloxxer.coachingapp.utilities.Utils.timestamp;

@Entity(
        tableName = "feedbacks",
        foreignKeys = {
                @ForeignKey(
                        entity = Session.class,
                        parentColumns = "id_sedinta",
                        childColumns = "id_sedinta",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                )
        },
        indices = {
                @Index(value = "id_sedinta", unique = true)
        }
)
public class Feedback {
    @NonNull
    @ColumnInfo(name = "data_emitere")
    private Date sentDate;

    @NonNull
    @ColumnInfo(name = "puncte_evaluare", defaultValue = "5")
    private Float rating;

    @NonNull
    @ColumnInfo(name = "continut")
    private String content;

    @NonNull
    @ColumnInfo(name = "titlu")
    private String title;

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_feedback")
    private Long feedbackId;

    @NonNull
    @ColumnInfo(name = "id_sedinta")
    private Long sessionId;

    public Feedback(@NonNull Date sentDate, @NonNull Float rating, @NonNull String content, @NonNull String title, @NonNull Long feedbackId, @NonNull Long sessionId) {
        this.sentDate = sentDate;
        this.rating = rating;
        this.content = content;
        this.title = title;
        this.feedbackId = feedbackId;
        this.sessionId = sessionId;
    }

    @Ignore
    public Feedback(@NonNull Date sentDate, @NonNull Float rating, @NonNull String content, @NonNull String title, @NonNull Long sessionId) {
        this.sentDate = sentDate;
        this.rating = rating;
        this.content = content;
        this.title = title;
        this.sessionId = sessionId;
    }

    @NonNull
    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(@NonNull Date sentDate) {
        this.sentDate = sentDate;
    }

    @NonNull
    public Float getRating() {
        return rating;
    }

    public void setRating(@NonNull Float rating) {
        this.rating = rating;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(@NonNull Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    @NonNull
    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(@NonNull Long sessionId) {
        this.sessionId = sessionId;
    }

    @Ignore
    public String getFormattedDate() {
        return new SimpleDateFormat(Utils.DATE_FORMAT, Locale.ENGLISH).format(sentDate);
    }

    @NonNull
    @Override
    public String toString() {
        return "Feedback{" +
                "sentDate=" + sentDate +
                ", rating=" + rating +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", feedbackId=" + feedbackId +
                ", sessionId=" + sessionId +
                '}';
    }

    private static Feedback[] sFeedbacks;

    @NonNull
    public static Feedback[] getFakeFeedbacks() {
        if (sFeedbacks == null) {
            synchronized (Feedback.class) {
                if (sFeedbacks == null) {
                    sFeedbacks = new Feedback[]{
                            new Feedback(timestamp(), 5f, "Mi-a placut cumva", "Bun", 4L),
                            new Feedback(timestamp(), randomNumber(5), "Ok", "Nu stiu", 5L),
                            new Feedback(timestamp(), randomNumber(5), "A fost interesant", "Super", 3L),
                            new Feedback(timestamp(), randomNumber(5), "E tare tipul !", "Why not ?", 8L),
                            new Feedback(timestamp(), randomNumber(5), "Nu stiu daca as mai veni", "Nu-s sigur", 2L),
                            new Feedback(timestamp(), randomNumber(5), "Nu ati fost foarte serios", "Un mascarici", 1L),
                            new Feedback(timestamp(), randomNumber(5), "A fost o experienta placuta.", "A fost decent", 6L),
                            new Feedback(timestamp(), randomNumber(5), "Toate sarcinile mi-au trezit talentele ascunse", "O sa mai merg", 7L),
                            new Feedback(timestamp(), randomNumber(5), "«:::A:::» «:::W:::» «:::E:::» «:::S:::» «:::O:::» «:::M:::» «:::E:::»", "Super experienta", 9L),
                            new Feedback(timestamp(), randomNumber(5), "«:::A:::» «:::W:::» «:::E:::» «:::S:::» «:::O:::» «:::M:::» «:::E:::»", "Misto", 10L),
                            new Feedback(timestamp(), randomNumber(5), "-: ¦: - •: * '*: • .-: ¦: - • ❧ FABULOUS ❧ -: ¦: - ❧ RECOMAND-: ¦: - •: *' *: • .-: ¦: -", "Cool", 11L),
                            new Feedback(timestamp(), randomNumber(5), "★˜¨¨¯¯¨¨˜¤.¸`*•.¸*•¸★☆☆Thank you☆☆★¸•*¸.•*´¸.¤˜¨¨¯¯¨¨˜★", "Ok", 12L),
                            new Feedback(timestamp(), randomNumber(5), "F ***** I ***** V ***** E ***** S ***** T ***** A ***** R ***** S", "WOW", 13L),
                            new Feedback(timestamp(), randomNumber(5), "♥♥♥¨¨*:•.EXCELLENT.•:*¨¨*:•.COACH.•:*¨¨*:•.THANKS•:*¨¨♥♥♥", "Super bun!", 14L),
                            new Feedback(timestamp(), randomNumber(5), "Experiență de excepție!", "Mi-a placut", 15L),
                            new Feedback(timestamp(), randomNumber(5), "PERFECT º¤ø, ¸¸, ø¤COACH¤ø, ¸¸, ¸, øºø, ¸, ø¤SUPER ¤ø, ¸¸, ø¤º RECOMANDAT", "Mai vin !", 16L),
                            new Feedback(timestamp(), randomNumber(5), "♣♥¨¨♥:•..•:* Coach Absolutely Stellar*:•..•:♥¨¨♥♣", "Cum de nu te-am intalnit pana acum ?", 17L),
                            new Feedback(timestamp(), randomNumber(5), "+ _¯_¯_¯_¯_¦¦¦¦ NUMĂRUL 1 ! ||||_¯_¯_¯_¯_ +", "Grozav", 56L),
                            new Feedback(timestamp(), randomNumber(5), "Mulțumiri. Serviciu excelent.", "Prea ok", 55L),
                            new Feedback(timestamp(), 5.0f, "★★★★★ CINCI STELE ★★★★★", "Genial", 22L),
                            new Feedback(timestamp(), randomNumber(5), ".•:*¨¨*:•.A.•:*¨¨*:•.FIVE.•:*¨¨*:•.STAR.•:*¨¨*:•..•:*¨¨*:•.", "FANTASTIC !", 23L),
                            new Feedback(timestamp(), randomNumber(5), "▄▀▄▀▄▀▄▀▄▀▄▀█▓▒░M░E░R░C░I░▒▓█▀▄▀▄▀▄▀▄▀▄▀▄", "Fenomenal ;)", 25L),
                            new Feedback(timestamp(), randomNumber(5), "★˜¨¨¯¯¨¨˜¤.¸`*•.¸*•¸★☆☆Thank you☆☆★¸•*¸.•*´¸.¤˜¨¨¯¯¨¨˜★", "Grozaaaav !!", 26L),
                            new Feedback(timestamp(), randomNumber(5), "Ƹ̵̡Ӝ̵̨̄Ʒ ~~ UNUL dintre cei mai buni antrenori! ~~ Ƹ̵̡Ӝ̵̨̄Ʒ", "Faaantasticoo", 27L),
                            new Feedback(timestamp(), randomNumber(5), "*:☯.Thank You!.•:*¨¨*:•. Highly Recommend•:*¨¨*:☯.", "Mi-ai schimbat viata", 28L),
                            new Feedback(timestamp(), randomNumber(5), "Sper să te ocupi din nou. Mulțumesc.", "GOOOOOOD", 44L),
                            new Feedback(timestamp(), randomNumber(5), "«E» «X» «C» «E» «L» «L» «E» «N» «T»", "Minunat", 33L)
                    };
                }
            }
        }
        return sFeedbacks;
    }
}
