

public class Game {

    public enum Player { HUMAN, MACHINE}
    public enum Move { ROCK, PAPER, SCISSORS}

    private final MoveSelection machineMoveSelection;

    public Game(MoveSelection machineMoveSelection) {
        this.machineMoveSelection = machineMoveSelection;
    }

    public Result play(Move humanChoice){
        PlayerMove machineMove = new PlayerMove(Player.MACHINE, machineMoveSelection.next());
        PlayerMove humanMove = new PlayerMove(Player.HUMAN, humanChoice);

        return machineMove.vs(humanMove);
    }

}
