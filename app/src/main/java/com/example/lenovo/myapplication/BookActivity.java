package com.example.lenovo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {

    private EditText editText;

    private List<Book> bookList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initBooks();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final BookAdapter adapter =  new BookAdapter(bookList);
        recyclerView.setAdapter(adapter);
        editText = (EditText)findViewById(R.id.input_message);
        Button button = (Button) findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputBookName = editText.getText().toString();
                Book book = new Book(inputBookName);
                bookList.add(0,book);
                adapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(0);
            }
        });
    }
    private void initBooks(){
        Book Chinese = new Book("Chinese");
        bookList.add(Chinese);
        Book math = new Book("math");
        bookList.add(math);
        Book English = new Book("English");
        bookList.add(English);
        Book physics = new Book("physics");
        bookList.add(physics);
        Book chemistry = new Book("chemistry");
        bookList.add(chemistry);
        Book biology = new Book("biology");
        bookList.add(biology);
        Book geography = new Book("geography");
        bookList.add(geography);
        Book history = new Book("history");
        bookList.add(history);
        Book dictionary = new Book("dictionary");
        bookList.add(dictionary);
        Book Frog = new Book("Frog");
        bookList.add(Frog);


    }
}
