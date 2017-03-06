package com.gnosly.adapter

import java.util.Optional

import com.gnosly.domain.Game.Player
import com.gnosly.domain.{Tie, Win}
import org.scalatest.{FlatSpec, Matchers}

class ResultPrinterTest extends FlatSpec with Matchers {

	val resultPrinter = new ResultPrinter

	"ResultPrinter" should "print tie if tie" in {


		resultPrinter.print(new Tie()) shouldBe Optional.of("Tie")
	}

	"ResultPrinter" should "print you win if human win" in {

		resultPrinter.print(new Win(Player.HUMAN)) shouldBe Optional.of("You win")
	}

	"ResultPrinter" should "print machine wins if machine win" in {

		resultPrinter.print(new Win(Player.MACHINE)) shouldBe Optional.of("Machine wins")
	}

}
