package com.rtjvm.scala.oop.files

import com.rtjvm.scala.oop.filesystem.FilesystemException

class File(override val parentPath: String, override val name: String, val contents: String)
  extends DirEntry(parentPath, name) {

  def asDirectory: Directory = throw new FilesystemException("File cannot be converted to a directory")

  def getType: String = "File"
  def asFile: File = this
  def isDirectory: Boolean = false
  def isFile: Boolean = true
  def setContents(newContents: String): File = new File(parentPath, name, newContents)
  def appendContents(newContents: String): File = setContents(contents + "\n" + newContents)

}

object File {
  def empty(parentPath: String, name: String): File = new File(parentPath, name, "")
}
