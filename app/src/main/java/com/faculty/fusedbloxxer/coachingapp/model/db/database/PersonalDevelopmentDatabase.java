package com.faculty.fusedbloxxer.coachingapp.model.db.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.faculty.fusedbloxxer.coachingapp.model.db.converters.DateConverter;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.FeedbackDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.LocationDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.MaterialDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.ProblemDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.QueriesDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.RoleDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.SessionDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.SessionMaterialDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.SessionTaskDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.TaskDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.TaskHistoryDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.UserDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.daos.ViewsDao;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Feedback;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Location;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Material;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Problem;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Role;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Session;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.SessionMaterial;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.SessionTask;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Task;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.TaskHistory;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.User;
import com.faculty.fusedbloxxer.coachingapp.model.db.views.SpecialTask;
import com.faculty.fusedbloxxer.coachingapp.model.db.views.UserWithRole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(
        entities = {
                Role.class, Task.class, TaskHistory.class, User.class,
                Feedback.class, Location.class, Material.class,
                SessionMaterial.class, SessionTask.class,
                Problem.class, Session.class
        },
        views = {SpecialTask.class, UserWithRole.class},
        version = 1
)
@TypeConverters(DateConverter.class)
public abstract class PersonalDevelopmentDatabase extends RoomDatabase {
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriterExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile PersonalDevelopmentDatabase INSTANCE;

    /*
     *   DAOs
     */
    public abstract RoleDao roleDao();

    public abstract TaskDao taskDao();

    public abstract UserDao userDao();

    public abstract ViewsDao viewsDao();

    public abstract QueriesDao queriesDao();

    public abstract ProblemDao problemDao();

    public abstract SessionDao sessionDao();

    public abstract FeedbackDao feedbackDao();

    public abstract LocationDao locationDao();

    public abstract MaterialDao materialDao();

    public abstract SessionTaskDao sessionTaskDao();

    public abstract TaskHistoryDao taskHistoryDao();

    public abstract SessionMaterialDao sessionMaterialDao();

