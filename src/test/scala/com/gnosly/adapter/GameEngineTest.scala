package com.gnosly.adapter

import com.gnosly.domain.Game.Move
import com.gnosly.domain.{FixedMoveSelection, Game}
import org.scalatest.{FlatSpec, Matchers}


class GameEngineTest extends FlatSpec with Matchers {

	val question = "Choose your move between paper, scissors, rock or exit:\n"

	val gameEngine = new GameEngine(new Game(new FixedMoveSelection(Move.ROCK)))

	"GameEngine" should "exit on Exit command" in {

		gameEngine.loop(StringInput(List("exit")), new StringOutput)
	}

	it should "alert invalid command" in {
		val output = new StringOutput

		gameEngine.loop(StringInput(List("wrongCommand", "exit")), output)

		output.string shouldBe "Invalid command.\n"
	}

	it should "run a single tie game" in {
		val output = new StringOutput

		gameEngine.loop(StringInput(List("rock", "exit")), output)

		output.string shouldBe "Tie with ROCK\n"
	}

	it should "run a multiple games" in {
		val output = new StringOutput

		gameEngine.loop(StringInput(List("rock", "paper", "exit")), output)

		output.string shouldBe "Tie with ROCK\nYou win with PAPER vs ROCK. Very lucky!\n"
	}

}
