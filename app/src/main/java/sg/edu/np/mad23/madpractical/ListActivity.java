package sg.edu.np.mad23.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private static final String TAG = "ListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayList<User> userlist = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            User user1 = createUser();
            userlist.add(user1);
            Log.i(TAG, "1");
        }

        RecyclerView recyclerView = findViewById(R.id.recycler);
        Adapter mAdapter = new Adapter(ListActivity.this, userlist);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
    private int randomOTP(){
        Random ran = new Random();
        int value = ran.nextInt(999999999);
        return value;
    }
    private User createUser(){
        User user1 = new User();
        int ran1 = randomOTP();
        int ran2 = randomOTP();
        user1.Name = "Name" + ran1;
        user1.Followed = false;
        user1.Description = "Description " + ran2;
        return user1;
    }
}