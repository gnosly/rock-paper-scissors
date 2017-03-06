package com.gnosly.adapter


class StringOutput extends Output {
	var string = ""

	override def writeResult(string: String): Unit = this.string += string;

	override def writeQuestion(string: String): Unit = {}
}

object StringOutput {
	def apply: StringOutput = new StringOutput()
}
