package com.faculty.fusedbloxxer.coachingapp.home.sessionstasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.TableFragment;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.SessionTask;
import com.faculty.fusedbloxxer.coachingapp.utilities.Pair;

import java.util.List;

public class SessionTaskFragment extends TableFragment<Pair<Long, Long>> {

    private SessionTaskAdapter sessionTaskAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.table_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(sessionTaskAdapter = new SessionTaskAdapter(this));
    }

    @Override
    protected void fetchDataFromDatabase(int i) {
        switch (i) {
            case -1:
                vm.getAllSessionsTasks().observe(this, new Observer<List<SessionTask>>() {
                    @Override
                    public void onChanged(List<SessionTask> sessionTasks) {
                        vm.getAllSessionsTasks().removeObserver(this);
                        sessionTaskAdapter.setSessionTasks(sessionTasks);
                    }
                });
                break;
            case 0:
                vm.getSessionsTasksSortedByPriorityAsc().observe(this, new Observer<List<SessionTask>>() {
                    @Override
                    public void onChanged(List<SessionTask> sessionTasks) {
                        vm.getSessionsTasksSortedByPriorityAsc().removeObserver(this);
                        sessionTaskAdapter.setSessionTasks(sessionTasks);
                    }
                });
                break;
            case 1:
                vm.getSessionsTasksSortedByPriorityDesc().observe(this, new Observer<List<SessionTask>>() {
                    @Override
                    public void onChanged(List<SessionTask> sessionTasks) {
                        vm.getSessionsTasksSortedByPriorityDesc().removeObserver(this);
                        sessionTaskAdapter.setSessionTasks(sessionTasks);
                    }
                });
                break;
            case 2:
                vm.getSessionsTasksSortedByDateAsc().observe(this, new Observer<List<SessionTask>>() {
                    @Override
                    public void onChanged(List<SessionTask> sessionTasks) {
                        vm.getSessionsTasksSortedByDateAsc().removeObserver(this);
                        sessionTaskAdapter.setSessionTasks(sessionTasks);
                    }
                });
                break;
            case 3:
                vm.getSessionsTasksSortedByDateDesc().observe(this, new Observer<List<SessionTask>>() {
                    @Override
                    public void onChanged(List<SessionTask> sessionTasks) {
                        vm.getSessionsTasksSortedByDateDesc().removeObserver(this);
                        sessionTaskAdapter.setSessionTasks(sessionTasks);
                    }
                });
                break;
            default:
                throw new RuntimeException("Optiune invalida !");
        }
    }

    @Override
    protected String[] getOptions() {
        return new String[]{
                "Prioritate (Mica-Mare)",
                "Prioritate (Mare-Mica)",
                "Data initiala (Mica-Mare)",
                "Data initiala (Mare-Mica)"
        };
    }

    @Override
    protected void onFabClick() {
        navController.navigate(SessionTaskFragmentDirections
                .actionIncludToSessionTaskModFragment()
        );
    }

    @Override
    protected String getSortKey() {
        return "SESSIONS_TASKS_SORT";
    }

    @Override
    public void updateOrDelete(Pair<Long, Long> element, int option) {
        if (option == 0) {
            navController.navigate(SessionTaskFragmentDirections
                    .actionIncludToSessionTaskModFragment()
                    .setSessionId(element.getT1().toString())
                    .setTaskId(element.getT2().toString())
            );
        } else {
            vm.deleteSessionTaskByIds(element.getT1(), element.getT2());
        }
    }
}
