package com.senseiwu.osmdata.poi

import com.mongodb.casbah.Imports._

/**
 * Created by tomek on 8/29/15.
 */
object historic {
  val Key = "historic"

  val ValMuseum = " museum"

  def museum(name:String):MongoDBObject = common.historicType(ValMuseum, MongoDBObject("name" -> name))
}
