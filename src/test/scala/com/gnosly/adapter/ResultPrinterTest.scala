package com.gnosly.adapter

import java.util.Optional

import com.gnosly.domain.Game.Player._
import com.gnosly.domain.Move._
import com.gnosly.domain.{Tie, Win}
import org.scalatest.{FlatSpec, Matchers}

class ResultPrinterTest extends FlatSpec with Matchers {

	val resultPrinter = new ResultPrinter

	"ResultPrinter" should "print tie if tie" in {

		val output = resultPrinter.print(new Tie(PAPER))

		output shouldBe Optional.of("Tie with PAPER\n")
	}

	"ResultPrinter" should "print you win if human win" in {

		val output = resultPrinter.print(new Win(HUMAN.move(PAPER), MACHINE.move(ROCK)))

		output shouldBe Optional.of("You win with PAPER vs ROCK. Very lucky!\n")
	}

	"ResultPrinter" should "print machine wins if machine win" in {

		val output = resultPrinter.print(new Win(MACHINE.move(ROCK), HUMAN.move(SCISSORS)))

		output shouldBe Optional.of("Machine wins with ROCK vs SCISSORS. Try again!\n")
	}

}
