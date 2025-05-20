package com.example.myapplication.model;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;
public class FavoriteViewModel extends ViewModel {
    private final MutableLiveData<List<Product>> favoriteProducts = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<Product>> getFavorites() {
        return favoriteProducts;
    }

    public void toggleFavorite(Product product) {
        List<Product> currentFavorites = new ArrayList<>(favoriteProducts.getValue());
        if (currentFavorites.contains(product)) {
            currentFavorites.remove(product);
        } else {
            currentFavorites.add(product);
        }
        favoriteProducts.setValue(currentFavorites);
    }

    public boolean isFavorite(Product product) {
        return favoriteProducts.getValue().contains(product);
    }
}
