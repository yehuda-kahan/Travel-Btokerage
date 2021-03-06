package com.example.travelbrokerage.data.models;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class HistoryDataSource implements IHistoryDataSource {

    private final TravelDao travelDao;

    public HistoryDataSource(Context context) {
        RoomDataSource database = RoomDataSource.getInstance(context);
        travelDao = database.getTravelDao();
    }

    public LiveData<List<Travel>> getTravels() {
        return travelDao.getAll();
    }

    public LiveData<Travel> getTravel(String id) {
        return travelDao.get(id);
    }

    public void addTravel(Travel p) {
        travelDao.insert(p);
    }

    public void updateTravel(Travel p) {
        travelDao.update(p);
    }

    public void deleteTravel(Travel p) {
        travelDao.delete(p);
    }

    public void clearTable() {
        travelDao.clear();
    }

    @Override
    public LiveData<List<Travel>> loadData() {
        return travelDao.getAll();
    }

    public void addTravel(List<Travel> travelList) {
        travelDao.insert(travelList);
    }
}



