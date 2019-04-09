package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.DirEntry
import com.rtjvm.scala.oop.filesystem.State

class Ls extends Command {
  override def apply(state: State): State = {
    val contents = state.wd.contents
    val niceOutput = createNiceoutput(contents)
    state.setMessage(niceOutput)
  }

  def createNiceoutput(contents: List[DirEntry]): String = {
    if(contents.isEmpty) ""
    else {
      val entry = contents.head
      entry.name + "[" + entry.getType + "]"+ "\n" + createNiceoutput(contents.tail)
    }
  }

}
