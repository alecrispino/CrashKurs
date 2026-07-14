package Part1;

import java.util.Optional;

public class Main{
    public static void main(String[] args) {
        Training t1 = new Training("Hans", 45, true);
        Training t2 = new Training("Peter", 60, false);
        Training t3 = new Training("Franz", 30, true);
        try{
            Training t4 = new Training("Karl", -10, false);
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
            System.out.println(training.print());
        }

        System.out.println(trainingsLogger.nurSparring());

        System.out.println("Gesamte Trainingsdauer: " + trainingsLogger.gesamtMinuten());

        Optional<Training> optionalTraining1 = trainingsLogger.findeNachName("Hans");
        Optional<Training> optionalTraining2 = trainingsLogger.findeNachName("Alessandro");
        System.out.println(optionalTraining1);
        System.out.println(optionalTraining2);

    }

}