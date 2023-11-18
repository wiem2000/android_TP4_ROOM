
# Bus Schedule Application

## Objectif
- L'objectif de ce TP est de réaliser une application simple qui affiche les heures d'arrivée d'une ligne de bus à partir d'une base de données préremplie. Dans un premier temps, les heures d'arrivée seront présentées dans un composant RecyclerView. Dans un second temps, l'application affichera les heures d'arrivée spécifiques de la station sélectionnée.

## Dépendances ROOM
- Suivre la documentation officielle [Room](https://developer.android.com/training/data-storage/room?hl=fr)

## Entité de la base de données
- Créer une entité pour la table "schedule" avec id, stop_name, arrival_time.

## DAO
- Créer une interface DAO avec les méthodes getAll() et getByStopName(stopName).

## Base de données et préremplissage
- Créer la classe AppDatabase avec une unique table "schedule".
- Ajouter une base de données préremplie depuis le dossier "assets" du projet.

## ViewModel
- Créer la classe BusScheduleViewModel pour gérer les données liées à l'UI. Utiliser la classe ViewModelProvider.Factory pour instancier le ViewModel.

## Adaptateur RecyclerView
- Créer la classe BusStopAdapter pour mettre en place l'adaptateur pour la RecyclerView.

## Affichage des données
- Configurer la vue RecyclerView dans MainActivity.kt.
- Utiliser un thread pour récupérer les données de la base de données.


## Réagir aux modifications de données avec LiveData
- Modifier les fonctions DAO pour renvoyer des LiveData.
- Observer les résultats dans l'adaptateur pour gérer les mises à jour en temps réel.

## Démo

https://github.com/wiem2000/android_TP4_ROOM/assets/96753615/c125d2c5-a1b4-423b-90bd-736a3f345f83


