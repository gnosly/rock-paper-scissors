package com.gnosly.adapter


class StringOutput extends Output {
	var string = ""

	override def write(string: String): Unit = this.string += string;
}

object StringOutput {
	def apply: StringOutput = new StringOutput()
}
