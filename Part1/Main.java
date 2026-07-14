package Part1;

import java.util.Optional;

public class Main{
    public static void main(String[] args) {
        Training t1 = new Training("Sparring", 45, true);
        Training t2 = new Training("Padwork", 60, false);
        Training t3 = new Training("Sparring", 30, true);
        try{
            Training t4 = new Training("Condition", 0, false);
            System.out.println(t4.getName());
        } catch (IllegalArgumentException iae){
            System.out.println("Ein Training darf nur eine positive Anzahl an Minuten haben!");
        }
        
        System.out.println(t1.getName());
        System.out.println(t2.getDauerInMinuten());
        System.out.println(t3.istSparring());

        System.out.println();

        TrainingsLogger trainingsLogger = new TrainingsLogger();
        trainingsLogger.hinzufuegen(t1);
        trainingsLogger.hinzufuegen(t2);
        trainingsLogger.hinzufuegen(t3);

        for(Training training : trainingsLogger.nurSparring()){
            System.out.println(training);
        }

        System.out.println(trainingsLogger.nurSparring());

        System.out.println("Gesamte Trainingsdauer: " + trainingsLogger.gesamtMinuten());

        Optional<Training> optionalTraining1 = trainingsLogger.findeNachName("Sparring");
        Optional<Training> optionalTraining2 = trainingsLogger.findeNachName("Alessandro");

        System.out.println(optionalTraining1.map(t -> t.toString()).orElse("Kein Training gefunden"));
        System.out.println(optionalTraining2.map(t -> t.toString()).orElse("Kein Training gefunden"));
    }

}