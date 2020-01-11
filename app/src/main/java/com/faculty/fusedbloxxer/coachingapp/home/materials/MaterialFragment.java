package com.faculty.fusedbloxxer.coachingapp.home.materials;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.TableFragment;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Material;

import java.util.List;

public class MaterialFragment extends TableFragment<Long> {

    private MaterialAdapter materialAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.table_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(materialAdapter = new MaterialAdapter(this));
    }

    @Override
    protected void fetchDataFromDatabase(int i) {
        switch (i) {
            case -1:
                vm.getAllMaterials().observe(this, new Observer<List<Material>>() {
                    @Override
                    public void onChanged(List<Material> materials) {
                        vm.getAllMaterials().removeObserver(this);
                        materialAdapter.setMaterials(materials);
                    }
                });
                break;
            case 0:
                vm.getMaterialsSortedByTitleAsc().observe(this, new Observer<List<Material>>() {
                    @Override
                    public void onChanged(List<Material> materials) {
                        vm.getMaterialsSortedByTitleAsc().removeObserver(this);
                        materialAdapter.setMaterials(materials);
                    }
                });
                break;
            case 1:
                vm.getMaterialsSortedByTitleDesc().observe(this, new Observer<List<Material>>() {
                    @Override
                    public void onChanged(List<Material> materials) {
                        vm.getMaterialsSortedByTitleDesc().removeObserver(this);
                        materialAdapter.setMaterials(materials);
                    }
                });
                break;
            case 2:
                vm.getMaterialsSortedByTimeAsc().observe(this, new Observer<List<Material>>() {
                    @Override
                    public void onChanged(List<Material> materials) {
                        vm.getMaterialsSortedByTimeAsc().removeObserver(this);
                        materialAdapter.setMaterials(materials);
                    }
                });
                break;
            case 3:
                vm.getMaterialsSortedByTimeDesc().observe(this, new Observer<List<Material>>() {
                    @Override
                    public void onChanged(List<Material> materials) {
                        vm.getMaterialsSortedByTimeDesc().removeObserver(this);
                        materialAdapter.setMaterials(materials);
                    }
                });
                break;
            case 4:
                vm.getMaterialsSortedByIdAsc().observe(this, new Observer<List<Material>>() {
                    @Override
                    public void onChanged(List<Material> materials) {
                        vm.getMaterialsSortedByIdAsc().removeObserver(this);
                        materialAdapter.setMaterials(materials);
                    }
                });
                break;
            case 5:
                vm.getMaterialsSortedByIdDesc().observe(this, new Observer<List<Material>>() {
                    @Override
                    public void onChanged(List<Material> materials) {
                        vm.getMaterialsSortedByIdDesc().removeObserver(this);
                        materialAdapter.setMaterials(materials);
                    }
                });
                break;
            default:
                throw new RuntimeException("Option is invalid !");
        }
    }

    @Override
    protected String[] getOptions() {
        return new String[]{
                "Titlu (A-Z)",
                "Titlu (Z-A)",
                "Timp estimat (Mic-Mare)",
                "Timp estimat (Mare-Mic)",
                "Id (Mic-Mare)",
                "Id (Mare-Mic)"
        };
    }

    @Override
    protected void onFabClick() {
        navController.navigate(MaterialFragmentDirections.actionMaterialeToMaterialModFragment());
    }

    @Override
    protected String getSortKey() {
        return "MATERIALS_SORT";
    }

    @Override
    public void updateOrDelete(Long element, int option) {
        if (option == 0) {
            navController.navigate(MaterialFragmentDirections.actionMaterialeToMaterialModFragment().setMaterialId(element + ""));
        } else {
            vm.deleteMaterialById(element);
        }
    }
}
