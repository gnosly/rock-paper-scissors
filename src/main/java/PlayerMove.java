
public class PlayerMove {
    private final Game.Player player;
    private final Game.Move move;

    public PlayerMove(Game.Player player, Game.Move move) {
        this.player = player;
        this.move = move;
    }

    public Result vs(PlayerMove otherPlayerMove) {
        if(move == Game.Move.ROCK && otherPlayerMove.move == Game.Move.SCISSORS){
            return new Win(player);
        }

        return new Win(otherPlayerMove.player);
    }
}
