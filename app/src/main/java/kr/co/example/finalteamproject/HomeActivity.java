package kr.co.example.finalteamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private MedicineDatabaseHelper dbHelper;
    private ListView medicineListView;
    private MedicineAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.medicineMemoMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new MedicineDatabaseHelper(this);
        medicineListView = findViewById(R.id.medicineListView);

        loadMedicines();

        findViewById(R.id.homeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.informationBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, InformationViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.memoBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MemoViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.recommendBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RecommendViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.accountBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AccountViewActivity.class);
                startActivity(intent);
            }
        });
    }

    // 약, 영양제 추가 팝업메뉴 표시 메서드
    public void dropMenu(View button) {
        PopupMenu popup = new PopupMenu(this, button);
        popup.getMenuInflater().inflate(R.menu.home_popup, popup.getMenu());
        popup.setOnMenuItemClickListener(
                item -> {
                    int itemId = item.getItemId();
                    if (itemId == R.id.addMedicineMemo) {
                        Intent intent = new Intent(HomeActivity.this, AddMedicineActivity.class);
                        startActivity(intent);
                        return true;
                    } else if (itemId == R.id.addNutritionMemo) {
                        Intent intent = new Intent(HomeActivity.this, AddNutritionActivity.class);
                        startActivity(intent);
                        return true;
                    }
                    return false;
                }
        );
        popup.show();
    }

    // DB의 모든 약 정보 데이터를 가져와 리스트 형태로 화면에 표시
    private void loadMedicines() {
        List<Medicine> medicines = dbHelper.getAllMedicines();
        adapter = new MedicineAdapter(this, medicines);
        medicineListView.setAdapter(adapter);
    }
}
