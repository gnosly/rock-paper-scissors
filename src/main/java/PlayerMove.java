
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

        return move.winAgainst(otherPlayerMove.move) ? new Win(player) : new Win(otherPlayerMove.player);
    }
}
