package com.gnosly.domain

import com.gnosly.domain.Game.Move
import org.scalatest.{FlatSpec, Matchers}

class RandomMoveSelectionTest extends FlatSpec with Matchers{

	val moveSelection = new RandomMoveSelection()

	"RandomMoveSelection" should "randomly select scissors, rock or paper" in {

		val nextMove = moveSelection.next()

		nextMove should ( equal(Move.SCISSORS) or
											equal(Move.ROCK) or
											equal(Move.PAPER) )

	}

	it should "have the same probability distribution for all the three choices" in {
		val numberOfMoves = 1000
		val movesMap = (1 to numberOfMoves).
			map(i => moveSelection.next()).
			groupBy(m => m).
			map( m => (m._1, m._2.size.asInstanceOf[Double] / numberOfMoves))

		println(movesMap)
		movesMap.size shouldBe 3
		all(movesMap.values) should be (0.3 +- 0.1)
	}

}
