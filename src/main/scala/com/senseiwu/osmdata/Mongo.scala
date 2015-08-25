package com.senseiwu.osmdata

/**
 * Created by tomek on 8/16/15.
 */

import com.mongodb.casbah.Imports._
import com.senseiwu.osmdata.poi.{common, substance, amenity}
import com.senseiwu.osmdata.utils._

class Mongo(dbName:String) {
  
  def conn = MongoConnection()(dbName)
  def accessCollection(collection:String) = conn(collection)
  def drop = conn.dropDatabase()

  def findForType(atype:String) =
    accessCollection(atype)

  def findForSubtype(atype:String, subtype:String) =
    accessCollection(atype).find("subtype" $eq subtype)

  def findForSubtypeWithLimit(atype:String, subtype:String, limit:Int) =
    accessCollection(atype).find("subtype" $eq subtype).limit(limit)

  def findNear(atype:String, subtype:String, lat:Double, lon:Double, range:Int) =
    accessCollection(atype).find(
      $and(
        "subtype" $eq subtype, "loc" $near (lat, lon) $maxDistance(range2dist(range))
      )
    )

  def findNearWithLimit(atype:String, subtype:String, lat:Double, lon:Double, range:Int, limit:Int) =
  //accessCollection(atype).find("loc" $near (lat, lon) $maxDistance(range2dist(range))).limit(limit)
    findNear(atype, subtype, lat, lon, range).limit(limit)
}

object Mongo {
  def apply(dbName:String):Mongo = new Mongo(dbName)
}

