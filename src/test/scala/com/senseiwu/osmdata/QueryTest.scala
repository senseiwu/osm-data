package com.senseiwu.osmdata

import com.mongodb.casbah.Imports._
import com.senseiwu.osmdata.poi.{amenity, common, substance}
import org.scalatest.FunSuite

/**
 * Created by tomek on 8/25/15.
 */
class QueryTest extends FunSuite {

  val mongo = Mongo(MongoClient(), "poi")
  val db = mongo.getdb
  db.dropDatabase()
  val col = mongo.collection(amenity.Key)
  col.createIndex(MongoDBObject("loc" -> "2d"))

  val point1 =
    common.node(
      50.01, 19.7234,
      common.address(123, "", "Brozka", "Krakow", "Poland", ""),
      substance.bar("A"))

  val point2 =
    common.node(
      50.02, 19.7234,
      common.address(234, "", "A", "Krakow", "Poland", ""),
      substance.bbq("",""))

  val point3 =
    common.node(
      50.03, 19.7234,
      common.address(345, "", "B", "Krakow", "Poland", ""),
      substance.bar("C"))

  val point4 =
    common.node(
      50.04, 19.7234,
      common.address(567, "", "C", "Chicago", "USA", ""),
      substance.restaurant("Sun"))

  col += point1
  col += point2
  col += point3
  col += point4

  test("Check amenity type query") {
    assert(4 == col.size)
    assert(4 == mongo.findForType(col, amenity.Key).size)
    assert(2 == mongo.findForSubtype(amenity.Key, amenity.ValBar).length)
    assert(1 == mongo.findForSubtype(amenity.Key, amenity.ValRestaurant).length)
    assert(1 == mongo.findForSubtype(amenity.Key, amenity.ValBbq).length)
    assert(0 == mongo.findForSubtype(amenity.Key, amenity.ValBrothel).length)
  }

  test("Check distance search") {
    assert(1 == mongo.findNear(amenity.Key, amenity.ValBar, 50.005, 19.7234, 1000).length, "Bar not found")
    assert(0 == mongo.findNear(amenity.Key, amenity.ValBbq, 50.005, 19.7234, 1000).length, "BBQ found")
    assert(2 == mongo.findNear(amenity.Key, amenity.ValBar, 50.005, 19.7234, 4000).length, "Bar not found")
    assert(1 == mongo.findNear(amenity.Key, amenity.ValBbq, 50.005, 19.7234, 4000).length, "BBQ not found")
  }

}
