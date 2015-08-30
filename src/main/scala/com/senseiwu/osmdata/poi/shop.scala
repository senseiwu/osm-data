package com.senseiwu.osmdata.poi

import com.mongodb.casbah.Imports._
import com.senseiwu.osmdata.poi.common._

/**
 * Created by tomek on 8/29/15.
 */
object shop {
  val Key = "shop"

  val ValMall = "mall"

  /**
   *      Key:name
    Key:operator
   */

  def mall(name:String) = shopType(shop.ValMall, MongoDBObject("name" -> name))
}