    /*
     *  DATABASE
     */
    public static PersonalDevelopmentDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PersonalDevelopmentDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PersonalDevelopmentDatabase.class, "dezvoltare_personala")
                            .addCallback(prepopulateDatabase)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback prepopulateDatabase = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            db.execSQL("DROP TABLE feedbacks");
            db.execSQL("CREATE TABLE \"feedbacks\" (\n" +
                    "\t\"data_emitere\"\tINTEGER NOT NULL,\n" +
                    "\t\"puncte_evaluare\"\tREAL NOT NULL CHECK(puncte_evaluare BETWEEN 0 AND 5),\n" +
                    "\t\"continut\"\tTEXT NOT NULL,\n" +
                    "\t\"titlu\"\tTEXT NOT NULL,\n" +
                    "\t\"id_feedback\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                    "\t\"id_sedinta\"\tINTEGER NOT NULL UNIQUE,\n" +
                    "\tFOREIGN KEY(\"id_sedinta\") REFERENCES \"sedinte\"(\"id_sedinta\") ON UPDATE CASCADE ON DELETE CASCADE\n" +
                    ");");
            db.execSQL("CREATE UNIQUE INDEX \"index_feedbacks_id_sedinta\" ON \"feedbacks\" (\n" +
                    "\t\"id_sedinta\"\n" +
                    ");");

            db.execSQL("DROP TABLE locatii");
            db.execSQL("CREATE TABLE \"locatii\" (\n" +
                    "\t\"url_imagine\"\tTEXT NOT NULL,\n" +
                    "\t\"strada\"\tTEXT NOT NULL,\n" +
                    "\t\"denumire\"\tTEXT,\n" +
                    "\t\"id_locatie\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE\n" +
                    ");");

            db.execSQL("DROP TABLE materiale");
            db.execSQL("CREATE TABLE \"materiale\" (\n" +
                    "\t\"timp_estimat\"\tINTEGER CHECK(timp_estimat >= 0),\n" +
                    "\t\"rezumat\"\tTEXT,\n" +
                    "\t\"url_imagine\"\tTEXT,\n" +
                    "\t\"url_sursa\"\tTEXT NOT NULL,\n" +
                    "\t\"titlu\"\tTEXT NOT NULL,\n" +
                    "\t\"id_material\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE\n" +
                    ");");

            db.execSQL("DROP TABLE probleme");
            db.execSQL("CREATE TABLE \"probleme\" (\n" +
                    "\t\"stare\"\tTEXT NOT NULL,\n" +
                    "\t\"description\"\tTEXT NOT NULL,\n" +
                    "\t\"titlu\"\tTEXT NOT NULL,\n" +
                    "\t\"id_problema\"\tINTEGER NOT NULL UNIQUE,\n" +
                    "\t\"id_coach\"\tTEXT NOT NULL,\n" +
                    "\t\"id_client\"\tTEXT NOT NULL,\n" +
                    "\tPRIMARY KEY(\"id_problema\"),\n" +
                    "\tFOREIGN KEY(\"id_coach\") REFERENCES \"utilizatori\"(\"nume_utilizator\") ON UPDATE CASCADE ON DELETE CASCADE,\n" +
                    "\tFOREIGN KEY(\"id_client\") REFERENCES \"utilizatori\"(\"nume_utilizator\") ON UPDATE CASCADE ON DELETE CASCADE\n" +
                    ");");
            db.execSQL("CREATE INDEX \"index_probleme_id_client\" ON \"probleme\" (\n" +
                    "\t\"id_client\"\n" +
                    ");");
            db.execSQL("CREATE INDEX \"index_probleme_id_coach\" ON \"probleme\" (\n" +
                    "\t\"id_coach\"\n" +
                    ");");
            db.execSQL("CREATE TRIGGER IF NOT EXISTS user_check_insert " +
                    "BEFORE INSERT ON probleme " +
                    "WHEN LOWER((SELECT id_rol FROM utilizatori WHERE nume_utilizator = NEW.id_coach)) NOT LIKE '%coach%' " +
                    "OR LOWER((SELECT id_rol FROM utilizatori WHERE nume_utilizator = NEW.id_client)) NOT LIKE '%client%' " +
                    "BEGIN SELECT RAISE(FAIL,  'utilizatorul nu are rolul potrivit !'); END;");
            db.execSQL("CREATE TRIGGER IF NOT EXISTS user_check_update " +
                    "BEFORE UPDATE ON probleme " +
                    "WHEN LOWER((SELECT id_rol FROM utilizatori WHERE nume_utilizator = NEW.id_coach)) NOT LIKE '%coach%' " +
                    "OR LOWER((SELECT id_rol FROM utilizatori WHERE nume_utilizator = NEW.id_client)) NOT LIKE '%client%' " +
                    "BEGIN SELECT RAISE(FAIL, 'utilizatorul nu are rolul potrivit !'); END;");

            db.execSQL("DROP TABLE roluri");
            db.execSQL("CREATE TABLE \"roluri\" (\n" +
                    "\t\"url_imagine\"\tTEXT NOT NULL,\n" +
                    "\t\"descriere\"\tTEXT NOT NULL,\n" +
                    "\t\"id_rol\"\tTEXT NOT NULL UNIQUE,\n" +
                    "\tPRIMARY KEY(\"id_rol\")\n" +
                    ");");

            db.execSQL("DROP TABLE sedinte");
            db.execSQL("CREATE TABLE \"sedinte\" (\n" +
                    "\t\"discutie\"\tTEXT NOT NULL,\n" +
                    "\t\"data_de_incepere\"\tINTEGER NOT NULL,\n" +
                    "\t\"id_sedinta\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                    "\t\"id_problema\"\tINTEGER NOT NULL,\n" +
                    "\t\"id_locatie\"\tINTEGER,\n" +
                    "\tFOREIGN KEY(\"id_problema\") REFERENCES \"probleme\"(\"id_problema\") ON UPDATE CASCADE ON DELETE CASCADE,\n" +
                    "\tFOREIGN KEY(\"id_locatie\") REFERENCES \"locatii\"(\"id_locatie\") ON UPDATE CASCADE ON DELETE SET NULL\n" +
                    ");");
            db.execSQL("CREATE INDEX \"index_sedinte_id_locatie\" ON \"sedinte\" (\n" +
                    "\t\"id_locatie\"\n" +
                    ");");
            db.execSQL("CREATE INDEX \"index_sedinte_id_problema\" ON \"sedinte\" (\n" +
                    "\t\"id_problema\"\n" +
                    ");");

            db.execSQL("DROP TABLE atasate_la");
            db.execSQL("CREATE TABLE \"atasate_la\" (\n" +
                    "\t\"timp_disponibil\"\tINTEGER CHECK(timp_disponibil >= 0),\n" +
                    "\t\"data_initiala\"\tINTEGER NOT NULL,\n" +
                    "\t\"id_sedinta\"\tINTEGER NOT NULL,\n" +
                    "\t\"id_material\"\tINTEGER NOT NULL,\n" +
                    "\tPRIMARY KEY(\"id_sedinta\",\"id_material\"),\n" +
                    "\tFOREIGN KEY(\"id_sedinta\") REFERENCES \"sedinte\"(\"id_sedinta\") ON UPDATE CASCADE ON DELETE CASCADE,\n" +
                    "\tFOREIGN KEY(\"id_material\") REFERENCES \"materiale\"(\"id_material\") ON UPDATE CASCADE ON DELETE CASCADE\n" +
                    ");");
            db.execSQL("CREATE UNIQUE INDEX \"index_atasate_la_id_sedinta_id_material\" ON \"atasate_la\" (\n" +
                    "\t\"id_sedinta\",\n" +
                    "\t\"id_material\"\n" +
                    ");");
            db.execSQL("CREATE INDEX \"index_atasate_la_id_sedinta\" ON \"atasate_la\" (\n" +
                    "\t\"id_sedinta\"\n" +
                    ");");
            db.execSQL("CREATE INDEX \"index_atasate_la_id_material\" ON \"atasate_la\" (\n" +
                    "\t\"id_material\"\n" +
                    ");");

            db.execSQL("DROP TABLE includ");
            db.execSQL("CREATE TABLE \"includ\" (\n" +
                    "\t\"prioritate\"\tINTEGER CHECK(prioritate BETWEEN 0 AND 10),\n" +
                    "\t\"data_initiala\"\tINTEGER NOT NULL,\n" +
                    "\t\"id_sedinta\"\tINTEGER NOT NULL,\n" +
                    "\t\"id_sarcina\"\tINTEGER NOT NULL,\n" +
                    "\tPRIMARY KEY(\"id_sedinta\",\"id_sarcina\"),\n" +
                    "\tFOREIGN KEY(\"id_sedinta\") REFERENCES \"sedinte\"(\"id_sedinta\") ON UPDATE CASCADE ON DELETE CASCADE,\n" +
                    "\tFOREIGN KEY(\"id_sarcina\") REFERENCES \"sarcini\"(\"id_sarcina\") ON UPDATE CASCADE ON DELETE CASCADE\n" +
                    ");");
            db.execSQL("CREATE UNIQUE INDEX \"index_includ_id_sedinta_id_sarcina\" ON \"includ\" (\n" +
                    "\t\"id_sedinta\",\n" +
                    "\t\"id_sarcina\"\n" +
                    ");");
            db.execSQL("CREATE INDEX \"index_includ_id_sedinta\" ON \"includ\" (\n" +
                    "\t\"id_sedinta\"\n" +
                    ");");
            db.execSQL("CREATE INDEX \"index_includ_id_sarcina\" ON \"includ\" (\n" +
                    "\t\"id_sarcina\"\n" +
                    ");");

            db.execSQL("DROP TABLE sarcini");
            db.execSQL("CREATE TABLE \"sarcini\" (\n" +
                    "\t\"timp_estimat\"\tINTEGER CHECK(timp_estimat >= 0),\n" +
                    "\t\"descriere\"\tTEXT NOT NULL,\n" +
                    "\t\"puncte_premiu\"\tINTEGER CHECK(puncte_premiu BETWEEN 0 AND 100),\n" +
                    "\t\"titlu\"\tTEXT NOT NULL,\n" +
                    "\t\"id_sarcina\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE\n" +
                    ");");

            db.execSQL("DROP TABLE istoric_sarcini");
            db.execSQL("CREATE TABLE \"istoric_sarcini\" (\n" +
                    "\t\"comentariu\"\tTEXT,\n" +
                    "\t\"evaluare_incredere\"\tINTEGER CHECK(evaluare_incredere BETWEEN 0 AND 10),\n" +
                    "\t\"id_sarcina\"\tINTEGER NOT NULL,\n" +
                    "\t\"data_completare\"\tINTEGER NOT NULL,\n" +
                    "\tPRIMARY KEY(\"id_sarcina\",\"data_completare\"),\n" +
                    "\tFOREIGN KEY(\"id_sarcina\") REFERENCES \"sarcini\"(\"id_sarcina\") ON UPDATE CASCADE ON DELETE CASCADE\n" +
                    ");");
            db.execSQL("CREATE UNIQUE INDEX \"index_istoric_sarcini_id_sarcina_data_completare\" ON \"istoric_sarcini\" (\n" +
                    "\t\"id_sarcina\",\n" +
                    "\t\"data_completare\"\n" +
                    ");");

            db.execSQL("DROP TABLE utilizatori");
            db.execSQL("CREATE TABLE \"utilizatori\" (\n" +
                    "\t\"parola\"\tTEXT NOT NULL CHECK(LENGTH(parola) > 6),\n" +
                    "\t\"adresa_email\"\tTEXT CHECK(adresa_email LIKE '%@%.%'),\n" +
                    "\t\"prenume\"\tTEXT NOT NULL,\n" +
                    "\t\"nume\"\tTEXT NOT NULL,\n" +
                    "\t\"nume_utilizator\"\tTEXT NOT NULL CHECK(INSTR(nume_utilizator, ' ') = 0) UNIQUE,\n" +
                    "\t\"id_rol\"\tTEXT NOT NULL,\n" +
                    "\tPRIMARY KEY(\"nume_utilizator\"),\n" +
                    "\tFOREIGN KEY(\"id_rol\") REFERENCES \"roluri\"(\"id_rol\") ON UPDATE CASCADE ON DELETE CASCADE\n" +
                    ");");
            db.execSQL("CREATE INDEX \"index_utilizatori_id_rol\" ON \"utilizatori\" (\n" +
                    "\t\"id_rol\"\n" +
                    ");");
            db.execSQL("CREATE TRIGGER IF NOT EXISTS user_satisfies_role " +
                    "BEFORE UPDATE ON utilizatori " +
                    "WHEN ((SELECT COUNT(*) FROM probleme WHERE NEW.nume_utilizator = id_coach) > 0 AND LOWER(NEW.id_rol) NOT LIKE '%coach%')" +
                    "OR ((SELECT COUNT(*) FROM probleme WHERE NEW.nume_utilizator = id_client) > 0 AND LOWER(NEW.id_rol) NOT LIKE '%client%')" +
                    "BEGIN SELECT RAISE(FAIL, 'utilizatorul nu isi poate modifica rolul !!'); END;");

