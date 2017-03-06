package com.gnosly.adapter

import java.util.Optional

import com.gnosly.domain.Move
import org.scalatest.{FlatSpec, Matchers}


class CommandParserTest extends FlatSpec with Matchers {

	"CommandParser" should "parse rock command" in {
		val commandParser = new CommandParser

		commandParser.parse("rock").get shouldBe Move.ROCK
	}

	it should "parse scissors command" in {
		val commandParser = new CommandParser

		commandParser.parse("scissors").get shouldBe Move.SCISSORS
	}

	it should "parse paper command" in {
		val commandParser = new CommandParser

		commandParser.parse("paper").get shouldBe Move.PAPER
	}

	it should "parse paper command in uppercase" in {
		val commandParser = new CommandParser

		commandParser.parse("PAPER").get shouldBe Move.PAPER
	}


	it should "return empty if command not recognized" in {
		val commandParser = new CommandParser

		commandParser.parse("wrongCommand") shouldBe Optional.empty()
	}
}
