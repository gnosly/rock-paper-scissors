package com.gnosly.domain

import com.gnosly.domain.Move._
import com.gnosly.domain.Player._
import org.scalatest.{FlatSpec, Matchers}


class GameTest extends FlatSpec with Matchers {

	"Rock" should "win against scissors" in {
		val game = new Game(new FixedMoveSelection(SCISSORS))

		val result = game.play(ROCK)

		result shouldBe new Win(HUMAN.move(ROCK), MACHINE.move(SCISSORS))
	}

	it should "tie against rock" in {
		val game = new Game(new FixedMoveSelection(ROCK))

		val result = game.play(ROCK)

		result shouldBe new Tie(ROCK)
	}

	it should "lose against paper" in {
		val game = new Game(new FixedMoveSelection(PAPER))

		val result = game.play(ROCK)

		result shouldBe new Win(MACHINE.move(PAPER), HUMAN.move(ROCK))
	}

	"Scissors" should "win against paper" in {
		val game = new Game(new FixedMoveSelection(PAPER))

		val result = game.play(SCISSORS)

		result shouldBe new Win(HUMAN.move(SCISSORS), MACHINE.move(PAPER))
	}

	it should "tie against scissors" in {
		val game = new Game(new FixedMoveSelection(SCISSORS))

		val result = game.play(SCISSORS)

		result shouldBe new Tie(SCISSORS)
	}

	it should "lose against rock" in {
		val game = new Game(new FixedMoveSelection(ROCK))

		val result = game.play(SCISSORS)

		result shouldBe new Win(MACHINE.move(ROCK), HUMAN.move(SCISSORS))
	}


	"Paper" should "win against rock" in {
		val game = new Game(new FixedMoveSelection(ROCK))

		val result = game.play(PAPER)

		result shouldBe new Win(HUMAN.move(PAPER), MACHINE.move(ROCK))
	}

	it should "tie against paper" in {
		val game = new Game(new FixedMoveSelection(PAPER))

		val result = game.play(PAPER)

		result shouldBe new Tie(PAPER)
	}

	it should "lose against scissors" in {
		val game = new Game(new FixedMoveSelection(SCISSORS))

		val result = game.play(PAPER)

		result shouldBe new Win(MACHINE.move(SCISSORS), HUMAN.move(PAPER))
	}

}
