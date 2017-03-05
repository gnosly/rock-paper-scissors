

public class Game {

    public enum Winner { HUMAN, MACHINE}
    public enum Move { ROCK, PAPER, SCISSORS}

    public Winner play(Move humanChoice){
        return Winner.HUMAN;
    }

}
