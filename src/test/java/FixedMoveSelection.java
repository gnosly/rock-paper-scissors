
public class FixedMoveSelection implements MoveSelection {

    private Game.Move fixedMove;

    public FixedMoveSelection(Game.Move fixedMove) {
        this.fixedMove = fixedMove;
    }

    public Game.Move next() {
        return fixedMove;
    }
}
