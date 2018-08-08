package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tView1,tView2;
    Spinner spn1,spn2;
    Button btnGo;
    ArrayList<String>aLCategory;
    ArrayAdapter<String>aaSubCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tView1 = findViewById(R.id.tView1);
        tView2 = findViewById(R.id.tView2);
        spn1 = findViewById(R.id.spn1);
        spn2 = findViewById(R.id.spn2);
        btnGo = findViewById(R.id.btnGo);
        aLCategory = new ArrayList<>();
        aaSubCategory = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, aLCategory);
        spn2.setAdapter(aaSubCategory);



        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "";
                if (spn1.getSelectedItemPosition() == 0) {

                    if (spn2.getSelectedItemPosition() == 0) {
                        url = "https://www.rp.edu.sg/";
                    } else if (spn2.getSelectedItemPosition() == 1) {
                        url = "https://www.rp.edu.sg/student-Life";
                    }
                } else if (spn1.getSelectedItemPosition() == 1) {
                    if (spn2.getSelectedItemPosition() == 0) {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    } else if (spn2.getSelectedItemPosition() == 1) {
                    }
                    url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    {
                    }
                    Intent myIntent = new Intent(MainActivity.this, WebViewActivity.class);
                    myIntent.putExtra("url", url);
                    startActivity(myIntent);
                }
                ;
                spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        aLCategory.clear();
                        if (position == 0) {
                            String[] strNumbers = getResources().getStringArray(R.array.SubCategory);
                            aLCategory.addAll(Arrays.asList(strNumbers));
                        } else {
                            String[] strNumbers = getResources().getStringArray(R.array.course);
                            aLCategory.addAll(Arrays.asList(strNumbers));
                        }
                        aaSubCategory.notifyDataSetChanged();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        aaSubCategory.clear();
                        if (position == 0) {
                            String[] strNumbers = getResources().getStringArray(R.array.SubCategory);
                            aaSubCategory.addAll(Arrays.asList(strNumbers));
                            spn1.setSelection(2);
                        } else {
                            String[] strNumbers = getResources().getStringArray(R.array.Category);
                            aaSubCategory.addAll(Arrays.asList(strNumbers));
                            spn1.setSelection(1);
                        }
                        aaSubCategory.notifyDataSetChanged();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });



            }
        });
    }
}