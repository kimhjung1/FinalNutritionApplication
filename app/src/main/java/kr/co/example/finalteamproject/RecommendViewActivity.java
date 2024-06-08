package kr.co.example.finalteamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecommendViewActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recommend_view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recoMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.homeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendViewActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.informationBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendViewActivity.this, InformationViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.memoBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendViewActivity.this, MemoViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.recommendBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendViewActivity.this, RecommendViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.accountBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendViewActivity.this, AccountViewActivity.class);
                startActivity(intent);
            }
        });

        // 영양제 추천 시작 버튼 클릭 리스너
        findViewById(R.id.startBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendViewActivity.this, RecommendListActivity.class);
                startActivity(intent);
            }
        });
    }
}
