package com.example.myapplication;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.fragment.CartFragment;
import com.example.myapplication.fragment.FavoriteFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {

    public static ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home){
                LoadFragment(new HomeFragment());
            }
            else if (itemId == R.id.nav_favorit){
                LoadFragment(new FavoriteFragment());
            }
            else if (itemId == R.id.nav_search){
                LoadFragment(new SearchFragment());
            }
            else if (itemId == R.id.nav_cart){
                LoadFragment(new CartFragment());
            }
            else {
                return false;
            }
            return true;


        });
       binding.bottomNavigation.setSelectedItemId(R.id.nav_home);


    }

    private void LoadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container ,fragment)
                .commit();
    }
}