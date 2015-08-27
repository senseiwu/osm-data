package com.senseiwu.osmdata

import com.mongodb.casbah.Imports._
import com.senseiwu.osmdata.poi.amenity
import org.scalatest.FunSuite

/**
 * Created by tomek on 8/26/15.
 */
class StorageTest extends FunSuite {
//  val mongo = Mongo(MongoClient(), "poi")
//  val db = mongo.getdb
//  db.dropDatabase()
//  val col = mongo.collection(amenity.Key)
//  col.createIndex(MongoDBObject("loc" -> "2d"))

  test("Read file and store to db, then read it") {
    val l = osm.allNodesWithTags("krkLON50.05-50.059999999999995_LAT19.94000000000001-19.95000000000001.osm")
    println(l.size)
    //println("Bars: " + osm.filterAmenityForSubtype(amenity.ValBar, l))
    //println("Obj: " + osm.buildMongoObject(osm.filterAmenityForSubtype(amenity.ValBar, l)))
    osm.filterAmenityForSubtype(amenity.ValBar, l).foreach(println)
  }

}
