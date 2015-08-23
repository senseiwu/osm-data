package com.senseiwu.osmdata

/**
 * Created by tomek on 8/16/15.
 */

import com.mongodb.casbah.Imports._
import com.senseiwu.osmdata.poi.{common, substance, amenity}


object mongo {
  def conn = MongoConnection()("poi")
  def accessCollection(collection:String) = conn(collection)
  def drop = conn.dropDatabase()

  def convert(range:Int):Double = ???

  def findForType(atype:String) = ???

  def findForSubtype(atype:String, subtype:String) =
    accessCollection(atype).find("subtype" eq subtype)

  def findForSubtypeWithLimit(atype:String, subtype:String, limit:Int) =
    accessCollection(atype).find("subtype" eq subtype).limit(limit)

  def findNear(atype:String, subtype:String, lat:Double, lon:Double, range:Int) =
    accessCollection(atype).find("loc" $near (lat, lon) $maxDistance(convert(range)))

  def findNearWithLimit(atype:String, subtype:String, lat:Double, lon:Double, range:Int, limit:Int) =
    accessCollection(atype).find("loc" $near (lat, lon) $maxDistance(convert(range))).limit(limit)

}

