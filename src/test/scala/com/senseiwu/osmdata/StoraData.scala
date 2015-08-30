package com.senseiwu.osmdata

import com.mongodb.casbah.Imports._
import com.senseiwu.osmdata.poi._
import org.scalatest.FunSuite

/**
 * Created by tomek on 8/29/15.
 */
class StoraData extends FunSuite {

  val mongo = Mongo(MongoClient(), "poi")
  val db = mongo.getdb
  db.dropDatabase()
  val col = mongo.collection(common.Key)
  col.createIndex(MongoDBObject("loc" -> "2d"))

  val PARKIMG = "http://www.tapeciarnia.pl/tapety/normalne/87536_park_laweczka_drogowskaz_grafika.jpg"

  val point1 =
    common.node(
      22.531359,113.95203,
      common.info("","http://i1.s2.dpfile.com/pc/12b25724dee7fbc23a992b9e5c08343b%28700x700%29/thumb.jpg",""),
      substance.restaurant("Xiao Ben Bake Restourant"))

  val point2 =
    common.node(
      22.523238,113.941446,
      common.info("","http://img3.fengniao.com/album/upload/2/269/53735/10746969.jpg",""),
      shop.mall("Costal city"))

  val point3 =
    common.node(
      22.549906,113.976205,
      common.info("","http://s3-media2.fl.yelpcdn.com/bphoto/vD_pIgdac01qaQqSTp92pg/348s.jpg",""),
      substance.restaurant("A She Dong Ting Restaurant"))

  val point4 =
    common.node(
      22.541765,113.936094,
      common.info("","http://www.hqcyw.cn/Uploads/2014050809483601.jpg",""),
      leisure.park("Li Xiang Park"))

  val point5 =
    common.node(
      22.54078,113.979491,
      common.info("","http://www.alltrip.cn/UploadFile/CityImages_34556.jpg",""),
      shop.mall("Window Of The World"))

  val point6 =
    common.node(
      22.546722,113.98675,
      common.info("","http://www.517dv.com/upload/custom/00/00/00/00/88/92.1.jpg",""),
      shop.mall("Happy Valley"))

  val point7 =
    common.node(
      22.529523,113.998133,
      common.info("","http://img.pconline.com.cn/images/upload/upc/tx/photoblog/1204/21/c4/11326725_11326725_1334983441409_mthumb.jpg",""),
      leisure.park("Happy Harbour"))

  val point8 =
    common.node(
      22.540385,114.060326,
      common.info("","http://www.shenzhentour.com/UserFiles/Image/3%2813%29.jpg",""),
      shop.mall("Coco Park"))

  val point9 =
    common.node(
      22.546596,113.927084,
      common.info("","http://www.china.com.cn/ch-pic/guangdong/zm/070418_1350/135.jpg",""),
      historic.museum("Nan Tou Gu Cheng Museum"))

  /**
   *
  Bao'an Park
   img: https://c1.staticflickr.com/5/4088/5032282065_d4c21ec75b_b.jpg
Bao'an, Shenzhen, Guangdong, Chiny
22.585967, 113.903323
   */
  val point10 =
    common.node(
      22.585967, 113.903323,
      common.info("","https://c1.staticflickr.com/5/4088/5032282065_d4c21ec75b_b.jpg",""),
      leisure.park("Bao'an Park"))

  /**
   *
  Safari Park
   img: http://www.easytourchina.com/images/Photo/safari-park/p733_d20110402131755.jpg
Nanshan, Shenzhen, Guangdong, Chiny
22.597162, 113.974487
   */
  val point11 =
    common.node(
      22.597162, 113.974487,
      common.info("","http://www.easytourchina.com/images/Photo/safari-park/p733_d20110402131755.jpg",""),
      leisure.park("Safari Park"))

  /**
   *
  Yangtaishan Forest Park
   img: http://www.wozaisz.com/shenzhen/uploads/allimg/c121108/1352359C5K0-b1I.jpg
Bao'an, Shenzhen, Guangdong, Chiny
22.658318, 113.962362
   */
  val point12 =
    common.node(
      22.658318, 113.962362,
      common.info("","http://www.wozaisz.com/shenzhen/uploads/allimg/c121108/1352359C5K0-b1I.jpg",""),
      leisure.park("Yangtaishan Forest Park"))

