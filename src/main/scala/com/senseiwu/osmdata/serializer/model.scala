package com.senseiwu.osmdata.serializer

import java.util

/**
  * Created by tomek on 5/9/17.
  */

case class Osm(
                version: String,
                generator: String,
                copyright: String,
                attribution: String,
                license: String,
                bounds: Bounds,
                nodes: util.ArrayList[Node],
                ways: util.ArrayList[Way],
                relations: util.ArrayList[Relation]
              )

case class Bounds(
                   minlat: String,
                   minlon: String,
                   maxlat: String,
                   maxlon: String)

case class Node(
                 id: Long,
                 visible: String,
                 version: String,
                 changeset: String,
                 timestamp: String,
                 user: String,
                 uid: String,
                 lat: String,
                 lon: String,
                 tags: util.ArrayList[Tag]) {

  import scala.collection.JavaConversions._

  def asScala = NodeScala(id, visible, version, changeset, timestamp, user, uid, lat, lon, tags.toList)
}

case class NodeScala(
                      id: Long,
                      visible: String,
                      version: String,
                      changeset: String,
                      timestamp: String,
                      user: String,
                      uid: String,
                      lat: String,
                      lon: String,
                      tags: List[Tag])

case class Tag(
                k: String,
                v: String)

case class Way(
                id: Long,
                visible: Boolean,
                version: Int,
                changeset: Int,
                timestamp: String,
                user: String,
                uid: Int,
                nds: util.ArrayList[Nd],
                tags: util.ArrayList[Tag])

case class Nd(
               ref: String)

case class Relation(
                     id: Long,
                     visible: Boolean,
                     version: Int,
                     changeset: Int,
                     timestamp: String,
                     user: String,
                     uid: Int,
                     members: util.ArrayList[Member],
                     tags: util.ArrayList[Tag])

case class Member(
                   mtype: String,
                   ref: Long,
                   role: String)

