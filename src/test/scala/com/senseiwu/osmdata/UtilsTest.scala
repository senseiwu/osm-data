package com.senseiwu.osmdata

/**
 * Created by tomek on 8/25/15.
 */

import org.scalatest.FunSuite

class UtilsTest extends FunSuite {
  test("Distance should be correct") {
    assert(utils.range2dist(1000) == 0.009)
    assert(utils.range2dist(2000) == 0.018)
  }
}