  /**
   *
  Dadingling Shanlin Park
Bao'an, Shenzhen, Guangdong, Chiny
22.745827, 113.982274
   */
  val point13 =
    common.node(
      22.745827, 113.982274,
      common.info("","",""),
      leisure.park("Dadingling Shanlin Park"))

  /**
   *
  Honghuashan Park
   img: http://static.panoramio.com/photos/large/43923332.jpg
Bao'an, Shenzhen, Guangdong, Chiny
22.778435, 113.900564
   */
  val point14 =
    common.node(
      22.778435, 113.900564,
      common.info("","http://static.panoramio.com/photos/large/43923332.jpg",""),
      leisure.park("Honghuashan Park"))

  /**
   *
  Qingxi Forest Park
   img: http://www.chinatouradvisors.com/members/3307/tower%283%29.jpg
Dongguan, Guangdong, Chiny
22.879502, 114.165903
   */
  val point15 =
    common.node(
      22.879502, 114.165903,
      common.info("","http://www.chinatouradvisors.com/members/3307/tower%283%29.jpg",""),
      leisure.park("Qingxi Forest Park"))

  /**
   *
  Guangdong Guanyin Mountain National Forest Park
   img: http://www.visionsoftravel.org/wp-content/uploads/2014/06/NanhaiBaofengTempleatXiqiaoMountainFoShanBigBuddhaGuangdong1.jpg
Dongguan, Guangdong, Chiny
22.898751, 114.111770
   */
  val point16 =
    common.node(
      22.898751, 114.111770,
      common.info("","http://www.visionsoftravel.org/wp-content/uploads/2014/06/NanhaiBaofengTempleatXiqiaoMountainFoShanBigBuddhaGuangdong1.jpg",""),
      leisure.park("Guangdong Guanyin Mountain National Forest Park"))

  /**
   *
  Tanglangshan Country Park
   img: http://media-cdn.tripadvisor.com/media/photo-s/05/b0/81/68/park.jpg
Nanshan, Shenzhen, Guangdong, Chiny
22.570532, 114.007534
   */
  val point17 =
    common.node(
      22.570532, 114.007534,
      common.info("","http://media-cdn.tripadvisor.com/media/photo-s/05/b0/81/68/park.jpg",""),
      leisure.park("Tanglangshan Country Park"))

  /**
   *
  Luohu Linguochang
   img: http://static.panoramio.com/photos/large/5191244.jpg
Luohu, Shenzhen, Guangdong, Chiny
22.581740, 114.163390
   */
  val point18 =
    common.node(
      22.581740, 114.163390,
      common.info("","http://static.panoramio.com/photos/large/5191244.jpg",""),
      leisure.park("Luohu Linguochang"))

  /**
   *
  Guangdong Wutongshan National Forest Garden
   img: http://farm1.static.flickr.com/227/462848822_2356772064.jpg
Shenzhen, Guangdong, Chiny
22.589137, 114.219954
   */
  val point19 =
    common.node(
      22.589137, 114.219954,
      common.info("","http://farm1.static.flickr.com/227/462848822_2356772064.jpg",""),
      leisure.park("Guangdong Wutongshan National Forest Garden"))

  /**
   *
  Xiaxue Community Park
Shenzhen, Guangdong, Chiny
22.654189, 114.089401
   */
  val point20 =
    common.node(
      22.654189, 114.089401,
      common.info("",PARKIMG,""),
      leisure.park("Xiaxue Community Park"))

  /**
   *
  Pinghu Ecological Garden
Longgang, Shenzhen, Guangdong, Chiny
22.670109, 114.103563
   */
  val point21 =
    common.node(
      22.670109, 114.103563,
      common.info("",PARKIMG,""),
      leisure.park("Pinghu Ecological Garden"))

  /**
   *
  Xialilang Park
Longgang, Shenzhen, Guangdong, Chiny
22.641990, 114.134290
   */
  val point22 =
    common.node(
      22.641990, 114.134290,
      common.info("",PARKIMG,""),
      leisure.park("Xialilang Park"))

  /**
   *
  Shiyaling Park
Longgang, Shenzhen, Guangdong, Chiny
22.619095, 114.130943
   */
  val point23 =
    common.node(
      22.619095, 114.130943,
      common.info("",PARKIMG,""),
      leisure.park("Shiyaling Park"))

