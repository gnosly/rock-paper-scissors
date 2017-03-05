import Game.{Move, Player}
import org.scalatest.{FlatSpec, Matchers}


class GameTest extends FlatSpec with Matchers {

	"Rock" should "win over scissors" in {
		val game = new Game(new FixedMoveSelection(Move.SCISSORS))

		val winner = game.play(Move.ROCK)

		winner shouldBe Player.HUMAN
	}



}
