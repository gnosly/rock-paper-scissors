package com.gnosly.domain


class FixedMoveSelection(fixedMove: Move) extends MoveSelection {
	override def next(): Move = fixedMove
}
