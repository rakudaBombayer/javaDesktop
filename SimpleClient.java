package desktop6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) {
        // サーバーに接続してメッセージを受信
        try (Socket socket = new Socket("127.0.0.1", 5000);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {

            String message = reader.readLine();
            System.out.println("サーバーから受け取った文字列: " + message);

        } catch (IOException e) {
            System.out.println("エラーが発生しました: " + e.getMessage());
        }
    }
}
