package kr.co.example.finalteamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MemoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_memo_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.memoMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.homeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoViewActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.informationBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoViewActivity.this, InformationViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.memoBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoViewActivity.this, MemoViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.recommendBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoViewActivity.this, RecommendViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.accountBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoViewActivity.this, AccountViewActivity.class);
                startActivity(intent);
            }
        });
    }

    public void dropMenu(View button) {
        PopupMenu popup = new PopupMenu(this, button);
        popup.getMenuInflater().inflate(R.menu.memo_popup, popup.getMenu());
        popup.setOnMenuItemClickListener(
                item -> {
                    int itemId = item.getItemId();
                    if (itemId == R.id.addMedicineMemo) {
                        Intent intent = new Intent(MemoViewActivity.this, MedicineMemoActivity.class);
                        startActivity(intent);
                        return true;
                    } else if (itemId == R.id.addNutritionMemo) {
                        Intent intent = new Intent(MemoViewActivity.this, NutritionMemoActivity.class);
                        startActivity(intent);
                        return true;
                    }
                    return false;
                }
        );
        popup.show();
    }
}