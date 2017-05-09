package com.senseiwu.osmdata

/**
 * Created by tomek on 8/16/15.
 */

import java.io.{FileInputStream}

import com.mongodb.casbah.Imports._
import com.senseiwu.osmdata.poi.{amenity, common, substance}
import com.senseiwu.osmdata.serializer.{Node, Osm, xstream}

object osm {

  val STEP:Double = 0.01
  val STEPINT:Int = 1

  def fun2(minlat:Int,maxlat:Int,minlon:Int,maxlon:Int) = {
    def loop(mminlat:Int,mmaxlat:Int,mminlon:Int,mmaxlon:Int):Unit = {
      if(mmaxlat>maxlat && mmaxlon>maxlon) return
      println("-- osm data get ", mminlat, mmaxlat, mminlon, mmaxlon)
      if(mmaxlon <= maxlon) loop(mminlat,mmaxlat,mminlon+STEPINT,mmaxlon+STEPINT)
      else loop(mminlat+STEPINT,mmaxlat+STEPINT,minlon,minlon+STEPINT)
    }
    loop(minlat, minlat+STEPINT, minlon, minlon+STEPINT)
  }

  def downloadOsm(path:String, fileNamePrefix:String, minlat:Double, maxlat:Double, minlon:Double, maxlon:Double):Unit = {
    import sys.process._
    def loop(name:String, mminlat:Double,mmaxlat:Double,mminlon:Double,mmaxlon:Double):Unit = {
      val namegoo = name + "LON" + mminlat+"-"+mmaxlat+"_LAT"+mminlon+"-"+mmaxlon
      "wget -O %s.osm http://api.openstreetmap.org/api/0.6/map?bbox=%s,%s,%s,%s".format(namegoo, mminlon, mminlat, mmaxlon, mmaxlat).!
      // TODO write to getdb here
      if(mmaxlat>maxlat && mmaxlon>maxlon) return
      if(mmaxlon <= maxlon) loop(name, mminlat,mmaxlat,mminlon+STEP,mmaxlon+STEP)
      else loop(name, mminlat+STEP,mmaxlat+STEP,minlon,minlon+STEP)
    }
    loop(path.concat(fileNamePrefix), minlat, minlat+STEP, minlon, minlon+STEP)
  }

  def allNodesWithTags(file:String):List[Node] = {
    import scala.collection.JavaConversions._
    xstream.fromXML(new FileInputStream(file)).nodes.toList.filter(_.tags != null)
  }

  def filterAmenity(nodes:List[Node]):List[Node] = {
    import scala.collection.JavaConversions._
    for (node <- nodes; tag <- node.tags if tag.k.equals(amenity.Key)) yield node
  }

  def filterAmenityForSubtype(subtype:String, nodes:List[Node]):List[Node] = {
    import scala.collection.JavaConversions._
    for (node <- nodes; tag <- node.tags if tag.k.equals(amenity.Key) && tag.v.equals(subtype)) yield node
  }

  def filterNodes(nodeType:String, nodeSubtype:String, nodes:List[Node]):List[Node] = {
    import scala.collection.JavaConversions._
    for (node <- nodes; tag <- node.tags if tag.k.equals(nodeType) && tag.v.equals(nodeSubtype)) yield node
  }

  def filterNodes(nodeType:String, nodes:List[Node]):List[Node] = {
    import scala.collection.JavaConversions._
    for (node <- nodes; tag <- node.tags if tag.k.equals(nodeType)) yield node
  }

  def getSubtypeObj(subtype:String, name:String):MongoDBObject = subtype match {
    case amenity.ValBar => substance.bar(name)
  }

  def buildMongoObject(nodes:List[Node]):List[MongoDBObject] = {
    for (
      node <- nodes;
      tag1 <- node.asScala.tags if tag1.k.equals("name")
    ) yield common.node(node.asScala.lat.toDouble, node.asScala.lon.toDouble, substance.bar(tag1.v))
  }
}

object SzPoi extends App {
  osm.downloadOsm("/home/tomek/tmp/data/", "sz_", 22.49, 22.55, 113.90, 113.96)
}

object Applic extends App {
  import scala.collection.JavaConversions._
  val d:Osm = xstream.fromXML(new FileInputStream("sz_LON22.5-22.51_LAT113.94000000000003-113.95000000000003.osm"))
  val filtered = d.nodes.toList.filter(_.tags != null)
  val a = for (
    f <- filtered;
    t <- f.tags
    if t.k.equals("taxi")
  ) yield f
  println(d.nodes.size() + " >> " + filtered.size + " >> " + a.size)

  val am_bar = for (
    aa <- a;
    tt <- aa.tags
    if tt.k.equals("amenity") && tt.v.equals("bar")
  ) yield aa

  println("Bars: " + am_bar.size)

  am_bar.foreach(println)

}



