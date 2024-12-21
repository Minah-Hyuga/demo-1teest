package exam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/projet/views/commande.fxml"));
        AnchorPane root = loader.load();

        // Créer la scène et l'afficher
        Scene scene = new Scene(root);
        primaryStage.setTitle("Gestion des Commandes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
