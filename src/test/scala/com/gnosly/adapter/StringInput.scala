package com.gnosly.adapter


class StringInput(inputs: List[String]) extends Input {
	var innerInputs = inputs

	override def read(): String = innerInputs match {
		case List() => ""
		case head :: tail => innerInputs = tail; head
	}
}

object StringInput {
	def apply(inputs: List[String]): StringInput = new StringInput(inputs)
}