package tito.example.com.safe_parking;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.scheme.VCard;

import tito.example.com.safe_parking.Helper.Common;

public class GenerateCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_code);
        ImageView myImage=(ImageView) findViewById(R.id.imageView);

        VCard abhay=new VCard(Common.user)
                .setEmail(Common.email)
                .setAddress("India")
                .setTitle("Demo user"+Common.user)
                .setCompany("Rajasthan Hackathon");
        Bitmap myBitmap= QRCode.from(abhay).bitmap();
        myImage.setImageBitmap(myBitmap);}
}
