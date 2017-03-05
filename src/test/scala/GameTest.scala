import Game.Move
import org.scalatest.{FlatSpec, Matchers}


class GameTest extends FlatSpec with Matchers {

	"Game" should "handle a new match" in {
		 val game = new Game()

			game.play(Move.ROCK)
	}

}
