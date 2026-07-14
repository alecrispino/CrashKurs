package Part1;

public class Training {
    private String name;
    private int dauerInMinuten;
    private boolean istSparring;

    public String getName(){
        return this.name;
    }

    public int getDauerInMinuten(){
        return this.dauerInMinuten;
    }

    public boolean istSparring(){
        return this.istSparring;
    }

    Training(String name, int dauerInMinuten, boolean istSparring){
        this.name = name;
        this.istSparring = istSparring;

        if (dauerInMinuten <= 0) {
            throw new IllegalArgumentException("Dauer muss eine positive Zahl sein");
        }
    }

    public String toString(){
        return "Name: " + this.name + " Dauer: " + this.dauerInMinuten + " ist Sparring: " + this.istSparring;
    }
}