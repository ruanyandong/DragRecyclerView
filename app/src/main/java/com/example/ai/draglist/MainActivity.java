package com.example.ai.draglist;

import android.support.v13.view.DragStartHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.ai.helper.OnStartDragListener;
import com.example.ai.helper.RecyclerListAdapter;
import com.example.ai.helper.SimpleItemTouchHelperCallback;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnStartDragListener{

    private EditText editText;
    private Button button;
    private RecyclerView recyclerView;
    private ItemTouchHelper itemTouchHelper;
    private RecyclerListAdapter adapter;
    private ArrayList<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.add);
        recyclerView = findViewById(R.id.recyclerView);

        adapter = new RecyclerListAdapter(list,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                if (!TextUtils.isEmpty(str)){
                    list.add(str);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }


}
