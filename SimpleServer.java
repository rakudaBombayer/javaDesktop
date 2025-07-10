package desktop6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) {
        // サーバーソケットを明確に閉じるため、外部で定義
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            
            System.out.println("サーバーはポート5000で待機中...");
            
            while (true) {
                // クライアントからの接続を待機
                try (Socket socket = serverSocket.accept();
                     PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                    // メッセージを送信
                    writer.println("こんにちは。私はサーバーです。");

                } catch (IOException e) {
                    System.out.println("クライアントとの通信中にエラーが発生しました: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("サーバーソケット作成中にエラーが発生しました: " + e.getMessage());
        }
    }
}
