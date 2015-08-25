package com.senseiwu.osmdata

/**
 * Created by tomek on 8/16/15.
 */

import com.mongodb.casbah.Imports._
import com.senseiwu.osmdata.poi.NearQuery
import com.senseiwu.osmdata.utils._

trait DbBase {

  val client:MongoClient
  val dbName:Option[String]

  def getdb():MongoDB = if(dbName.isDefined) getdb(dbName.get) else throw new RuntimeException("Unknown database name")

  def getdb(name:String):MongoDB = client(name)

  def collection(collection:String):MongoCollection =
    if(dbName.isDefined) client(dbName.get)(collection) else throw new RuntimeException("Unknown database name")

  def collection(dbname:String, collection:String):MongoCollection = client(dbname)(collection)

  //def drop = conn.dropDatabase()

  def findForKey(collectionObject:MongoCollection, key:String, value:String): MongoCursor =
    collectionObject.find(key $eq value)

  def findForType(collectionName:String, typeName:String): MongoCursor =
    findForType(collection(collectionName), typeName)

  def findForType(collectionObject:MongoCollection, typeName:String): MongoCursor =
    findForKey(collectionObject, "type", typeName)

  def findForSubtype(collectionName:String, subtype:String): MongoCursor =
    findForSubtype(collection(collectionName), subtype)

  def findForSubtype(collectionObject:MongoCollection, subtype:String): MongoCursor =
    findForKey(collectionObject, "subtype", subtype)

  def findNear(collectionObject:MongoCollection, query:NearQuery, subtype:String): MongoCursor =
    findNear(collectionObject, subtype, query.loc.lat, query.loc.lon, query.range)

  def findNear(collectionObject:MongoCollection, subtype:String, lat:Double, lon:Double, range:Int): MongoCursor =
    collectionObject.find(
      $and(
        "subtype" $eq subtype, "loc" $near (lat, lon) $maxDistance(range2dist(range))
      )
    )

  def findNear(collectionName:String, subtype:String, lat:Double, lon:Double, range:Int): MongoCursor =
      findNear(collection(collectionName), subtype, lat, lon, range)
}

class Mongo(cl:MongoClient, dbname:Option[String] = None) extends DbBase {
  override val client:MongoClient = cl
  override val dbName: Option[String] = dbname
}

object Mongo {
  def apply():Mongo = new Mongo(MongoClient())
  def apply(host:String):Mongo = new Mongo(MongoClient(host))
  def apply(host:String, port:Int):Mongo = new Mongo(MongoClient(host, port))
  def apply(client:MongoClient):Mongo = new Mongo(client)
  def apply(client:MongoClient, dbName:String):Mongo = new Mongo(client, Some(dbName))
}

