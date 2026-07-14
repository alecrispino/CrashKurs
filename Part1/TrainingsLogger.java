package Part1;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class TrainingsLogger {
    private List<Training> trainings = new ArrayList<>();
        
    public void hinzufuegen(Training t){
        trainings.add(t);
    }

    public List<Training> nurSparring(){
        return trainings.stream()
                    .filter(t -> t.istSparring())
                    .toList();
    }

    public Integer gesamtMinuten(){
        return trainings.stream()
                    .mapToInt(t -> t.getDauerInMinuten())
                    .sum();
    }

    public Optional<Training> findeNachName(String name){
        return trainings.stream()
                    .filter(t -> t.getName().equals(name))
                    .findFirst();
    }
}    