//            db.execSQL("CREATE VIEW IF NOT EXISTS VIEW_SEDINTE_SPECIALE\n" +
//                    "AS\n" +
//                    "SELECT descriere AS description, UPPER(titlu) AS upperTitle, \n" +
//                    "\t(CASE\n" +
//                    "\t\tWHEN puncte_premiu * 2 > 100 THEN 100\n" +
//                    "\t\tELSE puncte_premiu * 2\n" +
//                    "\tEND) AS doubledRewards\n" +
//                    "FROM sarcini;");
//
//            db.execSQL("CREATE VIEW IF NOT EXISTS VIEW_ROLURI_UTILIZATORI " +
//                    "AS " +
//                    "SELECT roluri.*, utilizatori.* " +
//                    "FROM roluri " +
//                    "JOIN utilizatori ON(roluri.id_rol = utilizatori.id_rol);");

            databaseWriterExecutor.execute(() -> {
                INSTANCE.roleDao().insert(Role.getFakeRoles());

                INSTANCE.userDao().insert(User.getFakeUsers());

                INSTANCE.problemDao().insert(Problem.getFakeProblems());

                INSTANCE.locationDao().insert(Location.getFakeLocations());
                INSTANCE.materialDao().insert(Material.getFakeMaterials());

                INSTANCE.sessionDao().insert(Session.getFakeSessions());
                INSTANCE.feedbackDao().insert(Feedback.getFakeFeedbacks());

                INSTANCE.taskDao().insert(Task.getFakeTasks());

                INSTANCE.taskHistoryDao().insert(TaskHistory.getFakeTaskHistories());
                INSTANCE.sessionTaskDao().insert(SessionTask.getFakeSessionTasks());
                INSTANCE.sessionMaterialDao().insert(SessionMaterial.getFakeSessionMaterials());

            });
        }
    };
}