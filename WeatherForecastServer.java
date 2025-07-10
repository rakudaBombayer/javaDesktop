package desktop6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WeatherForecastServer {

    // 天気の選択肢
    static String[] weathers = {
        "晴れ", "曇り", "雨", "晴れのち曇り", "晴れのち雨", "曇りのち晴れ"
    };

    public static void main(String[] args) {
        // try-with-resourcesを使用してServerSocketを管理
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("天気予報サーバーがポート5000で待機中...");
            
            while (true) {
                // クライアントからの接続を待機
                try (Socket socket = serverSocket.accept();
                     PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                    // 天気予報を送信
                    String weather = getWeatherForecast();
                    writer.println(weather);

                    // サーバー側に送信済みメッセージを表示
                    System.out.println("[" + weather + "]の予報を送りました。");
                } catch (IOException e) {
                    System.out.println("クライアントとの通信中にエラーが発生しました: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("サーバーソケット作成中にエラーが発生しました: " + e.getMessage());
        }
    }

    // ランダムな天気予報を返すメソッド
    private static String getWeatherForecast() {
        int index = (int) (Math.random() * weathers.length);
        return weathers[index];
    }
}
