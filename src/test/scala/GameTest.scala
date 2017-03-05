import Game.{Move, Winner}
import org.scalatest.{FlatSpec, Matchers}


class GameTest extends FlatSpec with Matchers {

	"Game" should "handle a new match" in {
		 val game = new Game()

			val winner = game.play(Move.ROCK)

			winner should (equal(Winner.HUMAN ) or equal(Winner.MACHINE))
	}

}
