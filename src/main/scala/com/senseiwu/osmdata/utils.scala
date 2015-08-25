package com.senseiwu.osmdata

import com.senseiwu.osmdata.poi.Coordinate


/**
 * Created by tomek on 8/25/15.
 */

object utils {
  private def deg2rad(deg: Double) = deg * Math.PI / 180.0
  private def rad2deg(rad: Double) = rad / Math.PI * 180.0
  def calculateDistance(c1:Coordinate, c2:Coordinate) = {
    val theta = c1.lon - c2.lon
    val dist = Math.sin(deg2rad(c1.lat)) * Math.sin(deg2rad(c2.lat)) + Math.cos(deg2rad(c1.lat)) *
      Math.cos(deg2rad(c2.lat)) * Math.cos(deg2rad(theta))
    Math.abs(
      Math.round(
        rad2deg(Math.acos(dist)) * 60 * 1.1515 * 1.609344 * 1000)
    )
  }

  // 1001m - 0.009
  // range m - x
  val DistCoord = 0.009
  val DistMeters = 1000.0
  def range2dist(range:Int):Double = (range * DistCoord) / DistMeters
}
