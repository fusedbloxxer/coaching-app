package com.faculty.fusedbloxxer.coachingapp.home.sessions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.TableFragment;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Session;

import java.util.List;

public class SessionFragment extends TableFragment<Long> {

    private SessionAdapter sessionAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.table_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(sessionAdapter = new SessionAdapter(this));
    }

    @Override
    protected void fetchDataFromDatabase(int i) {
        switch (i) {
            case -1:
                vm.getAllSessions().observe(this, new Observer<List<Session>>() {
                    @Override
                    public void onChanged(List<Session> sessions) {
                        vm.getAllSessions().removeObserver(this);
                        sessionAdapter.setSessionList(sessions);
                    }
                });
                break;
            case 0:
                vm.getSessionsSotedBySessionIdAsc().observe(this, new Observer<List<Session>>() {
                    @Override
                    public void onChanged(List<Session> sessions) {
                        vm.getSessionsSotedBySessionIdAsc().removeObserver(this);
                        sessionAdapter.setSessionList(sessions);
                    }
                });
                break;
            case 1:
                vm.getSessionsSotedBySessionIdDesc().observe(this, new Observer<List<Session>>() {
                    @Override
                    public void onChanged(List<Session> sessions) {
                        vm.getSessionsSotedBySessionIdDesc().removeObserver(this);
                        sessionAdapter.setSessionList(sessions);
                    }
                });
                break;
            case 2:
                vm.getSessionsSotedByStartDateAsc().observe(this, new Observer<List<Session>>() {
                    @Override
                    public void onChanged(List<Session> sessions) {
                        vm.getSessionsSotedByStartDateAsc().removeObserver(this);
                        sessionAdapter.setSessionList(sessions);
                    }
                });
                break;
            case 3:
                vm.getSessionsSotedByStartDateDesc().observe(this, new Observer<List<Session>>() {
                    @Override
                    public void onChanged(List<Session> sessions) {
                        vm.getSessionsSotedByStartDateDesc().removeObserver(this);
                        sessionAdapter.setSessionList(sessions);
                    }
                });
                break;
            case 4:
                vm.getSessionsSotedByDiscussionLenAsc().observe(this, new Observer<List<Session>>() {
                    @Override
                    public void onChanged(List<Session> sessions) {
                        vm.getSessionsSotedByDiscussionLenAsc().removeObserver(this);
                        sessionAdapter.setSessionList(sessions);
                    }
                });
                break;
            case 5:
                vm.getSessionsSotedByDiscussionLenDesc().observe(this, new Observer<List<Session>>() {
                    @Override
                    public void onChanged(List<Session> sessions) {
                        vm.getSessionsSotedByDiscussionLenDesc().removeObserver(this);
                        sessionAdapter.setSessionList(sessions);
                    }
                });
                break;
            default:
                throw new RuntimeException("Invalid option !");
        }
    }

    @Override
    protected String[] getOptions() {
        return new String[]{
                "Id (Mic-Mare)",
                "Id (Mare-Mic)",
                "Data incepere (Mic-Mare)",
                "Data incepere (Mare-Mic)",
                "Lungime discutie (Mic-Mare)",
                "Lungime discutie (Mare-Mic)"
        };
    }

    @Override
    protected void onFabClick() {
        navController.navigate(SessionFragmentDirections.actionSedinteToSessionModFragment());
    }

    @Override
    protected String getSortKey() {
        return "SESSIONS_SORT";
    }

    @Override
    public void updateOrDelete(Long element, int option) {
        if (option == 0) {
            navController.navigate(SessionFragmentDirections.actionSedinteToSessionModFragment()
                    .setSessionId(element.toString()));
        } else {
            vm.deleteSessionWithId(element);
        }
    }
}
