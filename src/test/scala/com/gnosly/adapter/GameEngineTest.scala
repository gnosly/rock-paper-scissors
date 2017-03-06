package com.gnosly.adapter

import java.util.Optional

import com.gnosly.domain.Game.Move
import com.gnosly.domain.{FixedMoveSelection, Game}
import org.scalatest.{FlatSpec, Matchers}


class GameEngineTest extends FlatSpec with Matchers {

	val gameEngine = new GameEngine(new Game(new FixedMoveSelection(Move.ROCK)))


	"GameEngine" should "exit on Exit command" in {

		gameEngine.loop("exit") shouldBe Optional.empty()
	}

	it should "alert invalid command" in {

		gameEngine.loop("wrongCommand") shouldBe Optional.of("Invalid command.")
	}

	it should "run a single tie game" in {

		gameEngine.loop("rock") shouldBe Optional.of("Tie")
	}

}
