package kr.co.example.finalteamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RecommendListActivity extends AppCompatActivity {

    private String[] symptoms = {
            "안구건조증", "만성피로 및 식욕부진", "골다공증 방지", "면역력 강화"
    }; //영양제 필요 증상 입력

    private String[] nutrients = {
            "비타민 A", "비타민 B1", "마그네슘", "비타민 D"
    }; //영양소 입력

    private String[][] supplements = {
            {
                    "Nutricost, 비타민 A, 10,000IU, 소프트젤 500정",
                    "Nature's Truth, 고효능 비타민A, 3,000mcg(10,000IU), 빠른 방출 소프트젤 100정",
                    "Nature's Way, 비타민 A, 10,000 IU, 100 소프트젤"
            },
            {
                    "NOW Foods, B-1, 100 ㎎, 100 정",
                    "Nutricost, 비타민B1, 500mcg, 캡슐 120정",
                    "Swanson, B1, 티아민, 100mg, 캡슐 250정"
            },
            {
                    "NOW Foods, 마그네슘 캡슐, 400mg, 베지 캡슐 180정",
                    "Doctor's Best, 고흡수 마그네슘, 100mg, 120정",
                    "Nutricost, 마그네슘 복합체, 레귤러 강도, 250mg, 캡슐 240정"
            },
            {
                    "NOW Foods, 채식주의자용, 건조 비타민D, 1,000IU, 베지 캡슐 120정",
                    "영롱 비건 효모 비타민D",
                    "Nutricost, 비타민D3, 10,000IU, 소프트젤 240정"
            }
    }; //영양제 이름 입력

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_list);

        findViewById(R.id.symptomBtn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(0);
            }
        }); //증상 버튼1 이벤트 선언

        findViewById(R.id.symptomBtn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(1);
            }
        }); //증상 버튼2 이벤트 선언

        findViewById(R.id.symptomBtn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(2);
            }
        }); //증상 버튼3 이벤트 선언

        findViewById(R.id.symptomBtn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(3);
            }
        }); //증상 버튼4 이벤트 선언

        findViewById(R.id.gobackBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendListActivity.this, RecommendViewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void openDetailActivity(int index) {
        Intent intent = new Intent(this, RecommendDetailActivity.class);
        intent.putExtra("nutrient", nutrients[index]);
        intent.putExtra("supplements", supplements[index]);
        startActivity(intent);
    } //입력된 영양소와 영양제 리스트 두번째 화면으로 연결
}