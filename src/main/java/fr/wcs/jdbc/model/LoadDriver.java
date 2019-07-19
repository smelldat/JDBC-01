package fr.wcs.jdbc.model;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class LoadDriver {
    private static List<String> messages = new ArrayList<>();

        public List<String> executerTests(HttpServletRequest request){
            /* Chargement du driver JDBC pour MySQL */
            try {
                messages.add( "Chargement du driver..." );
                Class.forName( "com.mysql.jdbc.Driver" );
                messages.add( "Driver chargé !" );
            } catch ( ClassNotFoundException e ) {
                messages.add( "Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
                        + e.getMessage() );
            }

            /* Connexion à la base de données */
            String url = "jdbc:mysql://localhost:3306/starwars";
            String utilisateur = "root";
            String motDePasse = "";
            Connection connexion = null;
            Statement statement = null;
            ResultSet resultat = null;
            try {
                messages.add( "Connexion à la base de données..." );
                connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
                messages.add( "Connexion réussie !" );

                /* Création de l'objet gérant les requêtes */
                statement = connexion.createStatement();
                messages.add( "Objet requête créé !" );

                /* Exécution d'une requête de lecture */
                resultat = statement.executeQuery( "SELECT id, name, surname FROM jedi_masters;");
                messages.add( "Requête \"SELECT id, name, surname;\" effectuée !" );

                /* Récupération des données du résultat de la requête de lecture */
                while ( resultat.next() ) {
                    int id = resultat.getInt( "id" );
                    String name = resultat.getString( "name" );
                    String surname = resultat.getString( "surname" );
                    /* Formatage des données pour affichage dans la JSP finale. */
                    messages.add( "Données retournées par la requête : id = " + id + ", name = " + name
                            + ", surname = " + surname + "." );
                }

            } catch ( SQLException e ) {
                messages.add( "Erreur lors de la connexion : <br/>"
                        + e.getMessage() );
            } finally {
                messages.add( "Fermeture de l'objet ResultSet." );
                if ( resultat != null ) {
                    try {
                        resultat.close();
                    } catch ( SQLException ignore ) {
                    }
                }
                messages.add( "Fermeture de l'objet Statement." );
                if ( statement != null ) {
                    try {
                        statement.close();
                    } catch ( SQLException ignore ) {
                    }
                }
                messages.add( "Fermeture de l'objet Connection." );
                if ( connexion != null ) {
                    try {
                        connexion.close();
                    } catch ( SQLException ignore ) {
                    }
                }
            }
            return messages;
        }
    }



