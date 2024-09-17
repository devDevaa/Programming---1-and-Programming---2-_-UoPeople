import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class WeatherApp extends Application {
    private static final String API_KEY = "#####";  // I am using my api key here
    private static final String API_URL = "#####"; // I am using my api url here
    private Label temperatureLabel;
    private Label humidityLabel;
    private Label windSpeedLabel;
    private ImageView weatherIcon;
    private TextArea historyArea;
    private List<String> searchHistory = new ArrayList<>();
    private ComboBox<String> unitComboBox;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weather Information App");

        // Location Input
        TextField locationField = new TextField();
        locationField.setPromptText("Enter city name");

        Button getWeatherButton = new Button("Get Weather");
        getWeatherButton.setOnAction(e -> getWeather(locationField.getText()));

        // Weather Information Display
        temperatureLabel = new Label();
        humidityLabel = new Label();
        windSpeedLabel = new Label();
        weatherIcon = new ImageView();

        // Unit Conversion
        unitComboBox = new ComboBox<>();
        unitComboBox.getItems().addAll("Celsius", "Fahrenheit");
        unitComboBox.setValue("Celsius");

        // History Area
        historyArea = new TextArea();
        historyArea.setEditable(false);

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(locationField, getWeatherButton, unitComboBox, weatherIcon, temperatureLabel, humidityLabel, windSpeedLabel, historyArea);

        Scene scene = new Scene(vbox, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void getWeather(String location) {
        try {
            String urlString = API_URL + location + "&appid=" + API_KEY;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            parseWeatherData(jsonResponse);

            // Track history
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            searchHistory.add(location + " (" + timestamp + ")");
            updateHistory();
        } catch (Exception e) {
            showError("Failed to retrieve weather data. Please check the location.");
        }
    }

    private void parseWeatherData(JSONObject jsonResponse) {
        // Parse and display weather data
        double tempKelvin = jsonResponse.getJSONObject("main").getDouble("temp");
        double temp = unitComboBox.getValue().equals("Celsius") ? tempKelvin - 273.15 : (tempKelvin - 273.15) * 9/5 + 32;
        temperatureLabel.setText("Temperature: " + String.format("%.2f", temp) + " " + unitComboBox.getValue());

        int humidity = jsonResponse.getJSONObject("main").getInt("humidity");
        humidityLabel.setText("Humidity: " + humidity + "%");

        double windSpeed = jsonResponse.getJSONObject("wind").getDouble("speed");
        windSpeedLabel.setText("Wind Speed: " + windSpeed + " m/s");

        String iconCode = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("icon");
        String iconUrl = "http://openweathermap.org/img/w/" + iconCode + ".png";
        weatherIcon.setImage(new Image(iconUrl));
    }

    private void updateHistory() {
        StringBuilder historyText = new StringBuilder("Search History:\n");
        for (String entry : searchHistory) {
            historyText.append(entry).append("\n");
        }
        historyArea.setText(historyText.toString());
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
