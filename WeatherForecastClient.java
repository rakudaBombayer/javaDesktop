package desktop6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WeatherForecastClient extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new WeatherForecastClient();
    }

    JTextArea textArea = new JTextArea(5, 20);
    JButton button = new JButton("予報を取得する");

    WeatherForecastClient() {
        setTitle("天気予報受信クライアント");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane);
        getContentPane().add(BorderLayout.SOUTH, button);

        button.addActionListener(this);

        setSize(350, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // try-with-resourcesを使用してリソースリークを防止
        try (Socket socket = new Socket("127.0.0.1", 5000);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {

            String weather = reader.readLine();
            textArea.append("サーバーから受け取った予報 [" + weather + "]\r\n");

        } catch (IOException e) {
            System.out.println("エラーが発生しました: " + e.getMessage());
        }
    }
}
