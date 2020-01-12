package com.faculty.fusedbloxxer.coachingapp.home.sessionsmaterials;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.TableFragment;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.SessionMaterial;
import com.faculty.fusedbloxxer.coachingapp.utilities.Pair;

import java.util.List;

public class SessionMaterialFragment extends TableFragment<Pair<Long, Long>> {

    private SessionMaterialAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.table_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(adapter = new SessionMaterialAdapter(this));
    }

    @Override
    protected void fetchDataFromDatabase(int i) {
        switch (i) {
            case -1:
                vm.getAllSessionsMaterials().observe(this, new Observer<List<SessionMaterial>>() {
                    @Override
                    public void onChanged(List<SessionMaterial> sessionMaterials) {
                        vm.getAllSessionsMaterials().removeObserver(this);
                        adapter.setSessionMaterials(sessionMaterials);
                    }
                });
                break;
            case 0:
                vm.getSessionsMaterialsSortedByStartDateAsc().observe(this, new Observer<List<SessionMaterial>>() {
                    @Override
                    public void onChanged(List<SessionMaterial> sessionMaterials) {
                        vm.getSessionsMaterialsSortedByStartDateAsc().removeObserver(this);
                        adapter.setSessionMaterials(sessionMaterials);
                    }
                });
                break;
            case 1:
                vm.getSessionsMaterialsSortedByStartDateDesc().observe(this, new Observer<List<SessionMaterial>>() {
                    @Override
                    public void onChanged(List<SessionMaterial> sessionMaterials) {
                        vm.getSessionsMaterialsSortedByStartDateDesc().removeObserver(this);
                        adapter.setSessionMaterials(sessionMaterials);
                    }
                });
                break;
            case 2:
                vm.getSessionsMaterialsSortedByTimeAsc().observe(this, new Observer<List<SessionMaterial>>() {
                    @Override
                    public void onChanged(List<SessionMaterial> sessionMaterials) {
                        vm.getSessionsMaterialsSortedByTimeAsc().removeObserver(this);
                        adapter.setSessionMaterials(sessionMaterials);
                    }
                });
                break;
            case 3:
                vm.getSessionsMaterialsSortedByTimeDesc().observe(this, new Observer<List<SessionMaterial>>() {
                    @Override
                    public void onChanged(List<SessionMaterial> sessionMaterials) {
                        vm.getSessionsMaterialsSortedByTimeDesc().removeObserver(this);
                        adapter.setSessionMaterials(sessionMaterials);
                    }
                });
                break;
            default:
                throw new RuntimeException("Invalid option.");
        }
    }

    @Override
    protected String[] getOptions() {
        return new String[]{
                "Data (Mica-Mare)",
                "Data (Mare-Mica)",
                "Timp disponibil (Puțin-Mult)",
                "Timp disponibil (Mult-Puțin)"
        };
    }

    @Override
    protected void onFabClick() {
        navController.navigate(SessionMaterialFragmentDirections
                .actionAtasateLaToSessionMaterialModFragment()
        );
    }

    @Override
    protected String getSortKey() {
        return "SESSIONS_MATERIALS_SORT";
    }

    @Override
    public void updateOrDelete(Pair<Long, Long> element, int option) {
        if (option == 0) {
            navController.navigate(SessionMaterialFragmentDirections
                    .actionAtasateLaToSessionMaterialModFragment()
                    .setSessionId(element.getT1().toString())
                    .setMaterialId(element.getT2().toString())
            );
        } else {
            vm.deleteSessionMaterialByIds(element.getT1(), element.getT2());
        }
    }
}
