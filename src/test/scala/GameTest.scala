import Game.{Move, Player}
import org.scalatest.{FlatSpec, Matchers}


class GameTest extends FlatSpec with Matchers {

	"Rock" should "win against scissors" in {
		val game = new Game(new FixedMoveSelection(Move.SCISSORS))

		val result = game.play(Move.ROCK)

		result shouldBe new Win(Player.HUMAN)
	}

	it should "tie against rock" in {
		val game = new Game(new FixedMoveSelection(Move.ROCK))

		val result = game.play(Move.ROCK)

		result shouldBe new Tie()
	}



}
