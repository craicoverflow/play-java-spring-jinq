package services;

import models.Bar;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

@Named
@Singleton
public interface BarService {
    void addBar(Bar bar);
    List<Bar> getAllBars();
    
}