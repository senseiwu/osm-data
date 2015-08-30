package com.senseiwu.osmdata.poi

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.MongoDBObject

/**
 * Created by tomek on 8/29/15.
 */
object leisure {

  val Key = "leisure"

  val ValPark = "park"

  def park(name:String):MongoDBObject = common.leisureType(ValPark, MongoDBObject("name" -> name))

}
