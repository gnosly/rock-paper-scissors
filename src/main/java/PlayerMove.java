
public class PlayerMove {
    private final Game.Player player;
    private final Game.Move move;

    public PlayerMove(Game.Player player, Game.Move move) {
        this.player = player;
        this.move = move;
    }

    public Result vs(PlayerMove otherPlayerMove) {

        if (move == otherPlayerMove.move) {
            return new Tie();
        }


        if (move == Game.Move.ROCK && otherPlayerMove.move == Game.Move.SCISSORS ||
                move == Game.Move.PAPER && otherPlayerMove.move == Game.Move.ROCK ||
                move == Game.Move.SCISSORS && otherPlayerMove.move == Game.Move.PAPER) {
            return new Win(player);
        }

        return new Win(otherPlayerMove.player);
    }
}
