package tito.example.com.safe_parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Details extends AppCompatActivity {
 CardView cardView1,cardView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        cardView1=findViewById(R.id.cardview1);
        cardView2=findViewById(R.id.cardview2);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Details.this,GenerateCode.class);
                intent.putExtra("no",1);
                startActivity(intent);
            }
        });
    cardView2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Details.this,GenerateCode.class);
            intent.putExtra("no",2);
            startActivity(intent);

        }
    });
    }
}
