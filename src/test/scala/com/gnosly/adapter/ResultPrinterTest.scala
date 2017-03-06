package com.gnosly.adapter

import java.util.Optional

import com.gnosly.domain.Game.Move._
import com.gnosly.domain.Game.Player._
import com.gnosly.domain.{Tie, Win}
import org.scalatest.{FlatSpec, Matchers}

class ResultPrinterTest extends FlatSpec with Matchers {

	val resultPrinter = new ResultPrinter

	val humanPlayPaper = HUMAN.move(PAPER)
	val humanPlayScissors = HUMAN.move(SCISSORS)
	val machinePlayRock = MACHINE.move(ROCK)

	"ResultPrinter" should "print tie if tie" in {

		resultPrinter.print(new Tie(PAPER)) shouldBe Optional.of("Tie")
	}

	"ResultPrinter" should "print you win if human win" in {

		resultPrinter.print(new Win(humanPlayPaper, machinePlayRock)) shouldBe Optional.of("You win")
	}

	"ResultPrinter" should "print machine wins if machine win" in {

		resultPrinter.print(new Win(machinePlayRock, humanPlayScissors)) shouldBe Optional.of("Machine wins")
	}

}
