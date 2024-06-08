package kr.co.example.finalteamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecommendDetailActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_detail);

        TextView tvNutrient = findViewById(R.id.tvNutrient); //영양소 변수 선언
        ListView lvSupplements = findViewById(R.id.lvSupplements); //영양제 리스트 변수 선언
        Button btnBack = findViewById(R.id.backBtn); //돌아가기 버튼 변수 선언

        String nutrient = getIntent().getStringExtra("nutrient"); //영양소 데이터 불러오기
        String[] supplementsArray = getIntent().getStringArrayExtra("supplements"); //영양제 리스트 데이터 불러오기

        tvNutrient.setText(nutrient); //제목에 영양소 이름 띄우기

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, supplementsArray);
        lvSupplements.setAdapter(adapter); //영양제 리스트 리스트 형태로 화면에 띄우기

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 현재 액티비티를 종료하고 이전 액티비티로 돌아갑니다.
            }
        }); //돌아가기 버튼 이벤트 선언

        findViewById(R.id.finishBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendDetailActivity.this, RecommendViewActivity.class);
                startActivity(intent);
            }
        });

    }
}

