package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.containers.CoachWithScores;
import com.faculty.fusedbloxxer.coachingapp.model.db.containers.UrgentSession;

import java.util.List;

@Dao
public interface QueriesDao {

    @Query("SELECT nume_utilizator AS coachName, MAX(puncte_evaluare) AS maxScore, AVG(medie_puncte) AS avgScore\n" +
            "FROM utilizatori\n" +
            "LEFT JOIN probleme ON(utilizatori.nume_utilizator = probleme.id_coach)\n" +
            "LEFT JOIN sedinte ON(probleme.id_problema = sedinte.id_problema)\n" +
            "LEFT JOIN feedbacks ON(sedinte.id_sedinta = feedbacks.id_sedinta)\n" +
            "JOIN (SELECT nume_utilizator nume_coach, AVG(puncte_evaluare) AS medie_puncte\n" +
            "      FROM utilizatori\n" +
            "      LEFT JOIN probleme ON(utilizatori.nume_utilizator = probleme.id_coach)\n" +
            "      LEFT JOIN sedinte ON(probleme.id_problema = sedinte.id_problema)\n" +
            "      LEFT JOIN feedbacks ON(sedinte.id_sedinta = feedbacks.id_sedinta)\n" +
            "      WHERE LOWER(id_rol) LIKE '%coach%'\n" +
            "      GROUP BY nume_utilizator, probleme.id_problema) ON(utilizatori.nume_utilizator = nume_coach)\n" +
            "WHERE LOWER(id_rol) LIKE '%coach%'\n" +
            "GROUP BY nume_utilizator\n" +
            "HAVING IFNULL(AVG(medie_puncte), 0) >= :avgScore\n" +
            "AND IFNULL(MAX(puncte_evaluare), 0) >= :maxScore\n" +
            "ORDER BY IFNULL(AVG(medie_puncte), 0) DESC, IFNULL(MAX(medie_puncte), 0) DESC;")
    LiveData<List<CoachWithScores>> groupCoachesHaving(@NonNull Float avgScore, @NonNull Float maxScore);

    @Query("SELECT id_client AS username, probleme.titlu AS problemTitle, sarcini.titlu AS sessionTitle, \n" +
            "\tsarcini.descriere AS sessionDescription, puncte_premiu AS rewardPoints, prioritate AS priority,\n" +
            "\ttimp_estimat AS estimatedTime, url_imagine AS imageUrl, strada AS street\n" +
            "FROM probleme\n" +
            "JOIN sedinte USING(id_problema)\n" +
            "JOIN locatii USING(id_locatie)\n" +
            "JOIN includ USING(id_sedinta)\n" +
            "JOIN sarcini USING(id_sarcina)\n" +
            "WHERE puncte_premiu >= :rewardPoints \n" +
            "AND prioritate >= :priority \n" +
            "AND timp_estimat IS NOT NULL\n" +
            "ORDER BY id_client ASC, prioritate DESC, timp_estimat ASC, puncte_premiu DESC;")
    LiveData<List<UrgentSession>> getUrgentSessionsWhere(@NonNull Long rewardPoints, @NonNull Long priority);

//    @Query("INSERT INTO UserWithRole(roleId, username, firstName, lastName, password) VALUES(:roleId, :username, :firstName, :lastName, :password)")
//    void insert(@NonNull String roleId, @NonNull String username, @NonNull String firstName, @NonNull String lastName, @NonNull String password);

}
