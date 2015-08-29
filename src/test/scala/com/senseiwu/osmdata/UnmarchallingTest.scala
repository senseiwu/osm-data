package com.senseiwu.osmdata

import com.mongodb.casbah.Imports._
import com.senseiwu.osmdata.osm.NodeScala
import com.senseiwu.osmdata.poi.amenity
import org.scalatest.FunSuite

/**
 * Created by tomek on 8/26/15.
 */
class UnmarchallingTest extends FunSuite {

  test("Test basic oms file parsing, all empty nodes are filtered out") {
    assert(3  == osm.allNodesWithTags("src/test/resources/nodesNtags.osm").size)
    assert(16 == osm.allNodesWithTags("src/test/resources/UT-amenity1.osm").size)
  }

  test("Parsing osm file, check tags size") {
    osm.allNodesWithTags("src/test/resources/nodesNtags.osm").foreach(_.asScala match {
      case NodeScala(2,_,_,_,_,_,_,_,_,tags) => assert(1 == tags.size)
      case NodeScala(3,_,_,_,_,_,_,_,_,tags) => assert(2 == tags.size)
      case NodeScala(4,_,_,_,_,_,_,_,_,tags) => assert(3 == tags.size)
      case _ => fail()
    })
  }

  test("Parse osm file and build amenity list for subtype") {
    val tosm = osm.allNodesWithTags("src/test/resources/UT-amenity1.osm")
    assert(2 == osm.filterAmenityForSubtype(amenity.ValPharmacy, tosm).size)
    assert(2 == osm.filterAmenityForSubtype(amenity.ValRestaurant, tosm).size)
    assert(2 == osm.filterAmenityForSubtype(amenity.ValAtm, tosm).size)
    assert(1 == osm.filterAmenityForSubtype(amenity.ValCafe, tosm).size)
    assert(1 == osm.filterAmenityForSubtype(amenity.ValFastFood, tosm).size)
    assert(1 == osm.filterAmenityForSubtype(amenity.ValPub, tosm).size)
    assert(1 == osm.filterAmenityForSubtype(amenity.ValTheatre, tosm).size)
  }

}
