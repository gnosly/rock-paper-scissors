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

	it should "lose against paper" in {
		val game = new Game(new FixedMoveSelection(Move.PAPER))

		val result = game.play(Move.ROCK)

		result shouldBe new Win(Player.MACHINE)
	}

	"Scissors" should "win against paper" in {
		val game = new Game(new FixedMoveSelection(Move.PAPER))

		val result = game.play(Move.SCISSORS)

		result shouldBe new Win(Player.HUMAN)
	}

	it should "tie against scissors" in {
		val game = new Game(new FixedMoveSelection(Move.SCISSORS))

		val result = game.play(Move.SCISSORS)

		result shouldBe new Tie()
	}

	it should "lose against rock" in {
		val game = new Game(new FixedMoveSelection(Move.ROCK))

		val result = game.play(Move.SCISSORS)

		result shouldBe new Win(Player.MACHINE)
	}


}
