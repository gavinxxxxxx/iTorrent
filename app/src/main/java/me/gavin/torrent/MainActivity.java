package me.gavin.torrent;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;

import me.gavin.torrent.parser2.Torrent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test();
    }

    private void test() {
        // \torrent\【rarbt中文站】【rarbt.com】奇幻森林.The.Jungle.Book.2016.HDTS1080P.国语内录.rarbt.torrent
        // \torrent\796M（JAVA高级）java2.torrent

//        Client client = new Client(InetAddress.getLocalHost(), SharedTorrent.fromFile());
//
//        client.download();

        File file = new File(Environment.getExternalStorageDirectory() + "/torrent/796M（JAVA高级）java2.torrent");
        File file1 = new File(Environment.getExternalStorageDirectory() + "/torrent/【rarbt中文站】【rarbt.com】奇幻森林.The.Jungle.Book.2016.HDTS1080P.国语内录.rarbt.torrent");

        new Thread(r).start();

        try {
            Torrent.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            File file = new File(Environment.getExternalStorageDirectory() + "/torrent/796M（JAVA高级）java2.torrent");
            try {
                Client client = new Client(
                        InetAddress.getLocalHost(),
                        SharedTorrent.fromFile(file, new File(Environment.getExternalStorageDirectory() + "/torrent/output/")));
                client.setMaxDownloadRate(50.0);
                client.setMaxUploadRate(50.0);
                client.download();
            } catch (IOException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    };

}