  /**
   *
  Dong Qin Lu
Longgang Qu, Shenzhen Shi, Guangdong Sheng, Chiny
22.645476, 114.158151
   */
  val point24 =
    common.node(
      22.645476, 114.158151,
      common.info("",PARKIMG,""),
      leisure.park("Dong Qin Lu"))

  /**
   *
  Yanhu Park
Dongguan, Guangdong, Chiny
22.696521, 114.160276
   */
  val point25 =
    common.node(
      22.696521, 114.160276,
      common.info("",PARKIMG,""),
      leisure.park("Yanhu Park"))

  /**
   * Jiahuihui Longfeng Mountain Villa Film & Television Base
Dongguan, Guangdong
Chiny
22.712980, 114.191762
   */
  val point26 =
    common.node(
      22.712980, 114.191762,
      common.info("",PARKIMG,""),
      leisure.park("Jiahuihui Longfeng Mountain Villa Film & Television Base"))

  /**
   *
  Dayun Natural Park
Longgang, Shenzhen, Guangdong, Chiny
22.690866, 114.210312
   */
  val point27 =
    common.node(
      22.690866, 114.210312,
      common.info("",PARKIMG,""),
      leisure.park("Dayun Natural Park"))

  /**
   * Shenzhenwan Park
Nanshan, Shenzhen, Guangdong
Chiny
  Deep Bay (Shenzhen Bay)
22.502878, 113.955569
   */
  val point28 =
    common.node(
      22.502878, 113.955569,
      common.info("",PARKIMG,""),
      leisure.park("Shenzhenwan Park"))

  /**
   *
  Lilin Park
Nanshan, Shenzhen, Guangdong, Chiny
22.506745, 113.911614
   */
  val point29 =
    common.node(
      22.506745, 113.911614,
      common.info("",PARKIMG,""),
      leisure.park("Lilin Park"))

  /**
   *
  Xiaonanshan Park
Nanshan, Shenzhen, Guangdong, Chiny
22.482472, 113.883972
   */
  val point30 =
    common.node(
      22.482472, 113.883972,
      common.info("",PARKIMG,""),
      leisure.park("Xiaonanshan Park"))

  /**
   *
  Shenzhen Danan Mountain Reform and Open Memorial Park
Nanshan, Shenzhen, Guangdong, Chiny
22.493630, 113.905451
   */
  val point31 =
    common.node(
      22.493630, 113.905451,
      common.info("",PARKIMG,""),
      leisure.park("Shenzhen Danan Mountain Reform and Open Memorial Park"))

  /**
   *
  Zhongshan Park
Nanshan, Shenzhen, Guangdong, Chiny
22.546750, 113.918791
   */
  val point32 =
    common.node(
      22.546750, 113.918791,
      common.info("",PARKIMG,""),
      leisure.park("Zhongshan Park"))

  /**
   *
  Tiezaishan Park
Bao'an, Shenzhen, Guangdong, Chiny
22.591974, 113.863707
   */
  val point33 =
    common.node(
      22.591974, 113.863707,
      common.info("",PARKIMG,""),
      leisure.park("Tiezaishan Park"))

  col.insert(point1)
  col.insert(point2)
  col.insert(point3)
  col.insert(point4)
  col.insert(point5)
  col.insert(point6)
  col.insert(point7)
  col.insert(point8)
  col.insert(point9)
  col.insert(point10)

  col.insert(point11)
  col.insert(point12)
  col.insert(point13)
  col.insert(point14)
  col.insert(point15)
  col.insert(point16)
  col.insert(point17)
  col.insert(point18)
  col.insert(point19)
  col.insert(point20)

  col.insert(point21)
  col.insert(point22)
  col.insert(point23)
  col.insert(point24)
  col.insert(point25)
  col.insert(point26)
  col.insert(point27)
  col.insert(point28)
  col.insert(point29)
  col.insert(point30)

  col.insert(point31)
  col.insert(point32)
  col.insert(point33)
//  col.insert(point)
//  col.insert(point)
//  col.insert(point)
//  col.insert(point)
//  col.insert(point)
//  col.insert(point)

  test("Check one") {
    assert(4 == mongo.findForType(col, shop.Key).size)
  }

}
