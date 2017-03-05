

public class Game {

    public enum Player { HUMAN, MACHINE}
    public enum Move { ROCK, PAPER, SCISSORS}

    private MoveSelection moveSelection;

    public Game(MoveSelection moveSelection) {
        this.moveSelection = moveSelection;
    }

    public Player play(Move humanChoice){
        Move machineMove = moveSelection.next();

        if(machineMove == Move.ROCK && humanChoice == Move.SCISSORS){
            return Player.MACHINE;
        }

        return Player.HUMAN;
    }

}
