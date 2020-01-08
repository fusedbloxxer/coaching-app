package com.faculty.fusedbloxxer.coachingapp.home.locations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.TableFragment;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Location;

import java.util.List;

public class LocationFragment extends TableFragment<Long> {

    private LocationAdapter mLocationAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.table_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(mLocationAdapter = new LocationAdapter(this));
    }

    @Override
    protected void fetchDataFromDatabase(int i) {
        switch (i) {
            case -1:
                vm.getAllLocations().observe(this, new Observer<List<Location>>() {
                    @Override
                    public void onChanged(List<Location> locations) {
                        vm.getAllLocations().removeObserver(this);
                        mLocationAdapter.setLocationList(locations);
                    }
                });
                break;
            case 0:
                vm.getLocationsSortedByAliasAsc().observe(this, new Observer<List<Location>>() {
                    @Override
                    public void onChanged(List<Location> locations) {
                        vm.getLocationsSortedByAliasAsc().removeObserver(this);
                        mLocationAdapter.setLocationList(locations);
                    }
                });
                break;
            case 1:
                vm.getLocationsSortedByAliasDesc().observe(this, new Observer<List<Location>>() {
                    @Override
                    public void onChanged(List<Location> locations) {
                        vm.getLocationsSortedByAliasDesc().removeObserver(this);
                        mLocationAdapter.setLocationList(locations);
                    }
                });
                break;
            case 2:
                vm.getLocationsSortedByStreetAsc().observe(this, new Observer<List<Location>>() {
                    @Override
                    public void onChanged(List<Location> locations) {
                        vm.getLocationsSortedByStreetAsc().removeObserver(this);
                        mLocationAdapter.setLocationList(locations);
                    }
                });
                break;
            case 3:
                vm.getLocationsSortedByStreetDesc().observe(this, new Observer<List<Location>>() {
                    @Override
                    public void onChanged(List<Location> locations) {
                        vm.getLocationsSortedByStreetDesc().removeObserver(this);
                        mLocationAdapter.setLocationList(locations);
                    }
                });
                break;
            case 4:
                vm.getLocationsSortedByIdAsc().observe(this, new Observer<List<Location>>() {
                    @Override
                    public void onChanged(List<Location> locations) {
                        vm.getLocationsSortedByIdAsc().removeObserver(this);
                        mLocationAdapter.setLocationList(locations);
                    }
                });
                break;
            case 5:
                vm.getLocationsSortedByIdDesc().observe(this, new Observer<List<Location>>() {
                    @Override
                    public void onChanged(List<Location> locations) {
                        vm.getLocationsSortedByIdDesc().removeObserver(this);
                        mLocationAdapter.setLocationList(locations);
                    }
                });
                break;
            default:
                throw new RuntimeException("Selected option is not available.");
        }
    }

    @Override
    protected String[] getOptions() {
        return new String[]{
                "Denumire (A-Z)",
                "Denumire (Z-A)",
                "Strada (A-Z)",
                "Strada (Z-A)",
                "Id (Mic-Mare)",
                "Id (Mare-Mic)"
        };
    }

    @Override
    protected void onFabClick() {
        navController.navigate(LocationFragmentDirections.actionLocatiiToLocationModFragment());
    }

    @Override
    protected String getSortKey() {
        return "LOCATIONS_SORT";
    }

    @Override
    public void updateOrDelete(Long element, int option) {
        if (option == 0) {
            navController.navigate(LocationFragmentDirections.actionLocatiiToLocationModFragment().setLocationId(String.valueOf(element)));
        } else {
            vm.deleteLocationById(element);
        }
    }
}
