package Part1;

public class Training {
    private String name;
    private Integer dauerInMinuten;
    private Boolean istSparring;

    public String getName(){
        return this.name;
    }

    public Integer getDauerInMinuten(){
        return this.dauerInMinuten;
    }

    public Boolean istSparring(){
        return this.istSparring;
    }

    Training(String name, Integer dauerInMinuten, Boolean istSparring){
        this.name = name;
        this.istSparring = istSparring;

        if (dauerInMinuten >= 0) {
            this.dauerInMinuten = dauerInMinuten;
        }else{
            throw new IllegalArgumentException("Dauer muss eine positive Zahl sein");
        }
    }

    public String print(){
        return "Name: " + this.name + " Dauer: " + this.dauerInMinuten + " ist Sparring: " + this.istSparring;
    }
}